public class Galindon_Student {

    // Private attributes
    private String name;
    private int studentId;
    private int age;
    private double gwa;
    private String program;

    // Static attribute
    private static int totalStudents = 0;

    // Constructor (default)
    public Galindon_Student() {
        this.name = "Unknown";
        this.studentId = "00000000000";
        this.age = 18;
        this.gwa = 0.0;
        this.program = "Undeclared";
        totalStudents++;
    }

    // Constructor (parameterized)
    public Galindon_Student(String name, int studentId, int age, double gwa, String program) {
        setName(name);
        setStudentId(studentId);
        setAge(age);
        setGwa(gwa);
        setProgram(program);
        totalStudents++;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getAge() {
        return age;
    }

    public double getGwa() {
        return gpa;
    }

    public String getProgram() {
        return program;
    }

    public static int getTotalStudents() {
        return totalStudents;
    }

    // Setters with validation

    // Validation 1: Name cannot be empty
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Invalid name.");
        }
    }

    // Validation 2: Student ID must be exactly 11 digits
    public void setStudentId(int studentId) {
        if (studentId != null && studentId.matches("\\d{11}")) {
            this.studentId = studentId;
        } else {
            System.out.println("Student ID must be exactly 11 digits.");
        }
    }

    // Validation 3: Age must be between 18 and 120
    public void setAge(int age) {
        if (age >= 18 && age <= 120) {
            this.age = age;
        } else {
            System.out.println("Invalid age.");
        }
    }

    // Validation 4: GWA must be between 0.0 and 4.0
    public void setGwa(double gwa) {
        if (gwa >= 0.0 && gwa <= 4.0) {
            this.gwa = gwa;
        } else {
            System.out.println("GWA must be between 0.0 and 4.0");
        }
    }

    public void setProgram(String course) {
        if (program != null && !program.trim().isEmpty()) {
            this.program = program;
        }
    }

    // Behavior 1: Improve GWA
    public void improveGwa(double points) {
        if (points > 0) {
            gpa += points;

            // Object invariant: GWA cannot exceed 4.0
            if (gpa > 4.0) {
                gpa = 4.0;
            }
        }
    }

    // Behavior 2: Display student information
    public void displayStudentInfo() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Program: " + program);
        System.out.println("GWA: " + gwa);
    }
}
