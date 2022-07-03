package com.example.demo.response;

import com.example.demo.SameCommand;

import javax.persistence.*;
import java.util.Objects;


public class SimpleResponse implements SameCommand {

    //private static Long id  = 0L;
    private String response;
    private int responseHash;

    public SimpleResponse() {
        //id++;
        response = "00000000000000000000";
        responseHash = SameCommand.getHashForCommand(response);
    }

    public SimpleResponse(String response) {
        this.response = response;
        responseHash = SameCommand.getHashForCommand(response);
    }

    //public Long getId() {
     //   return id;
    //}

    public String getResponse() {
        return response;
    }

    public int getResponseHash() {
        return responseHash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleResponse that = (SimpleResponse) o;
        return responseHash == that.responseHash && Objects.equals(response, that.response);
    }

    @Override
    public String toString() {
        return "SimpleResponse{" +
                "response='" + response + '\'' +
                ", responseHash=" + responseHash +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(response, responseHash);
    }
}
