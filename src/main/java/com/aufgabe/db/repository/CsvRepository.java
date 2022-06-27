package com.aufgabe.db.repository;

import com.aufgabe.db.model.Office;
import com.opencsv.bean.CsvToBeanBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Repository
public class CsvRepository {
    final Logger logger = LoggerFactory.getLogger(CsvRepository.class);
    private final List<Office> offices;

    public CsvRepository(ResourceLoader resourceLoader, @Value("${input.filename}") String fileName) throws IOException {
        logger.debug("Filename {}", fileName);
        var resource = resourceLoader.getResource("classpath:" + fileName);
        offices = new CsvToBeanBuilder<Office>(new InputStreamReader(resource.getInputStream()))
                .withType(Office.class)
                .build()
                .parse();
    }

    public Office getByCode(String code) {
        if (code == null) {
            return null;
        }

        return offices.stream()
            .filter(office -> code.equals(office.getCode()))
            .findFirst()
            .orElse(null);
    }
}
