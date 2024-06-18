package com.example;

import java.util.Random;
import java.util.Scanner;


public class MineField {
    int rowNumber,colNumber;
    int[][] map;
    int[][] board;
    boolean game = true;
    Random random = new Random();
    Scanner sc = new Scanner(System.in);
    int size;


    public MineField(int rowNumber, int colNumber) {
        this.rowNumber = rowNumber;
        this.colNumber = colNumber;
        this.map = new int[rowNumber][colNumber];
        this.board = new int[rowNumber][colNumber];
        this.size=rowNumber*colNumber;

    }
    public void run(){
        int success=0;
        int row,col;
        prepareGame();
        // print(map);
          System.out.println("Game Start");
        while(game==true){
            print(board);
            System.out.printf("");
            System.out.printf("Enter row number");
            row = sc.nextInt();
            System.out.printf("Enter colum number");
            col = sc.nextInt();
            if(map[row][col]!=-1){
                checkMine(row,col);
                success++;
                if(success== (size-(size/4))){
                    System.out.printf("YOU WIN");
                    print(map);
                }
            }
            else {
                game=false;
                System.out.printf("Game Over");
                print(map);
            }

        }
    }
    public void checkMine(int r,int c){
        if(map[r][c]==0){
            if((c<colNumber-1)&&(map[r][c+1]==-1)){
                board[r][c]++;
            }
            if ((r<rowNumber-3)&&(map[r+1][c]==-1)){
                board[r][c]++;
            }
            if ((r>0)&&(map[r][c-1]==-1)){
                board[r][c]++;
            }
            if((c>0)&&(map[r][c-1]==-1)){
                board[r][c]++;
            }
            if(board[r][c]==0){
                board[r][c]=-2;
            }

       }

    }

    public void prepareGame() {
        int randRow, randColum;
        int count = 0;
        while (count != (size / 4)) {
            randRow = random.nextInt(rowNumber);
            randColum = random.nextInt(colNumber);
            if(map[randRow][randColum] != -1){
                map[randRow][randColum] = 1;
                count++;
            }
        }
    }
    public void print(int[][]arr){
    for(int i=0;i< arr.length;i++){
    for(int j=0;j< arr[0].length;j++)
    {
        if(arr[i][j]>=0)
        {
            System.out.print(" ");
        }
        System.out.print(arr[i][j]+" ");
    }
        System.out.println("");
}
    }



}