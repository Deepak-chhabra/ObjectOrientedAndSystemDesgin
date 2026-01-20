package BasicOopsClaude;

/*
*  Create a Simple Class
*  Create a Student class with attributes: name, age, and rollNumber.
*  Include a constructor and a method to display student details.
 */

class Student{
    private String name ;
    private int age ;
    private String rollNumber ;

    /*
     Default constructor
     */
    Student(){
        this("unkown" , 23 , "8621110");
    }

    /* Parameterized constructor
       Constructor chaining
     */

    Student(String name , int age , String rollNumber){
        this.name = name ;
        this.age = age ;
        this.rollNumber = rollNumber ;
    }

    // ======GETTERS AND SETTERS

    public void setName(String name ){
        this.name = name ;
    }
    public void setAge(int age ){
        this.age = age ;
    }
    public void setRollNumber(String rollNumber){
        this.rollNumber = rollNumber;
    }

    public String getName(){
        return name ;
    }
    public int getAge(){
        return age ;
    }
    public String getRollNumber(){
        return rollNumber;
    }

    // printing all details by overriding the toStirng method

    public String toString(){
        return String.format("Name: %s\nAge: %d\nRoll Number: %s\n", name , age , rollNumber);
    }

}
public class Test1 {

    public static void main(String[] args) {
        Student st = new Student("Deepak", 23 , "2021218207");
        System.out.println(st);
    }

}
