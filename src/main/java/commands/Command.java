package commands;

import java.util.List;

public interface Command {
    /**
     * Executing the current command
     *
     * @param args A list with the current parameters for the command
     */
    void execute(List<String> args);
}
