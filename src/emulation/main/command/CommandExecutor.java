package emulation.main.command;

import emulation.main.Operation;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CommandExecutor {
    private static final Map<Operation, Command> allCommandsMap = new HashMap<>();

    static {
        allCommandsMap.put(Operation.ADD, new AddCommand());
        allCommandsMap.put(Operation.CHANGE, new ChangeCommand());
        allCommandsMap.put(Operation.DELETE, new DeleteCommand());
        allCommandsMap.put(Operation.FIND, new FindCommand());
        allCommandsMap.put(Operation.PRINT, new PrintCommand());
        allCommandsMap.put(Operation.EXIT, new ExitCommand());
    }

    private CommandExecutor() {}

    public static void execute(Operation operation) throws IOException {
        allCommandsMap.get(operation).execute();
    }
}
