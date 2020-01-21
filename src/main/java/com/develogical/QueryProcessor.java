package com.develogical;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryProcessor {

    public String process(String query) {
        query = query.trim();
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.toLowerCase().contains("team name")) {
            return "JIB";
        } else if (query.toLowerCase().contains("plus")) {
            List<Integer> numbers = getNumbers(query);
            return String.valueOf(numbers.get(0) + numbers.get(1));
        } else if (query.toLowerCase().contains("largest")) {
            String[] split = query.split("largest:");
            String[] nums = split[1].split(",\\s*");
            int res = Integer.MIN_VALUE;
            for (String num: nums) {
                res = Integer.max(Integer.parseInt(num.trim()), res);

            }
            return String.valueOf(res);
        } else if (query.toLowerCase().contains("multiplied")) {
            List<Integer> numbers = getNumbers(query);
            return String.valueOf(numbers.get(0) * numbers.get(1));
        }

        return "";
    }

    static List<Integer> getNumbers(String s) {
        List<Integer> numbers = new ArrayList<>();
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(s);
        while (m.find()) {
            numbers.add(Integer.parseInt(m.group()));
        }
        return numbers;
    }
}
