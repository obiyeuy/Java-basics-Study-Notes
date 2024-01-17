package com.yueyibo.self_study;

public class EightQueens {
    static int MAX=8;
    static  int Queen[] = new int[MAX];
    static  int count = 0;
    public static void main(String[] args){
        eightQueens(0);
        System.out.println("一共有"+count+"种排序");
    }

    public static void eightQueens(int row){
        if(row == MAX){
            printQueens();
            return;
        }
        for(int column = 0;column<MAX;++column){
            Queen[row] =column;
            if(isOK(row)){
                Queen[row]=column;
                eightQueens(row+1);
            }
        }
    }

    public static boolean isOK(int row){
        for(int i = 0;i<row;++i){
            if(Queen[row]==Queen[i] || row-i==Math.abs(Queen[row]-Queen[i])){
                return false;
            }
        }
        return true;
    }

    public static void printQueens(){
        count++;
        for(int i =0;i<MAX;++i){
            System.out.print(Queen[i]+" ");
        }
        System.out.println();
    }
}
