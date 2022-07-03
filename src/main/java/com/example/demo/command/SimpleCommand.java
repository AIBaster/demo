package com.example.demo.command;

import com.example.demo.SameCommand;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table
public class SimpleCommand  implements SameCommand {
    @Id
    @SequenceGenerator(name = "hex_command_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hex_command_id")
    private Long id;
    private String command;
    private int commandHash;
    private CommandStatus status;
    private LocalTime time;

    public SimpleCommand() {
        status = CommandStatus.NEW;
        time = LocalTime.now();
        command = "00000000000000000000";
        commandHash = SameCommand.getHashForCommand(command);

    }

    public SimpleCommand(String command) {
        this();
        this.command = command;
        commandHash = SameCommand.getHashForCommand(command);
    }

    public void setCommandHash(int hashString) {
        this.commandHash = hashString;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStatus(CommandStatus status) {
        if(this.status.getValue()>status.getValue())
            throw new IllegalArgumentException("Illegal status value. ");
        this.status = status;
    }

    public CommandStatus getStatus() {
        return status;
    }

    public Long getId() {
        return id;
    }

    public String getCommand() {
        return command;
    }

    public int getCommandHash() {
        return commandHash;
    }

    public LocalTime getTime() {
        return time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleCommand that = (SimpleCommand) o;
        return commandHash == that.commandHash && Objects.equals(id, that.id) && Objects.equals(command, that.command) && status == that.status && Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, command, commandHash, status, time);
    }

    @Override
    public String toString() {
        return "SimpleCommand{" +
                "id=" + id +
                ", command='" + command + '\'' +
                ", hashString=" + commandHash +
                ", status=" + status +
                ", time=" + time +
                '}';
    }

}
