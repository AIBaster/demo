package com.example.demo.response;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


@EnableAsync
public class ResponsePull {
    private static ResponsePull responsePull = null;

    LinkedList<SimpleResponse> responseList;

    private ResponsePull(){
        responseList = new LinkedList<>();
    }

    public static ResponsePull Singleton(){
        if(responsePull==null){
            responsePull = new ResponsePull();
        }
        return responsePull;
    }

    public List getResponseList(){
        return List.copyOf(responseList);
    }

    public void addResponse(SimpleResponse response){
        //check response hash in db. If yes, change command status to linked
        responseList.add(response);
    }
}
