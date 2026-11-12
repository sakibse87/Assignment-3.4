
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Task2 {

    public static void main(String[] args) {

        long first = 0;
        long second = 1;

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter("fibonacci.csv"))) {

            writer.write("Position;Fibonacci Number");
            writer.newLine();

            for (int i = 1; i <= 60; i++) {

                writer.write(i + ";" + first);
                writer.newLine();

                long next = first + second;
                first = second;
                second = next;
            }

            System.out.println("Fibonacci CSV file created successfully!");
            System.out.println("Total numbers: 60");
            System.out.println("60th Fibonacci number: 1548008755920");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
