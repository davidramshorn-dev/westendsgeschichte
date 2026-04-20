package com.example.westendsgeschichte.controller;

import com.example.westendsgeschichte.model.TestEntry;
import com.example.westendsgeschichte.service.TestEntryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/test")
public class TestEntryController {

    private final TestEntryService service;

    public TestEntryController(TestEntryService service) {
        this.service = service;
    }

    @PostMapping
    public TestEntry create(@RequestBody TestEntry entry) {
        return service.save(entry);
    }

    @GetMapping
    public List<TestEntry> getAll() {
        return service.getAll();
    }
}

