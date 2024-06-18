package com.example;

import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome !");
        //int row, colum;
       // System.out.printf("Enter row number");
      //  row = scanner.nextInt();
       // System.out.printf("Enter colum number");
       // colum = scanner.nextInt();

        MineField mineField = new MineField(5,5);
        mineField.run();

        }

    }





