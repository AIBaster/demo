package com.example.demo.response;

import com.example.demo.command.CommandStatus;
import com.example.demo.command.SimpleCommand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ResponseRepository extends JpaRepository<SimpleCommand,Long> {
    @Modifying
    @Query("UPDATE SimpleCommand SET status = ?2 WHERE commandHash = ?1")
    void updateCommandStatusByHash(int hash, CommandStatus linked);


}
