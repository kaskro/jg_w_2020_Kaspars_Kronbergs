package lv.javaguru.homework.lesson2.level2;

import java.util.Random;

public class RandomNumbersServiceTest {
    public static void main(String[] args) {

        Random randomGenerator = new Random();

        int firstRandomNumber = randomGenerator.nextInt(100);
        int secondRandomNumber = randomGenerator.nextInt(100);
        int thirdRandomNumber = randomGenerator.nextInt(100);
        int sum = firstRandomNumber + secondRandomNumber + thirdRandomNumber;
        System.out.print(firstRandomNumber + " + ");
        System.out.print(secondRandomNumber + " + ");
        System.out.print(thirdRandomNumber + " = ");
        //summu labāk iznest atsevišķā mainīgajā
        //tā programma būs vieglāk saprotama
        System.out.println(sum);
    }
}
