package com.example.cadencesandbox.controller;

import com.example.cadencesandbox.cadence.InsuranceWorker;
import org.apache.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CadenceController {

    private final InsuranceWorker worker;

    public CadenceController(InsuranceWorker worker) {
        this.worker = worker;
    }

    @GetMapping("/get-insurance")
    public int getInsurance(){
        worker.work();
        return HttpStatus.SC_OK;
    }
}
