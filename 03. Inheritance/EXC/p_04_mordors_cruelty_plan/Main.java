package L03_InheritanceEXC.p_04_mordors_cruelty_plan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        List<String> tokens = Arrays.stream(in.readLine().split(" ")).map(String::toLowerCase).collect(Collectors.toList());
    }
}
