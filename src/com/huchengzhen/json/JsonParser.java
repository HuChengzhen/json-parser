package com.huchengzhen.json;

public class JsonParser {
    public static Object parser(String json) throws Exception {
        return new JsonParserHelper().parser(json);
    }
}
