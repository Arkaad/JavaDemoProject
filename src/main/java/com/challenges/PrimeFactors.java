package com.challenges;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {
    public static List<Integer> primeFactors(int number) {
        int n = number;
        List<Integer> factors = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        return factors;
    }

    public static void main(String[] args) {
        System.out.println("Prime factors of 6");
        for (Integer integer : primeFactors(6)) {
            System.out.println(integer);
        }
        System.out.println("Prime factors of 5");
        for (Integer integer : primeFactors(5)) {
            System.out.println(integer);
        }
        System.out.println("Prime factors of 12");
        for (Integer integer : primeFactors(12)) {
            System.out.println(integer);
        }
    }
}
