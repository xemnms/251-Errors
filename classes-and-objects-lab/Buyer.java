// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
public class Student {
   String name;
   int age;
   String course;
   static int totalStudents = 0;

   Student() {
      this.name = "Unknown";
      this.age = 0;
      this.course = "Undeclared";
      ++totalStudents;
   }

   Student(String var1, int var2, String var3) {
      this.name = var1;
      this.age = var2;
      this.course = var3;
      ++totalStudents;
   }

   Student(String var1, String var2) {
      this.name = var1;
      this.course = var2;
      this.age = 18;
      ++totalStudents;
   }

   void introduce() {
      System.out.println("Hi, I am " + this.name + ".");
      System.out.println("I am " + this.age + " years old.");
      System.out.println("My course is " + this.course + ".");
   }

   void updateCourse(String var1) {
      this.course = var1;
      System.out.println(this.name + " has updated their course to " + this.course + ".");
   }

   static void displayTotalStudents() {
      System.out.println("Total Students Created: " + totalStudents);
   }
}
