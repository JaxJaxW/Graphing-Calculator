package com.jaxton.graphing.objects;

import java.util.Scanner;

import static java.lang.Math.log10;
import static java.lang.Math.pow;

public class SciCalculator {
    private static Scanner scanner = new Scanner(System.in);
    private double sum = 0;
    private double answer = 0.0;
    private int counter = 0;
    private double operations[] = new double[7];

    public static void main(String[] args) {

        boolean programLoop = true;

        while (programLoop) {

            menu();
            boolean menuLoop = true;

            while (menuLoop) {
                int selection;
                String option;

                while (true) {
                    option = scanner.next();
                    try {
                        selection = Integer.parseInt(option);
                        break;
                    } catch (NumberFormatException nfe) {
                        nfe.printStackTrace();
                        System.out.println("Please choose a valid selection!\n");
                        System.out.print("Enter Menu Selection: ");
                    }
                }

                if (selection == 0) {
                    System.out.print("\nThanks for using this calculator. Goodbye!");
                    menuLoop = false;
                    programLoop = false;

                } else if (selection > 0 && selection < 7) {
                    enterOperands();
                    answer = operations[selection];
                    menu();

                } else if (selection == 7) {

                    if (counter > 0) {
                        double average = (sum / counter);
                        // fix this shit ... average = round(average * 100.0) / 100.0;
                        System.out.print("\nSum of calculations: " + sum + "\nNumber of calculations: " + counter + "\nAverage of calculations: " + average + "\n\n");
                        System.out.print("Enter Menu Selection: ");

                    } else if (counter == 0) {
                        System.out.println("Error: No calculations yet to average!\n");
                        System.out.print("Enter Menu Selection: ");
                    }

                } else {
                    System.out.println("Error: Invalid selection!\n");
                    System.out.print("Enter Menu Selection: ");
                }
            }
        }
    }

    private static void menu() {
        System.out.print("Calculator Menu\n" + "---------------\n" + "0. Exit Program\n" + "1. Addition\n" + "2. Subtraction\n" + "3. Multiplication\n" + "4. Division\n" + "5. Exponentiation\n" + "6. Logarithm\n" + "7. Display Average\n");
        System.out.print("\nEnter Menu Selection: ");
    }

    private void enterOperands() {
        String operand;
        double x = 0;
        double y = 0;

        //These two arrays are the differences between both of the loops that follow. Everything besides first, x and second, y are the same
        String arr[] = {"first", "second"};
        Double var[] = {x, y};

        for (int i = 0; i < 2; i++) {
            while (true) {
                System.out.print("Enter " + arr[i] + " operand: ");
                operand = scanner.next(); // retrieve value
                if (operand.equals("RESULT")) {
                    var[i] = answer; // If I want to use the previous result as my input
                    break;
                } else {
                    try {
                        var[i] = Double.parseDouble(operand); // Assumes that if it isn't RESULT, then I'll want to put in a number
                        break;
                    } catch (NumberFormatException nfe) { // necessary if I type anything else in besides RESULT and a double
                        System.out.print("Please enter a valid input!");
                    }
                }
            }
        }

        System.out.print("\n");
        operations[0] = 0;
        operations[1] = var[0] + var[1];
        operations[2] = var[0] - var[1];
        operations[3] = var[0] * var[1];
        operations[4] = var[0] / var[1];
        operations[5] = pow(var[0], var[1]);
        operations[6] = ((log10(var[1])) / (log10(var[0])));
    }

    private double[] getOperands(String string) {
        string = string.toLowerCase();
        double result;
        StringBuilder stringBuilder = new StringBuilder(string);
        boolean doubleResult = false;
        boolean negative = false;
        int resultCounter = 0;
        int[] operations;

        for (int i = 0; i < string.length(); i++) {
            char tempChar = string.charAt(i);
            if (tempChar == '-') {
                if (doubleResult) {

                }
                negative = true;

            }
            if (tempChar == '+') {

            }

            if (Character.isDigit(tempChar)) {
                if (doubleResult) {

                }
                if (negative) {
                    if (doubleResult)
                    stringBuilder.append("-");
                    negative = false;
                }
                doubleResult = true;
                stringBuilder.append(String.valueOf(tempChar));
            }
            if (tempChar == '.') {

                if(doubleResult)
                    stringBuilder.append(".");



            }
            if (Character.isSpaceChar(tempChar)) {
                if (doubleResult) {
                    result = Double.parseDouble(stringBuilder.toString());
                    resultCounter++;
                    doubleResult = false;
                }
            }
        }





    }
}