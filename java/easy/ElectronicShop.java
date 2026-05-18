// https://www.hackerrank.com/challenges/electronics-shop/problem


package java.easy;

import java.util.*;

public class ElectronicShop {

    public static int getMoneySpent(int[] keyboards, int[] drives, int b) {

        Arrays.sort(keyboards); // ascending
        Arrays.sort(drives);    // ascending

        int i = 0;
        int j = drives.length - 1;
        int maxCost = -1;

        while (i < keyboards.length && j >= 0) {
            int total = keyboards[i] + drives[j];

            if (total > b) {
                j--; // reduce cost
            } else {
                maxCost = Math.max(maxCost, total);
                i++; // try bigger keyboard
            }
        }

        return maxCost;
    }
}