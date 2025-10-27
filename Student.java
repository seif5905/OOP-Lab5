// Student.java
import java.io.Serializable;

public class Student implements Serializable {
    private int studentId;
    private String fullName;
    private int age;
    private String gender;
    private String department;
    private double gpa;
    
    // Constructor
    public Student(int studentId, String fullName, int age, String gender, String department, double gpa) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.gpa = gpa;
    }
    
    // Getters and Setters
    public int getStudentId() {
        return studentId;
    }
    
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    
    public String getFullName() {
        return fullName;
    }
    
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public String getGender() {
        return gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }
    
    public double getGpa() {
        return gpa;
    }
    
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    
    @Override
    public String toString() {
        return "Student ID: " + studentId + ", Name: " + fullName + ", Age: " + age + ", Gender: " + gender + ", Department: " + department + ", GPA: " + gpa;
    }
}
