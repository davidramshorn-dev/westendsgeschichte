package com.example.westendsgeschichte.repository;

import com.example.westendsgeschichte.model.TestEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestEntryRepository extends JpaRepository<TestEntry, String> {
}

