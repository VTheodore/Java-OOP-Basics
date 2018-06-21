package L01_DefiningClassesEXC.p_04_company_roster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = in.readLine().split("\\s+");

            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];

            Employee employee = null;
            switch (tokens.length) {
                case 4:
                    employee = new Employee(name, salary, position, department);
                    break;
                case 5:
                    if (tokens[4].matches("\\d+")) {
                        employee = new Employee(name, salary, position, department, Integer.parseInt(tokens[4]));
                    } else {
                        employee = new Employee(name, salary, position, department, tokens[4]);
                    }
                    break;
                case 6:
                    String email = tokens[4];
                    int age = Integer.parseInt(tokens[5]);
                    employee = new Employee(name, salary, position, department, email, age);
                    break;
            }

            employees.add(employee);
        }

        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .entrySet()
                .stream()
                .sorted((d1, d2) ->
                    Double.compare(
                            d2.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble(),
                            d1.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble())
                ).limit(1)
                .forEach(d -> {
                    System.out.printf("Highest Average Salary: %s%n", d.getKey());

                    d.getValue().stream()
                            .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                            .forEach(System.out::println);
                });
    }
}
