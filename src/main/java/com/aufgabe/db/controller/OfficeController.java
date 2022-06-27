package com.aufgabe.db.controller;

import com.aufgabe.db.model.Office;
import com.aufgabe.db.service.OfficeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OfficeController {
    private final OfficeService officeService;

    // Dependency injection
    public OfficeController(OfficeService service) {
        this.officeService = service;
    }

    @GetMapping("/office/{code}")
    public ResponseEntity<Office> getOffice(@PathVariable("code") String code) {
        var office = officeService.getByCode(code);
        if (office == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(office, HttpStatus.OK);
    }
}
