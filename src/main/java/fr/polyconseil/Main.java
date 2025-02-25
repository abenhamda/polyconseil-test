package fr.polyconseil;

import java.util.Arrays;
import java.util.List;

public class Main {

    void main() {
        final List<Process> processes = Arrays.asList(
                new Process("1", 0, 5),
                new Process("2", 0, 7),
                new Process("3", 4, 6),
                new Process("4", 0, 1),
                new Process("5", 3, 2)
        );
        ProcessExecutor.execute(processes);
    }
}
