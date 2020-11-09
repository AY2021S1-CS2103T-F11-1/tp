package seedu.address.ui;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CommandHistory {

    private static CommandHistory commandHistory = null;

    private final List<String> history;
    private int pointer;

    /**
     * Private constructor, only to be called by `getInstance`
     */
    private CommandHistory() {
        history = new ArrayList<>();

        // Initial value doesn't matter, pointer is reset when a new command is pushed
        pointer = -1;
    }

    /**
     * Method to get the CommandHistory singleton.
     *
     * @return CommandHistory singleton
     */
    public static CommandHistory getInstance() {
        if (commandHistory == null) {
            commandHistory = new CommandHistory();
        }
        return commandHistory;
    }

    /**
     * Adds a user-typed command to the command history.
     *
     * No validation will be performed on the command, as we also want to save
     * commands with mistakes in the syntax.
     *
     * @param command command to be added to the history
     */
    public void push(String command) {
        requireNonNull(command);
        history.add(command);

        // Resets the pointer to point at the last command
        pointer = history.size() - 1;
    }

    /**
     * Fetches the previous command from the command history.
     *
     * Will restart from the most recent command, if the pointer has
     * gone beyond the earliest-entered command.
     *
     * @return previous command wrapped in a {@link Optional}
     */
    public Optional<String> fetchPrevious() {
        if (history.isEmpty()) {
            return Optional.empty();
        }
        Optional<String> lastCommand = Optional.of(history.get(pointer));
        pointer = (pointer - 1) % history.size();
        return lastCommand;
    }

    /**
     * Fetches the next command from the command history.
     *
     * Will restart from the earliest-entered command, if the pointer has
     * gone beyond the most recent command.
     *
     * @return next command wrapped in a {@link Optional}
     */
    public Optional<String> fetchNext() {
        if (history.isEmpty()) {
            return Optional.empty();
        }
        Optional<String> nextCommand = Optional.of(history.get(pointer));
        pointer = (pointer + 1) % history.size();
        return nextCommand;
    }
}
