package ru.vsu.cs.lazutkina;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        double length = readSideBrickAndHole("length", "brick");
        double height = readSideBrickAndHole("height", "brick");
        double width = readSideBrickAndHole("width", "brick");

        double widthHole = readSideBrickAndHole("width", "hole");
        double heightHole = readSideBrickAndHole("height", "hole");

        printResult(widthHole, heightHole, length, height, width);
    }

    private static double readSideBrickAndHole(String sizeName, String name)
    {
        Scanner scn = new Scanner(System.in);
        System.out.printf("Input the %s of the %s: ", sizeName, name);
        return checkPositiveAndZero(scn.nextDouble());
    }

    private static boolean checkBrickGoesThroughTheHole(double widthHole, double heightHole, double length, double height, double width)
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
    private static void printResult(double widthHole, double heightHole, double length, double height, double width)
    {
        if (checkBrickGoesThroughTheHole(widthHole, heightHole, length, height, width))
        {
           printString("will");
        }
        else {
            printString("will not");
        }
    }
    private static void printString (String name)
    {
        System.out.printf("This brick %s go through the hole", name);
    }
}
