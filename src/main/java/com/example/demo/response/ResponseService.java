package com.example.demo.response;

import com.example.demo.command.CommandStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ResponseService {
    private final ResponseRepository responseRepository;

    public ResponseService(ResponseRepository responseRepository) {
        this.responseRepository = responseRepository;
    }

    @Transactional
    public boolean updateCommandStatusToLINKED(SimpleResponse response) {
        System.out.println(response);

        responseRepository.updateCommandStatusByHash(response.getResponseHash(), CommandStatus.LINKED);
        ResponsePull.Singleton().addResponse(response);
        return true;
    }
}
