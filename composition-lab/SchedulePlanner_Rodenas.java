package ComponentClasses;

/*
 * Component class by Kyla Cassandra Rodenas
 * Represents a schedule with day, time, and subject
 * Demonstrates composition (HAS-A relationship), encapsulation, and validation
 */

public class SchedulePlanner_Rodenas {
//attributes (stores the schedule details)
private String day;
private String time;
private String subject;

//constructor (initializes the schedule object)
public SchedulePlanner_Rodenas(String day, String time, String subject) {
    this.day = day;
    setTime(time); // uses setter for validation
    this.subject = subject;
}

//getters (used to access the values)
public String getDay() {
    return day;
}

public String getTime() {
    return time;
}

public String getSubject() {
    return subject;
}

//setters (used to modify the values with validation)
public void setDay(String day) {
    this.day = day;
}

public void setTime(String time) {
//validation: time should not be empty
    if (time != null && !time.trim().isEmpty()) {
        this.time = time;
    } else {
        System.out.println("Invalid time. Default set to 00:00.");
        this.time = "00:00";
    }
}

public void setSubject(String subject) {
    this.subject = subject;
}

//methods (behavior of the object)
//displays the schedule information
public void displaySchedule() {
    System.out.println("Day: " + day);
    System.out.println("Time: " + time);
    System.out.println("Subject: " + subject);
}

//updates the subject with validation
public void updateSubject(String newSubject) {
    if (newSubject != null && !newSubject.trim().isEmpty()) {
        subject = newSubject;
        System.out.println("Subject updated successfully.");
    } else {
        System.out.println("Invalid subject input.");
        }
    }
}