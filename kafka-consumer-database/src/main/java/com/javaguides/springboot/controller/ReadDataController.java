package com.javaguides.springboot.controller;

import com.javaguides.springboot.repository.WikimediaDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/data")
public class ReadDataController {

    private final WikimediaDataRepository repository;

    @GetMapping
    public void printData() {
        repository.findAll(Pageable.ofSize(15))
                .forEach(data -> System.out.println(data.getWikiEventData()));
    }

}
