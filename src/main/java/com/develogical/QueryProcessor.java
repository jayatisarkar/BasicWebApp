package com.develogical;

public class QueryProcessor {

    public String process(String query) {
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.toLowerCase().contains("team name")) {
            return "JIB";
        } else if (query.toLowerCase().contains("plus")) {
            String[] words = query.toLowerCase().split(" ");
            int no1 = Integer.parseInt(words[2]);
            int no2 = Integer.parseInt(words[4]);
            return String.valueOf(no1 + no2);
        }

        return "";
    }
}
