package DesignPatterns.behavioral.command;

import java.util.LinkedList;
import java.util.Queue;

public class CommandInvoker {

    private Queue<ICommand> queue = new LinkedList<>();

    public void addCommand(ICommand command) {
        queue.add(command);
    }

    public void processCommands() {
        while (!queue.isEmpty()) {
            queue.poll().execute();
        }
    }
}

