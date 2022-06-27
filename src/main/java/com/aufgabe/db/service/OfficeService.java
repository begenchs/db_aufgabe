package com.aufgabe.db.service;

import com.aufgabe.db.model.Office;
import com.aufgabe.db.repository.CsvRepository;
import org.springframework.stereotype.Service;

@Service
public class OfficeService {
    private final CsvRepository csvRepository;

    // Dependency injection
    public OfficeService(CsvRepository repository) {
        this.csvRepository = repository;
    }

    public Office getByCode(String code) {
        if (code == null) {
            return null;
        }

        return csvRepository.getByCode(code);
    }
}
