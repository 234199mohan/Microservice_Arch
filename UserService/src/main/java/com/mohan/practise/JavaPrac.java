package com.mohan.practise;


interface  I1{
   default void run(){
       System.out.println("run method of I1");
   }
}


interface  I2{
    default void run(){
        System.out.println("run method of I2");
    }
}
public  class JavaPrac implements I1,I2{

    @Override
    public void run() {
        I2.super.run();
    }

    public static void main(String[] args) {
         JavaPrac java = new JavaPrac();
         java.run();
    }
}
