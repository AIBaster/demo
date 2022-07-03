package com.example.demo.command;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandService {

    private final CommandRepository commandRepository;

    public CommandService(CommandRepository commandRepository) {
        this.commandRepository = commandRepository;
    }

    public List<SimpleCommand> getAllCommandFromDB() {
        return commandRepository.findAll();
    }

    public boolean addNewCommandToDB(String str) {
        var command = new SimpleCommand(str);
        System.out.println("SERVICE: \n" + command);
        var res =
                commandRepository.getSimpleCommandsByHashString(
                command.getCommandHash());
        if(res.isEmpty()) {
            commandRepository.save(command);
            return true;
        }
        System.out.println("This command is already added. Command: "+ res.get());
        return false;
    }

    public boolean deleteCommandFromDB(int hash) {
        var res = commandRepository.getSimpleCommandsByHashString(hash);
        if (res.isEmpty()) {
            System.out.println("Unknown command hash: " + hash);
            return false;
        }
        commandRepository.delete(res.get());
        return true;
    }
}
