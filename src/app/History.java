package app;

import java.util.LinkedList;
import java.util.List;

public class History {
    private final List<String> history = new LinkedList<>();
    private static final int HISTORY_LIMIT = 100;

    public void record(String entry) {
        if (history.size() >= HISTORY_LIMIT) history.remove(0);
        history.add(entry);
        System.out.println("_________________\nResult: " + entry + "\n_________________");
    }

    public void printHistory() {
        System.out.println("\n--- Operation History ---");
        if (history.isEmpty()) {
            System.out.println("History is empty.");
        } else {
            int i = 1;
            for (String entry : history) System.out.println(i++ + ". " + entry);
        }
    }

    public void clear() {
        history.clear();
        System.out.println("History cleared.");
    }
}