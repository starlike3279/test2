package org.example;

import java.util.HashMap;
import java.util.Map;

public class Request {
    private final String actionCode;
    private final Map<String, String[]> params = new HashMap<>();

    public Request(String command) {
        String[] commandList = command.split("\\?", 2);

        actionCode = commandList[0];

        if (commandList.length == 1) return;

        String[] paramsList = commandList[1].split("&");

        for (String paramsRow : paramsList) {
            String[] paramsStr = paramsRow.split("=", 2);
            if (paramsStr.length == 2) {
                String key = paramsStr[0];
                String value = paramsStr[1];
                params.putIfAbsent(key, new String[]{});
                params.put(key, addToArray(params.get(key), value));
            }
        }
    }

    private String[] addToArray(String[] array, String value) {
        String[] newArray = new String[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = value;
        return newArray;
    }

    public String getActionCode() {
        return actionCode;
    }


    public String[] getParams(String key) {
        return params.get(key);
    }
}
