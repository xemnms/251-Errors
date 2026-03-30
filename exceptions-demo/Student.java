import java.util.*;

public class Student {
    private String name;
    private int age;
    private String course;
    private List<Student> friends;


    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getFriends() {  
        return friends.toString();
    }

    public String hasIceBreaker() throws IceBreakerException {
        if (course == null || !course.equalsIgnoreCase("Ice Breaker")) {
            throw new IceBreakerException("Student is not enrolled in the Ice Breaker course.");
        }
        return "Student is enrolled in the Ice Breaker course.";
    }
} 