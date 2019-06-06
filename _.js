
var path = require('path')
var fs = require('fs')
var process = require('process')
const os = require('os');
var exec = require('child_process').exec;
var typeReflect = require('./_type.json')
var ignoreKey = require('./_ignoreKey.json')

const g_toReplace = 'XXXXXXXX'

var result = {}

function checkRunParam() {
    if (process.argv.length < 5) {
        console.error('需要輸入->類名->SQL文件名->URL路徑，如：node _.js className className.sql className')
        return null
    }

    const className = process.argv[2]
    const sqlPath = process.argv[3]
    const urlPath = process.argv[4]

    if (!className || !sqlPath || !urlPath) {
        console.error('需要輸入->類名->SQL文件名->URL路徑，如：node _.js className className.sql className')
        return null
    }

    let dstDir = ''

    if (process.argv.length >= 7) {
        if (process.argv[5].toLowerCase() === '/c') {
            const dstInfo = fs.readFileSync(path.join(process.cwd(), process.argv[6]), 'utf-8');
            if (dstInfo) {
                const dstJson = JSON.parse(dstInfo);
                if (dstJson) {
                    dstDir = dstJson.dir
                }
            }
        }
    }

    return {
        className,
        sqlPath,
        urlPath,
        dstDir,
    }
}

function getBaseContent(name) {
    const fullPath = path.join(process.cwd(), '/_/', g_toReplace + name);

    return fs.readFileSync(fullPath, 'utf-8');
}

function checkBase() {
    const model = getBaseContent('.java')
    const mapperJava = getBaseContent('Mapper.java')
    const mapperXml = getBaseContent('Mapper.xml')
    const controller = getBaseContent('RestController.java');
    const service = getBaseContent('Service.java');
    const serviceImpl = getBaseContent('ServiceImpl.java');

    if (!model || !mapperJava || !mapperXml || !controller || !service || !serviceImpl) {
        return null;
    }

    return {
        model,
        mapperJava,
        mapperXml,
        controller,
        service,
        serviceImpl
    }
}

String.prototype.replaceAll  = function(s1,s2) {     
    return this.replace(new RegExp(s1,"gm"),s2); 
}

function replaceClassName(base, param) {
    result = {
        model: result.model.replaceAll(g_toReplace, param.className),
        mapperJava: result.mapperJava.replaceAll(g_toReplace, param.className),
        mapperXml: result.mapperXml.replaceAll(g_toReplace, param.className),
        controller: result.controller.replaceAll(g_toReplace, param.className),
        service: result.service.replaceAll(g_toReplace, param.className),
        serviceImpl: result.serviceImpl.replaceAll(g_toReplace, param.className),
    }
}

function replacePath(base, param) {
    result.controller = result.controller.replace(g_toReplace + '_PATH', param.urlPath);
}


function midStr(str, begin, end) {
    if (!str) return;
    const beginPos = str.indexOf(begin);
    if (beginPos < 0) return '';

    const endPos = str.indexOf(end, beginPos + begin.length);
    if (endPos < 0) return '';

    return str.substring(beginPos + begin.length, endPos);
}

function sqlType2JavaType(type) {
    for(var [key,value] of typeReflect){
        if (type.indexOf(key) === 0) {
            return value;
        }
    }

    return null;
}

function generateTableColumnInfo(line) {
    const name = midStr(line, '`', '`');
    const comment = midStr(line, '\'', '\'');
    const typeStr = midStr(line, ' ', ' ');

    const type = sqlType2JavaType(typeStr.toUpperCase());
    if (!type) {
        console.log('無法映射type: ' + typeStr, line);
        return null;
    }

    return {
        name,
        type,
        comment,
    }
}

function generateTableName(line) {
    return midStr(line, '`', '`');
}

function generateTablePrimary(line) {
    return midStr(line, '`', '`');
}

function generateTableComment(line) {
    return midStr(line, 'COMMENT=\'', '\'');
}

function firstUpperCase(str) {
    if (!str) return '';
    return str.substring(0, 1).toUpperCase() + str.substring(1);
}

function getColumnSwitchName(name) {
    if (!name) return '';
    const arr = name.split('_');
    if (!arr || !arr.length) return name;

    let resultName = '';
    for(let i = 0; i < arr.length; ++i) {
        if (!arr[i]) break;
        const lowerPart = arr[i].toLowerCase();
        if (i === 0) {
            resultName += lowerPart;
        } else {
            resultName += firstUpperCase(lowerPart);
        }
    }

    return resultName;
}

function generatePropertyOfTableInfo(tableInfo) {
    let resultStr = '';
    for(const column of tableInfo.columns) {
        let oneInfo = '';
        if (column.name === tableInfo.primary) {
            oneInfo += '@Id\r\n';
            oneInfo += '\t@GeneratedValue(strategy=GenerationType.IDENTITY)\r\n'
        }
        oneInfo += `\t@ApiModelProperty("${column.comment}")\r\n`
        oneInfo += `\t@Column(name = "${column.name}")\r\n`
        oneInfo += `\tprivate ${column.type} ${getColumnSwitchName(column.name)};\r\n\r\n`

        resultStr += oneInfo;
    }

    return resultStr;
}

function generateGetsetOfTableInfo(tableInfo) {
    let resultStr = '';
    for(const column of tableInfo.columns) {
        const switchName = getColumnSwitchName(column.name);

        let getInfo = '';
        getInfo += `\tpublic ${column.type} ${getColumnSwitchName('get_' + column.name)}() {\r\n`
        getInfo += `\t\treturn ${switchName};\r\n`
        getInfo += '\t}\r\n\r\n'


        let setInfo = '';
        setInfo += `\tpublic void ${getColumnSwitchName('set_' + column.name)}(${column.type} ${switchName}) {\r\n`
        setInfo += `\t\tthis.${switchName} = ${switchName};\r\n`
        setInfo += '\t}\r\n\r\n'

        resultStr += getInfo + setInfo;
    }

    return resultStr;
}

function isIgnoreKey(key) {
    for(let item of ignoreKey) {
        if (item === key) {
            return true;
        }
    }

    return false;
}

function analyzeSql(param) {
    const fullPath = path.join(process.cwd(), param.sqlPath);
    let sqlContent = fs.readFileSync(fullPath, 'utf-8');
    if (!sqlContent) return null;

    sqlContent = sqlContent.replaceAll('\r\n', '\n');
    const lines = sqlContent.split('\n')

    let tableInfo = {
        name: '',
        primary: '',
        columns: [],
        comment: '',
    }
    for(let line of lines) {
        line = line.trim();
        if (line.indexOf('`') === 0) {
            const column = generateTableColumnInfo(line);
            if (!column) return null;
            if (!isIgnoreKey(column.name)) {
                tableInfo.columns.push(column);
            }
        }
        else if (line.indexOf('CREATE TABLE') === 0) {
            tableInfo.name = generateTableName(line);
        }
        else if (line.indexOf('PRIMARY KEY') === 0) {
            tableInfo.primary = generateTablePrimary(line);
        }
        else if (line.indexOf(') ENGINE=') === 0) {
            tableInfo.comment = generateTableComment(line);
        }
    }

    return tableInfo;
 }

function generatorModel(base, param) {
    const sqlInfo = analyzeSql(param); 
    if (!sqlInfo) {
        console.log('analyze db error');
        return false;
    }
    result.model = result.model.replace(g_toReplace + '_DB', sqlInfo.name);

    const properyInfo = generatePropertyOfTableInfo(sqlInfo);
    const getsetInfo = generateGetsetOfTableInfo(sqlInfo);
    
    result.model = result.model.replace(g_toReplace + '_CONTENT', `${properyInfo}\r\n${getsetInfo}`)

    return true;
}

function saveContent(param, name, content) {
    const fullPath = path.join(process.cwd(), '_result', param.className, param.className + name);
    
    fs.writeFileSync(fullPath, content, {encoding:'utf-8'})
}

function save(param) {
    const resultPath = path.join(process.cwd(), '_result');
    const fullPath = path.join(resultPath, param.className);

    if (!fs.existsSync(resultPath)) {
        fs.mkdir(resultPath);
    }

    if (!fs.existsSync(fullPath)) {
        fs.mkdir(fullPath)
    }

    saveContent(param, '.java', result.model);
    saveContent(param, 'Mapper.java', result.mapperJava);
    saveContent(param, 'Mapper.xml', result.mapperXml);
    saveContent(param, 'RestController.java', result.controller);
    saveContent(param, 'Service.java', result.service);
    saveContent(param, 'ServiceImpl.java', result.serviceImpl);

    const platform = os.platform();
    if (platform.indexOf('win') === 0) {
        exec(`explorer /e /root, ${fullPath}`)
    } else {
        exec(`open ${fullPath}`)
    }

    return true;
}




function copy2dstDir(param) {
    if (!param.dstDir) return;

    let name = '.java';
    let srcPath = path.join(process.cwd(), '_result', param.className, param.className + name);
    let dstPath = path.join(param.dstDir, 'model', param.className + name)
    fs.copyFileSync(srcPath, dstPath)


    name = 'Mapper.java'
    srcPath = path.join(process.cwd(), '_result', param.className, param.className + name);
    dstPath = path.join(param.dstDir, 'mapper', param.className + name)
    fs.copyFileSync(srcPath, dstPath)

    name = 'Mapper.xml'
    srcPath = path.join(process.cwd(), '_result', param.className, param.className + name);
    dstPath = path.join(param.dstDir, 'mapper', param.className + name)
    fs.copyFileSync(srcPath, dstPath)

    name = 'Service.java'
    srcPath = path.join(process.cwd(), '_result', param.className, param.className + name);
    dstPath = path.join(param.dstDir, 'service', param.className + name)
    fs.copyFileSync(srcPath, dstPath)

    name = 'ServiceImpl.java'
    srcPath = path.join(process.cwd(), '_result', param.className, param.className + name);
    dstPath = path.join(param.dstDir, 'service/impl', param.className + name)
    fs.copyFileSync(srcPath, dstPath)

    name = 'RestController.java'
    srcPath = path.join(process.cwd(), '_result', param.className, param.className + name);
    dstPath = path.join(param.dstDir, 'web/controller', param.className + name)
    fs.copyFileSync(srcPath, dstPath)
}

function go() {
    const param = checkRunParam()
    if (!param) return

    const base = checkBase()
    if (!base) return

    result = base;
    
    if (!generatorModel(base, param)) return

    replacePath(base, param);
    replaceClassName(base, param);

    if (save(param)) {
        // 自動拷貝到IDEA目錄
        copy2dstDir(param);

        console.log('save success');
    } else {
        console.log('save error');
    }    
}



go();