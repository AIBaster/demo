package com.example.demo.command;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CommandRepository extends JpaRepository<SimpleCommand,Long> {
    //querysssss.....
    @Query("SELECT s FROM SimpleCommand s WHERE s.commandHash = ?1")
    Optional<SimpleCommand> getSimpleCommandsByHashString(int hash);


}
