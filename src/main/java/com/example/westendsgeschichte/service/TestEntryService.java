package com.example.westendsgeschichte.service;

import com.example.westendsgeschichte.model.TestEntry;
import com.example.westendsgeschichte.repository.TestEntryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestEntryService {

    private final TestEntryRepository repo;

    public TestEntryService(TestEntryRepository repo) {
        this.repo = repo;
    }

    public TestEntry save(TestEntry entry) {
        return repo.save(entry);
    }

    public List<TestEntry> getAll() {
        return repo.findAll();
    }
}

