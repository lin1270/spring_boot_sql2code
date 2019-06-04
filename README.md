# spring_boot_sql2code

小子並未製作成命令模式，所以需要手動加上node作為驅動。


# 使用說明:
```
需要輸入->類名->SQL文件名->URL路徑，  
如：  
node _.js className className.sql className
```
可加入拷貝到工程文件下：  
```
node _.js className className.sql className /c _cfg1.json  
```

具体可參照內部的內容。   


如果不符合您的需求，請自行修改源碼：  
修改JAVA與SQL類型轉換：
```java
function generatorMySqlTyp2JavaTypeMap() {
    if (mysqltype2javatype.length) return;

    mysqltype2javatype['BIT(1)'] = 'Boolean'
    mysqltype2javatype['BIT'] = 'byte[]'
    mysqltype2javatype['TINYINT'] = 'Integer'
    mysqltype2javatype['BOOL'] = 'Boolean'
    mysqltype2javatype['SMALLINT'] = 'Integer'
    mysqltype2javatype['MEDIUMINT'] = 'Integer'
    mysqltype2javatype['INT'] = 'Integer'
    mysqltype2javatype['FLOAT'] = 'Float'
    mysqltype2javatype['DOUBLE'] = 'Double'
    mysqltype2javatype['DECIMAL'] = 'Double'
    mysqltype2javatype['DATETIME'] = 'Timestamp'
    mysqltype2javatype['DATE'] = 'Date'
    mysqltype2javatype['TIMESTAMP'] = 'Timestamp'
    mysqltype2javatype['TIME'] = 'Time'
    mysqltype2javatype['CHAR'] = 'String'
    mysqltype2javatype['VARCHAR'] = 'String'
    mysqltype2javatype['BINARY'] = 'byte[]'
    mysqltype2javatype['VARBINARY'] = 'byte[]'
    mysqltype2javatype['TINYBLOB'] = 'byte[]'
    mysqltype2javatype['TINYTEXT'] = 'byte[]'
    mysqltype2javatype['BLOB'] = 'byte[]'
    mysqltype2javatype['TEXT'] = 'String'
    mysqltype2javatype['MEDIUMBLOB'] = 'byte[]'
    mysqltype2javatype['MEDIUMTEXT'] = 'String'
    mysqltype2javatype['LONGBLOB'] = 'byte[]'
    mysqltype2javatype['LONGTEXT'] = 'String'
    mysqltype2javatype['ENUM'] = 'String'
    mysqltype2javatype['SET'] = 'String'
    mysqltype2javatype['xxxxxx'] = 'xxxxxx'
}
```

修改拷貝到工程路徑：
```java
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
```
