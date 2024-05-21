package commanders;

import commands.Command;

import java.util.HashMap;
import java.util.Map;

public class CommandMap {
    private final Map<String, Command> commandMap = new HashMap<>();

    public final void addToMap(String name, Command command) {
        commandMap.put(name, command);
    }

    public final Command getCommand(String name) {
        return commandMap.get(name);
    }
}
