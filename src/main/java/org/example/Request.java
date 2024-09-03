package org.example;

import java.util.HashMap;
import java.util.Map;

public class Request {
    private final Map<String, String[]> params = new HashMap<>();

    // 명령 command를 받는 위치
    public Request(String command) {
        String[] commandList = command.split("\\?", 2);

        if (commandList.length == 1) return;

        String[] paramsList = commandList[1].split("&");

        for (String paramsRow : paramsList) {
            String[] paramsStr = paramsRow.split("=", 2);
            String key = paramsStr[0];
            String value = paramsStr.length > 1 ? paramsStr[1] : "";
            params.computeIfAbsent(key, k -> new String[0]);
            params.put(key, appendToArray(params.get(key), value));
        }
    }

    // params 맵에서 key가 있으면 해당 값 반환, 없으면 빈 배열 반환
    public String[] getParams(String key) {
        return params.getOrDefault(key, new String[0]);
    }

    // 기존 배열에 새 값을 추가한 배열 생성
    private String[] appendToArray(String[] array, String value) {
        String[] newArray = new String[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = value;
        return newArray;
    }
}
