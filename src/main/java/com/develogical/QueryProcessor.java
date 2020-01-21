package com.develogical;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryProcessor {

  static List<Integer> getNumbers(String s) {
    List<Integer> numbers = new ArrayList<>();
    Pattern p = Pattern.compile("\\d+");
    Matcher m = p.matcher(s);
    while (m.find()) {
      numbers.add(Integer.parseInt(m.group()));
    }
    return numbers;
  }

  static boolean isPrime(int n) {
    int i, m = 0, flag = 0;
    m = n / 2;
    if (n == 0 || n == 1) {
      return false;
    } else {
      for (i = 2; i <= m; i++) {
        if (n % i == 0) {
          flag = 1;
          return false;
        }
      }
      return flag == 0;
    }
  }

  static boolean isSquare(int x) {
    final int sqrt = (int) Math.sqrt(x);
    return sqrt * sqrt == x;
  }

  static boolean isCube(int x) {
    for (int i = 0; i < Math.sqrt(x); i++) {
      if (i * i * i == x) {
        return true;
      }
    }
    return false;
  }

  static int fib(int n) {
    int a = 0, b = 1, c;
    if (n == 0) {
      return a;
    }
    for (int i = 2; i <= n; i++) {
      c = a + b;
      a = b;
      b = c;
    }
    return b;
  }

  public String process(String query) {
    query = query.replace("%20", " ");
    query = query.trim();
    if (query.toLowerCase().contains("shakespeare")) {
      return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
          "English poet, playwright, and actor, widely regarded as the greatest " +
          "writer in the English language and the world's pre-eminent dramatist.";
    } else if (query.toLowerCase().contains("team name")) {
      return "JIB";
    } else if (query.toLowerCase().contains("plus")) {
      List<Integer> numbers = getNumbers(query);
      int res = 0;
      for (Integer n : numbers) {
        res += n;
      }
      return String.valueOf(res);
    } else if (query.toLowerCase().contains("largest")) {
      String[] split = query.split("largest:");
      String[] nums = split[1].split(",\\s*");
      int res = Integer.MIN_VALUE;
      for (String num : nums) {
        res = Integer.max(Integer.parseInt(num.trim()), res);

      }
      return String.valueOf(res);
    } else if (query.toLowerCase().contains("multiplied")) {
      List<Integer> numbers = getNumbers(query);
      int res = 1;
      for (Integer n : numbers) {
        res *= n;
      }
      return String.valueOf(res);
    } else if (query.toLowerCase().contains("primes")) {
      List<Integer> numbers = getNumbers(query);
      StringBuilder res = new StringBuilder();
      for (Integer n : numbers) {
        if (isPrime(n)) {
          res.append(String.valueOf(n)).append(", ");
        }
      }
      String ans = res.toString();
      ans = ans.substring(0, ans.length() - 2);
      return ans;
    } else if (query.toLowerCase().contains("square")) {
      List<Integer> numbers = getNumbers(query);
      StringBuilder res = new StringBuilder();
      for (Integer n : numbers) {
        if (isSquare(n) && isCube(n)) {
          res.append(String.valueOf(n)).append(", ");
        }
      }
      String ans = res.toString();
      ans = ans.substring(0, ans.length() - 2);
      return ans;
    } else if (query.toLowerCase().contains("minus")) {
      List<Integer> numbers = getNumbers(query);
      int res = numbers.get(0) * 2;
      for (Integer n : numbers) {
        res -= n;
      }
      return String.valueOf(res);
    } else if (query.contains("Theresa")) {
      return "Theresa May was first elected in 2016.";
    } else if (query.toLowerCase().contains("fibonacci")) {
      List<Integer> numbers = getNumbers(query);
      int n = numbers.get(0);
      return String.valueOf(fib(n));
    } else if (query.contains("Eiffel")) {
      return "The Eiffel tower is in Paris.";
    } else if (query.contains("banana")) {
      return "A banana is yellow.";
    }
    return "";
  }
}
