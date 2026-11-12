
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        // Create Student object
        Student student = new Student(101, "Sakib Seam", 24);

        // Create Course object
        Course course = new Course(
                "TX00EY21",
                "Object Oriented Programming",
                "Metropolia Teacher"
        );

        // Create Enrollment object
        Enrollment enrollment = new Enrollment(
                student,
                course,
                "12.11.2026"
        );

        // Serialize object to file
        try (ObjectOutputStream output =
                     new ObjectOutputStream(
                             new FileOutputStream("enrollments.ser"))) {

            output.writeObject(enrollment);

            System.out.println("Enrollment saved successfully!");

        } catch (IOException e) {
            System.out.println("Error saving enrollment: " + e.getMessage());
            return;
        }

        // Deserialize object from file
        try (ObjectInputStream input =
                     new ObjectInputStream(
                             new FileInputStream("enrollments.ser"))) {

            Enrollment savedEnrollment =
                    (Enrollment) input.readObject();

            // Print student information
            System.out.println("\nStudent Information:");
            System.out.println("ID: " +
                    savedEnrollment.getStudent().getId());
            System.out.println("Name: " +
                    savedEnrollment.getStudent().getName());
            System.out.println("Age: " +
                    savedEnrollment.getStudent().getAge());

            // Print course information
            System.out.println("\nCourse Information:");
            System.out.println("Course Code: " +
                    savedEnrollment.getCourse().getCourseCode());
            System.out.println("Course Name: " +
                    savedEnrollment.getCourse().getCourseName());
            System.out.println("Instructor: " +
                    savedEnrollment.getCourse().getInstructor());

            // Print enrollment date
            System.out.println("\nEnrollment Information:");
            System.out.println("Enrollment Date: " +
                    savedEnrollment.getEnrollmentDate());

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading enrollment: " + e.getMessage());
        }
    }
}
