package ru.vsu.cs.lazutkina;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        double length = readDouble("length", "brick");
        double height = readDouble("height", "brick");
        double width = readDouble("width", "brick");

        double widthHole = readDouble("width", "hole");
        double heightHole = readDouble("height", "hole");

        outputResult(widthHole, heightHole, length, height, width);
    }

    private static double readDouble(String sizeName, String name)
    {
        Scanner scn = new Scanner(System.in);
        System.out.printf("Input the %s of the %s: ", sizeName, name);
        return checkPositiveAndZero(scn.nextDouble());
    }

    private static boolean checkBrickEntry(double widthHole, double heightHole, double length, double height, double width)
    {
        double smallerSideBrick = minimum(length, height, width);
        double middleSideBrick = medium(length,height, width);
        double biggerSideHole = Math.max(widthHole, heightHole);
        double smallerSideHole = Math.min(widthHole, heightHole);
        return biggerSideHole >= middleSideBrick && smallerSideHole >= smallerSideBrick;
    }

    private static double minimum(double length, double height, double width)
    {
        return Math.min(Math.min(length, height), width);
    }

    private static double maximum(double length, double height, double width)
    {
        return Math.max(Math.max(length, height), width);
    }

    private static double medium(double length, double height, double width)
    {
        return (length + height + width - minimum(length, height, width) - maximum(length, height, width));
    }

    private static double checkPositiveAndZero(double number)
    {
        if (number <= 0)
        {
            System.out.print("Error! Input positive non-zero number: ");
            Scanner num = new Scanner(System.in);
            return checkPositiveAndZero(num.nextDouble());
        }
        else return number;
    }
    private static void outputResult(double widthHole, double heightHole, double length, double height, double width)
    {
        if (checkBrickEntry(widthHole, heightHole, length, height, width))
        {
            System.out.println("This brick will go through the hole");
        }
        else {
            System.out.println("This brick will not go through the hole");
        }
    }
}
