package com.mastercoding.lib;

import java.sql.SQLOutput;
import java.util.Scanner;

public class MyClass {

public void EX1(){
    Scanner sc  = new Scanner(System.in);
    System.out.println("input first int");
    int a = sc.nextInt();
    System.out.println("input second int");
    int b = sc.nextInt();
    System.out.println(a/b);
    System.out.println(a%b);
    System.out.println( Integer.toString(2,5));
}
public static void EX2(){
    Scanner sc = new Scanner(System.in);
    System.out.println("please enter radius");
    int r =  sc.nextInt();
    System.out.println("perimeter is: "+ Double.toString(Math.PI*2*r));
    System.out.println("area is : "+ Double.toString(Math.PI*Math.pow(r,2)));

}

public static void EX10(int[] arr){
    double size  =  arr.length;
    int sum =0;
    for (int i=0;i<size;i++){
        sum+=arr[i];
    }
    System.out.println("average is:" + sum / size);
}

    public static void main(String [] args){

    int[] arr = {1,-1,1,-1,1,-1};
    EX10(arr);


    }
}