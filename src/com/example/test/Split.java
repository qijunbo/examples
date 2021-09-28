package com.example.test;

import java.util.*;

/**
 * 描述
•连续输入字符串，请按长度为8拆分每个输入字符串并进行输出；
•长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。

输入描述：
连续输入字符串(输入多次,每个字符串长度小于等于100)

输出描述：
依次输出所有分割后的长度为8的新字符串

示例1
输入：
abc
123456789
复制
输出：
abc00000
12345678
90000000
 * @author qijunbo
 *
 */

public class Split {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
		   String str = sc.nextLine();
           if(str.length() <= 8 ){
               System.out.print(str);
               print0(8 - str.length());
               System.out.println();
           }else{
               
               char[] arr = str.toCharArray();
               for(int i =0; i< str.length(); i++){
                   System.out.print(arr[i]);
                   if(i%8 == 7){
                       System.out.println();
                   }
               }
               int zero = str.length() % 8;
               if( zero > 0 ){
                   print0( 8 - zero);
                   System.out.println(); 
               }
 
           } 
           
           
		}
		 
	}
 
    public static void print0(int c){
        for (int i=0; i< c; i++){
            System.out.print("0");
        }
    }
}