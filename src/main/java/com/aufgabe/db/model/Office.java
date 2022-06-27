package com.aufgabe.db.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.opencsv.bean.CsvBindByPosition;

public class Office {
    @CsvBindByPosition(position = 0)
    @JsonProperty("code")
    private String code;
    @CsvBindByPosition(position = 1)
    @JsonProperty("name")
    private String name;
    @CsvBindByPosition(position = 2)
    @JsonProperty("short_name")
    private String shortName;
    @CsvBindByPosition(position = 3)
    @JsonProperty("type")
    private String type;

    public String getCode() {
        return code;
    }
}
