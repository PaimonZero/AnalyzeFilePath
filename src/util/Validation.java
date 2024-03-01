package util;

import java.util.Scanner;

public class Validation {

    public static int getInt(String msg, int min, int max) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine().trim();
            try {
                int n = Integer.parseInt(s);
                // if n not in range min max, re-input n
                if (n < min || n > max) {
                    System.err.println("n must be in range " + min + " -> " + max);
                    continue;
                }
                return n;
            } catch (NumberFormatException e) {
                System.err.println("Must be a number! Enter again please.");
            }
        }
    }
    
    public static double getDouble(String inputMsg) {
        Scanner sc = new Scanner(System.in);
        double result;
        
        do{
            try {
                System.out.print(inputMsg);
                result = Double.parseDouble(sc.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Pls enter integer number!! Try again!");
            }
        } while (true);
    }
    
    
    public static String getString(String inputMsg) {
        Scanner sc = new Scanner(System.in);
        String result;
        do{
            try {
                System.out.print(inputMsg);
                result = sc.nextLine().trim();
                if(result.isEmpty() == true) {
                    System.out.println(">>You input nothing?");
                } else { return result; }
            } catch (Exception e) {
                System.err.println("Pls enter again!");
            }
        } while (true);
    }
    
    public static String getString(String msg, String pattern) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine().trim();
            // if user input character without pattern then Re-input
            if (!s.matches(pattern)) {
                System.err.println("Invalid input! Please between 1(code) 0(remain) to 50 characters( letters, numbers, and/or spaces)");
                continue;
            }
            return s;
        }
    }
    
    public static boolean checkInputYN(String inputMsg) {
        while (true) {
            try {
                String result = getString(inputMsg);
                if (result.equalsIgnoreCase("Y")) {
                    return true;
                } else if (result.equalsIgnoreCase("N")) {
                    return false;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Please input y/Y or n/N.");
            }
        }
    }
    
    public static String getYN(String msg){
        Scanner sc = new Scanner(System.in);
        while (true) {            
            System.out.print(msg);
            String s=sc.nextLine();
            // return y or n ( yes or no )
            if(s.equalsIgnoreCase("Y")||s.equalsIgnoreCase("N")){
                return s;
            }
            else{
                System.err.println("Input Y or N please!");
            }
        }
    }
}
