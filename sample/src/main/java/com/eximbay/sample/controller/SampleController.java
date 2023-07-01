package com.eximbay.sample.controller;

import com.eximbay.sample.service.SampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/eximbay")
public class SampleController {

    private final SampleService sampleService;

    @GetMapping("/ready")
    public void ready() {
        sampleService.ready();
    }

    @GetMapping("/cancel")
    public void cancel() {
        sampleService.cancel();
    }

    @GetMapping("/verify")
    public void verify() {
        sampleService.verify();
    }
}
