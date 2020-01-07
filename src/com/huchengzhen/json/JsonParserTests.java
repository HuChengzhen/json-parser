package com.huchengzhen.json;

import org.junit.jupiter.api.Test;

public class JsonParserTests {
    @Test
    public void tests() throws Exception {
        String jsonString = """
                {"menu": {
                  "id": "file",
                  "value": "File",
                  "popup": {
                    "menuitem": [
                      {"value": "New", "onclick": "CreateNewDoc()"},
                      {"value": "Open", "onclick": "OpenDoc()"},
                      {"value": "Close", "onclick": "CloseDoc()"}
                    ]
                  }
                }}""";

        Object jsonObject = JsonParser.parser(jsonString);
        System.out.println(jsonObject);
    }

    @Test
    public void test2() throws Exception {
        String jsonString = """
                {"widget": {
                    "debug": "on",
                    "window": {
                        "title": "Sample Konfabulator Widget",
                        "name": "main_window",
                        "width": 500,
                        "height": 500
                    },
                    "image": {\040
                        "src": "Images/Sun.png",
                        "name": "sun1",
                        "hOffset": true,
                        "vOffset": false,
                        "alignment": null
                    },
                    "text": {
                        "data": "Click Here",
                        "size": 36,
                        "style": "bold",
                        "name": "text1",
                        "hOffset": 250,
                        "vOffset": 100,
                        "alignment": "center",
                        "onMouseUp": "sun1.opacity = (sun1.opacity / 100) * 90;"
                    }
                }}""";

        Object jsonObject = JsonParser.parser(jsonString);
        System.out.println(jsonObject);
    }

    @Test
    public void test3() throws Exception {
        String jsonString = """
                {"web-app": {
                  "servlet": [\040\040\040
                    {
                      "servlet-name": "cofaxCDS",
                      "servlet-class": "org.cofax.cds.CDSServlet",
                      "init-param": {
                        "configGlossary:installationAt": "Philadelphia, PA",
                        "configGlossary:adminEmail": "ksm@pobox.com",
                        "configGlossary:poweredBy": "Cofax",
                        "configGlossary:poweredByIcon": "/images/cofax.gif",
                        "configGlossary:staticPath": "/content/static",
                        "templateProcessorClass": "org.cofax.WysiwygTemplate",
                        "templateLoaderClass": "org.cofax.FilesTemplateLoader",
                        "templatePath": "templates",
                        "templateOverridePath": "",
                        "defaultListTemplate": "listTemplate.htm",
                        "defaultFileTemplate": "articleTemplate.htm",
                        "useJSP": false,
                        "jspListTemplate": "listTemplate.jsp",
                        "jspFileTemplate": "articleTemplate.jsp",
                        "cachePackageTagsTrack": 200,
                        "cachePackageTagsStore": 200,
                        "cachePackageTagsRefresh": 60,
                        "cacheTemplatesTrack": 100,
                        "cacheTemplatesStore": 50,
                        "cacheTemplatesRefresh": 15,
                        "cachePagesTrack": 200,
                        "cachePagesStore": 100,
                        "cachePagesRefresh": 10,
                        "cachePagesDirtyRead": 10,
                        "searchEngineListTemplate": "forSearchEnginesList.htm",
                        "searchEngineFileTemplate": "forSearchEngines.htm",
                        "searchEngineRobotsDb": "WEB-INF/robots.db",
                        "useDataStore": true,
                        "dataStoreClass": "org.cofax.SqlDataStore",
                        "redirectionClass": "org.cofax.SqlRedirection",
                        "dataStoreName": "cofax",
                        "dataStoreDriver": "com.microsoft.jdbc.sqlserver.SQLServerDriver",
                        "dataStoreUrl": "jdbc:microsoft:sqlserver://LOCALHOST:1433;DatabaseName=goon",
                        "dataStoreUser": "sa",
                        "dataStorePassword": "dataStoreTestQuery",
                        "dataStoreTestQuery": "SET NOCOUNT ON;select test='test';",
                        "dataStoreLogFile": "/usr/local/tomcat/logs/datastore.log",
                        "dataStoreInitConns": 10,
                        "dataStoreMaxConns": 100,
                        "dataStoreConnUsageLimit": 100,
                        "dataStoreLogLevel": "debug",
                        "maxUrlLength": 500}},
                    {
                      "servlet-name": "cofaxEmail",
                      "servlet-class": "org.cofax.cds.EmailServlet",
                      "init-param": {
                      "mailHost": "mail1",
                      "mailHostOverride": "mail2"}},
                    {
                      "servlet-name": "cofaxAdmin",
                      "servlet-class": "org.cofax.cds.AdminServlet"},
                \040
                    {
                      "servlet-name": "fileServlet",
                      "servlet-class": "org.cofax.cds.FileServlet"},
                    {
                      "servlet-name": "cofaxTools",
                      "servlet-class": "org.cofax.cms.CofaxToolsServlet",
                      "init-param": {
                        "templatePath": "toolstemplates/",
                        "log": 1,
                        "logLocation": "/usr/local/tomcat/logs/CofaxTools.log",
                        "logMaxSize": "",
                        "dataLog": 1,
                        "dataLogLocation": "/usr/local/tomcat/logs/dataLog.log",
                        "dataLogMaxSize": "",
                        "removePageCache": "/content/admin/remove?cache=pages&id=",
                        "removeTemplateCache": "/content/admin/remove?cache=templates&id=",
                        "fileTransferFolder": "/usr/local/tomcat/webapps/content/fileTransferFolder",
                        "lookInContext": 1,
                        "adminGroupID": 4,
                        "betaServer": true}}],
                  "servlet-mapping": {
                    "cofaxCDS": "/",
                    "cofaxEmail": "/cofaxutil/aemail/*",
                    "cofaxAdmin": "/admin/*",
                    "fileServlet": "/static/*",
                    "cofaxTools": "/tools/*"},
                \040
                  "taglib": {
                    "taglib-uri": "cofax.tld",
                    "taglib-location": "/WEB-INF/tlds/cofax.tld"}}}""";

        Object object = JsonParser.parser(jsonString);
        System.out.println(object);
    }
}
