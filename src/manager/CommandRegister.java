package manager;

import command.*;
import common.Command;
import common.ScriptCommand;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CommandRegister {
    public static final Map<String, Command> COMMANDS = new HashMap<>(15);
    public static final Map<String, ScriptCommand> ScriptCOMMANDS = new HashMap<>(15);
    public static void registerCommands() {
        Arrays.asList(
                new UpdateByIdCommand(),
                new AddCommand(),
                new AddIfMaxCommand(),
                new ClearCommand(),
                new RemoveByIdCommand(),
                new ExecuteScriptCommand(),
                new ExitCommand(),
                new FilterByFullNameCommand(),
                new FilterByAnnualTurnoverCommand(),
                new HelpCommand(),
//                new HistoryCommand(),
                new InfoCommand(),
                new RemoveLowerCommand(),
                new ShowCommand()
        ).forEach(command -> COMMANDS.put(command.getName(), command));
    }
    public static Map<String, Command> getCommands() {
        registerCommands();
        return COMMANDS;
    }

//    public static void registerStripCommands() {
//        Arrays.asList(
//                new AddIfMaxScriptCommand(),
//                new AddScriptCommand(),
//                new RemoveLowerScriptCommand(),
//                new UpdateByIdScriptCommand()
//        ).forEach(scriptCommand -> ScriptCOMMANDS.put(scriptCommand.getName(), scriptCommand));
//    }

//    public static Map<String, ScriptCommand> getScriptCOMMANDS() {
//        registerStripCommands();
//        return ScriptCOMMANDS;
//    }
}