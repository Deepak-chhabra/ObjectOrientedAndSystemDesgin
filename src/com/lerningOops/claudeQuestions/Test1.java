package com.lerningOops.claudeQuestions;

/*
*  Create a Simple Class
*  Create a Student class with attributes: name, age, and rollNumber.
*  Include a constructor and a method to display student details.
 */

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Student {
    private String name;
    private int age;
    final private String rollNumber;


    Student(String name, int age, String rollNumber) {

        // validation ::
        validateName(name);
        validateAge(age);
        validateRollNumber(rollNumber);

        this.name = name.trim();
        this.age = age;
        this.rollNumber = rollNumber;
    }

    // ====================GETTERS AND SETTERS=========================

    public void setName(String name) {
        validateName(name);
        this.name = name.trim();
    }

    public void setAge(int age) {
        validateAge(age);
        this.age = age;
    }




    // ========== Validation code ========================================
    private static void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name can not be empty");
        }
    }

    private static void validateAge(int age) {
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Age should be between 0 and 120 ");
        }
    }

    private static void validateRollNumber(String rollNumber) {
        if (rollNumber == null || !(rollNumber.matches("\\d{7,10}"))) {
            throw new IllegalArgumentException("roll Number should be in right format");
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public boolean equals(Object student){
        if(student == this ) return true  ;
        if(!(student instanceof Student)) return false ;

        Student st = (Student) student ;
        return this.rollNumber.equals(st.rollNumber);
    }

    public int hashCode(){
        return Objects.hashCode(rollNumber);
    }

    public String toString(){
        return String.format("Name: %s\n" +
                             "Roll Number: %s\n" +
                             "Age: %d\n", name , rollNumber, age);
    }
}
public class Test1{
    public static void main(String[] args) {
        Student st = new Student("winkle", 78, "96453258");
        System.out.println(st);
        Set<Student> students = new HashSet<>();
        students.add(new Student("Deepak", 21, "7895655"));
        students.add(new Student("Deepak", 21, "7895655"));
        System.out.println(students.size());
    }
}