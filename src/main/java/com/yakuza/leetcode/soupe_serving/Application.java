package com.yakuza.leetcode.soupe_serving;

import org.apache.commons.math3.distribution.EnumeratedDistribution;
import org.apache.commons.math3.util.Pair;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static class Soup {

        private final String name;

        private BigInteger capacity;

        Soup(String name, BigInteger capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    public static class SoupSet {

        private final Soup soupA;

        private final Soup soupB;

        public SoupSet(BigInteger amount) {
            this.soupA = new Soup("A", amount);
            this.soupB = new Soup("A", amount);
        }
    }


    public static class Operation {

        private final BigInteger useSoupA;

        private final BigInteger useSoupB;

        Operation(BigInteger useSoupA, BigInteger useSoupB) {
            this.useSoupA = useSoupA;
            this.useSoupB = useSoupB;
        }

        public void apply(SoupSet soupSet) {

        }
    }

    private static List<Pair<Operation, Double>> possibleOperations = new ArrayList<>();

    static {
        possibleOperations.add(new Pair<Operation, Double>(new Operation(BigInteger.valueOf(100L), BigInteger.valueOf(0L)), 0.25));
        possibleOperations.add(new Pair<Operation, Double>(new Operation(BigInteger.valueOf(75L), BigInteger.valueOf(25L)), 0.25));
        possibleOperations.add(new Pair<Operation, Double>(new Operation(BigInteger.valueOf(50L), BigInteger.valueOf(50L)), 0.25));
        possibleOperations.add(new Pair<Operation, Double>(new Operation(BigInteger.valueOf(25L), BigInteger.valueOf(75L)), 0.25));
    }

    private static EnumeratedDistribution<Operation> operationsDistribution = new EnumeratedDistribution<Operation>(possibleOperations);

    static Operation getRandomOperation() {
        return operationsDistribution.sample();
    }

    public static void main(String[] args) {

        if (args == null || args.length == 0) {
            System.out.println("The amount of soup is empty. Please set the amount of soup (0 <= N <= 10^9).");
            return;
        }

        BigInteger initialAmountOfSoup = new BigInteger(args[0]);
        SoupSet soupSet = new SoupSet(initialAmountOfSoup);

        Operation currentOperation =  getRandomOperation();
        currentOperation.apply(soupSet);

        String result = "";
    }

}
