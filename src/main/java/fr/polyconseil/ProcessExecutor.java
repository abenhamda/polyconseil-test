package fr.polyconseil;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public final class ProcessExecutor {

    public static void execute(final List<Process> processList) {
        // Commencer par le cycle 0
        final AtomicInteger cycle = new AtomicInteger(0);
        while (hasProcessToExecute(processList)) {
            // Recuperer le process prioritaire pendant le cycle en cours
            final Optional<Process> priorityProcess = processList.stream()
                    .filter(p -> p.getStart() <= cycle.get())
                    .min((p1, p2) -> p2.getTime() - p1.getTime());

            // Executé le process prioritaire
            if (priorityProcess.isPresent()) {
                System.out.println(priorityProcess.get());
                priorityProcess.get().decrimentTime();
            }

            // Incrementer le cycle
            cycle.getAndIncrement();
        }
    }

    private static boolean hasProcessToExecute(final List<Process> processes) {
        final Optional<Process> first = processes.stream().filter(Process::isNotFinished).findFirst();
        return first.isPresent();

    }
}
