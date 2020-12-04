package com.challenges;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindIP {
    public static void findSuccessIpCount(String record) {
        String regex = "(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(record);

        Map<String, Integer> countIP = new LinkedHashMap<>();
        while (matcher.find()) {

            String IP = matcher.group();
            if (countIP.containsKey(IP)) {
                countIP.put(IP, countIP.get(IP) + 1);
            } else {
                countIP.put(IP, 1);
            }

        }

        for (Map.Entry<String, Integer> entry : countIP.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        String log = "10.0.0.1-frank[10/Dec/2000:12:34:56-0500]\\\"GET /a.gif HTTp/1.0\\\"100 134";
        findSuccessIpCount(log);
    }
}
