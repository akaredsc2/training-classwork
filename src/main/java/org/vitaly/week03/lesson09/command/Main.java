package org.vitaly.week03.lesson09.command;

/**
 * Created by vitaly on 17.02.17.
 */

interface Command {
    void execute();
}

class Command1 implements Command {
    @Override
    public void execute() {
        System.out.println("command1");
    }
}

class Command2 implements Command {
    @Override
    public void execute() {
        System.out.println("command2");
    }
}

enum CommandEnum {
    ONE, TWO
}

class CommandFactory {
    private static CommandFactory instance = new CommandFactory();

    private Command command1 = new Command1();
    private Command command2 = new Command2();

    public static CommandFactory getInstance() {
        return instance;
    }

    public Command getCommand(CommandEnum commandEnum) {
        switch (commandEnum) {
            case ONE:
                return command1;
            case TWO:
                return command2;
            default:
                return null;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        CommandFactory factory = CommandFactory.getInstance();
        Command command = factory.getCommand(CommandEnum.ONE);
        command.execute();
    }
}
