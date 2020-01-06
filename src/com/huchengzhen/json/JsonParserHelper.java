package com.huchengzhen.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonParserHelper {

    char[] chars;
    int current = -1;

    public Object parser(String json) throws Exception {
        chars = json.toCharArray();
        current = 0;
        return readObject();
    }

    private Object readObject() throws Exception {
        return switch (nextNotEmptyChar()) {
            case 'n' -> readNull();
            case 'f' -> readFalse();
            case 't' -> readTrue();
            case '"' -> readString();
            case '{' -> readMap();
            case '[' -> readList();
            case '-', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> readNumber();
            default -> null;
        };
    }

    private String readString() {
        nextNotEmptyCharAndMove();
        StringBuilder builder = new StringBuilder();
        while (chars[current] != '"') {
            builder.append(chars[current++]);
        }
        current++;
        return builder.toString();
    }

    private String readFalse() throws Exception {
        current++;
        if (nextNotEmptyCharAndMove() != 'a') throw new Exception();
        if (nextNotEmptyCharAndMove() != 'l') throw new Exception();
        if (nextNotEmptyCharAndMove() != 's') throw new Exception();
        if (nextNotEmptyCharAndMove() != 'e') throw new Exception();
        return "false";
    }

    private String readNull() throws Exception {
        current++;
        if (nextNotEmptyCharAndMove() != 'u') throw new Exception();
        if (nextNotEmptyCharAndMove() != 'l') throw new Exception();
        if (nextNotEmptyCharAndMove() != 'l') throw new Exception();
        return "null";
    }

    private String readTrue() throws Exception {
        current++;
        if (nextNotEmptyCharAndMove() != 'r') throw new Exception();
        if (nextNotEmptyCharAndMove() != 'u') throw new Exception();
        if (nextNotEmptyCharAndMove() != 'e') throw new Exception();
        return "true";
    }

    private Map<String, Object> readMap() throws Exception {
        current++;
        Map<String, Object> map = new HashMap<>();
        boolean isFirst = true;
        for (; ; ) {
            if (nextNotEmptyChar() == '}') {
                current++;
                break;
            }
            if (!isFirst) {
                if (nextNotEmptyCharAndMove() != ',') throw new Exception();
            }
            String key = readString();
            if (nextNotEmptyCharAndMove() != ':') throw new Exception();
            Object value = readObject();
            map.put(key, value);
            isFirst = false;
        }
        return map;
    }

    private List<Object> readList() throws Exception {
        current++;
        boolean isFirst = true;
        List<Object> list = new ArrayList<>();
        for (; ; ) {
            if (nextNotEmptyChar() == ']') {
                current++;
                break;
            }
            if (!isFirst) {
                if (nextNotEmptyCharAndMove() != ',') throw new Exception();
            }
            Object object = readObject();
            list.add(object);
            isFirst = false;
        }
        return list;
    }

    private double readNumber() {
        StringBuilder builder = new StringBuilder();
        builder.append(chars[current++]);
        while (betweenNumber(chars[current])) {
            builder.append(chars[current++]);
        }
        String numberString = builder.toString();
        return Double.parseDouble(numberString);
    }

    private boolean betweenNumber(char c) {
        return ('0' <= c && c <= '9') || c == '.';
    }

    private char nextNotEmptyChar() {
        while (chars[current] == ' ' || chars[current] == '\n') {
            current++;
        }
        return chars[current];
    }

    private char nextNotEmptyCharAndMove(){
        char c = nextNotEmptyChar();
        current++;
        return c;
    }
}
