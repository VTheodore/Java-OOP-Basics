package L03_InheritanceEXC.p_01_person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String name = in.readLine();
        int age = Integer.valueOf(in.readLine());

        try {
            Child child = new Child(name, age);
            System.out.println(child.toString());

            String personClassName = Person.class.getSimpleName();
            String childClassName = Child.class.getSimpleName();
        }catch (IllegalArgumentException error){
            System.out.println(error.getMessage());
        }
    }
}
