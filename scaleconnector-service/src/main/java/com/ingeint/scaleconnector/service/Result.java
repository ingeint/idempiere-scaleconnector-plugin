package com.ingeint.scaleconnector.service;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data
@AllArgsConstructor
public class Result {
    private String raw;
    private String value;
    private String stability;

    public double toDouble(){
        return Double.parseDouble(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return value.equals(result.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
