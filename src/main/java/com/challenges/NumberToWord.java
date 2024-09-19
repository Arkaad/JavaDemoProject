package com.challenges;


import java.util.Scanner;

public class NumberToWord {
    static String numberToWords(long n) {
        long limit = 1000000000000L, curr_hun, t = 0;
        if (n == 0)
            return ("Zero");
        String[] multiplier = {"", "Trillion", "Billion", "Million", "Thousand"};
        String[] firstTwenty = {
                "", "One", "Two", "Three",
                "Four", "Five", "Six", "Seven",
                "Eight", "Nine", "Ten", "Eleven",
                "Twelve", "Thirteen", "Fourteen", "Fifteen",
                "Sixteen", "Seventeen", "Eighteen", "Nineteen"
        };
        String[] tens = {"", "Twenty", "Thirty",
                "Forty", "Fifty", "Sixty",
                "Seventy", "Eighty", "Ninety"};

        if (n < 20L) {
            return (firstTwenty[(int) n]);
        }
        StringBuilder answer = new StringBuilder();
        for (long i = n; i > 0; i %= limit, limit /= 1000) {
            curr_hun = i / limit;
            while (curr_hun == 0) {
                i %= limit;
                limit /= 1000;
                curr_hun = i / limit;
                ++t;
            }
            if (curr_hun > 99) {
                answer.append(firstTwenty[(int) curr_hun / 100]).append(" Hundred ");
            }
            curr_hun = curr_hun % 100;
            if (curr_hun > 0 && curr_hun < 20) {
                answer.append(firstTwenty[(int) curr_hun]).append(" ");
            } else if (curr_hun % 10 == 0 && curr_hun != 0) {
                answer.append(tens[(int) curr_hun / 10 - 1]).append(" ");
            } else if (curr_hun > 20) {
                answer.append(tens[(int) curr_hun / 10 - 1]).append(" ").append(firstTwenty[(int) curr_hun % 10]).append(" ");
            }
            if (t < 4) {
                answer.append(multiplier[(int) ++t]).append(" ");
            }
        }
        return (answer.toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number: ");
        if (scanner.hasNextLong()) {
            long input = scanner.nextLong();
            System.out.println(numberToWords(input));
        }
    }
}
