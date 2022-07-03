package com.example.demo.response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/response")
public class ResponseController {
    private final ResponseService responseService;

    @Autowired
    public ResponseController(ResponseService responseService) {
        this.responseService = responseService;
    }

    @GetMapping
    public List<SimpleResponse> getResponses(){
        System.out.println(ResponsePull.Singleton().getResponseList());
        return ResponsePull.Singleton().getResponseList();
    }

    @PutMapping(path = "{command}")
    public boolean updateCommandStatus(@PathVariable("command") String command){
        return responseService.updateCommandStatusToLINKED(new SimpleResponse(command));
    }


}
