package com.example.demo.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/command")
public class CommandController {

    private final CommandService commandService;

    @Autowired
    public CommandController(CommandService commandService) {
        this.commandService = commandService;
    }

    //Show All Commands
    @GetMapping
    public List<SimpleCommand> getAllCommands(){
        return commandService.getAllCommandFromDB();
    }

    //Add new Command to db
    @PostMapping(path = "{command}")
    public boolean registerNewCommand(@PathVariable("command") String command){
        if(command.length()!=20){
            throw new IllegalArgumentException("Bad command size. Command: " + command);
        }
        System.out.println(command);
        return commandService.addNewCommandToDB(command);
    }

    //remove command from db
    @DeleteMapping(path = "{hashString}")
    public boolean removeCommand(@PathVariable("{hashString}") int hash){
        return commandService.deleteCommandFromDB(hash);
    }




}
