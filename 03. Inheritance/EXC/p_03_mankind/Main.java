package L03_InheritanceEXC.p_03_mankind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] stTokens = in.readLine().split(" ");
        String studentFirstName = stTokens[0];
        String studentLastName = stTokens[1];
        String studentFacultyNumber = stTokens[2];

        String[] workerTokens = in.readLine().split(" ");
        String workerFirstName = workerTokens[0];
        String workerLastName = workerTokens[1];
        double workerSalary = Double.parseDouble(workerTokens[2]);
        double workerWorkingHours = Double.parseDouble(workerTokens[3]);

        Student student = null;
        Worker worker = null;

        try {
            student = new Student(studentFirstName, studentLastName, studentFacultyNumber);
            worker = new Worker(workerFirstName, workerLastName, workerSalary, workerWorkingHours);

            System.out.println(student.toString());
            System.out.println(worker.toString());
        } catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }

    }
}
