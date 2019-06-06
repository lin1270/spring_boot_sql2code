# spring_boot_sql2code
spring boot框架，根據SQL創建語句，自動生成 model、mapper、controller、service，MVC層。  

小子並未製作成命令模式，所以需要手動加上node作為驅動。
<br><br><br>

# 使用說明:
需要輸入->類名->SQL文件名->URL路徑，  
如：  
```
node _.js className className.sql className
```
可加入拷貝到工程文件下功能：  
```
node _.js className className.sql className /c _cfg1.json  
```

具体可參照內部的內容。   
  
  
  
<br><br><br>
  
如果不符合您的需求，請自行修改源碼：  
修改JAVA與SQL類型轉換(_type.json)：
```json
[
    ["BIT(1)", "Boolean"],
    ["BIT", "byte[]"],
    ["TINYINT", "Integer"],
    ["BOOL", "Boolean"],
    ["SMALLINT", "Integer"],
    ["MEDIUMINT", "Integer"],
    ["INT", "Integer"],
    ["FLOAT", "Float"],
    ["DOUBLE", "Double"],
    ["DECIMAL", "Double"],
    ["DATETIME", "Timestamp"],
    ["DATE", "Date"],
    ["TIME", "Time"],
    ["CHAR", "String"],
    ["VARCHAR", "String"],
    ["BINARY", "byte[]"],
    ["VARBINARY", "byte[]"],
    ["TINYTEXT", "byte[]"],
    ["BLOB", "byte[]"],
    ["TEXT", "String"],
    ["MEDIUMBLOB", "byte[]"],
    ["MEDIUMTEXT", "String"],
    ["LONGBLOB", "byte[]"],
    ["LONGTEXT", "String"],
    ["ENUM", "String"],
    ["SET", "String"]
]
```
  
  

<br><br><br>
修改忽略的數據庫KEY (_ignoreKey.json)：
```json
[
    "TENANT_ID_",
    "DELFLAG_",
    "CREATED_BY_ID_",
    "CREATED_BY_NAME_",
    "CREATED_TIME_",
    "MODIFIED_BY_ID_",
    "MODIFIED_BY_NAME_",
    "MODIFIED_TIME_",
    "DISPLAY_ORDER_",
    "VERSION_"
]
```


<br><br><br>
  
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
