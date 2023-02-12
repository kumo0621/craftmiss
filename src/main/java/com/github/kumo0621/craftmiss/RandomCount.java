package com.github.kumo0621.craftmiss;
import java.util.Random;

public class RandomCount {
    public static int random() {
        Random rand = new Random();
        int num = rand.nextInt(craftmiss.zyougen);
        System.out.println(num);
        return num;
    }
}
