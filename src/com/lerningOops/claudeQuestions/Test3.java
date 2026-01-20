package com.lerningOops.claudeQuestions;

/*
 * 3. Constructor Overloading
      Create a Rectangle class with multiple constructors:
      Default constructor (sets length and width to 1)
      Parameterized constructor (accepts length and width)
      Method to calculate area
 */

import java.util.Objects;

class Rectangle{
     final private  int length   ;
     final private int width  ;

     Rectangle(){
         this(1,1);
     }

     Rectangle(int length , int width){
         validateLength(length);
         validateWidth(width);
         this.length = length ;
         this.width = width ;
     }

     // =================GETTERS===================


    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int calcArea(){
         return length*width;
     }

     // Validation of the dimensions of the Rectangle class
     private static void  validateLength(int length ){
         if(length <= 0){
             throw new IllegalArgumentException("Length must be positive.");
         }
     }

     private static void validateWidth(int width){
         if(width <= 0 ) {
             throw new IllegalArgumentException("Width must be positive.");
         }
     }

     public boolean equals(Object o){
             if(this == o ) return true ;

             if(!(o instanceof Rectangle)) return false ;

             Rectangle rec = (Rectangle) o;
             return (this.length == rec.length) && (this.width == rec.width ) ;
     }


     public int hashCode(){
         return Objects.hash(length, width );
     }


     public String toString(){
         return String.format("Length : %d\n" +
                              "Width : %d\n"+
                               "Area : %d\n", length,width, calcArea() );
     }
}
public class Test3 {

    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle(78,89);
        System.out.println(rectangle1);
    }
}
