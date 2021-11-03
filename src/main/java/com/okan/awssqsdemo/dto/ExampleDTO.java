package com.okan.awssqsdemo.dto;

import java.io.Serializable;
import java.util.StringJoiner;

public class ExampleDTO implements Serializable {
    private static final long serialVersionUID = 7038513768897729145L;

    private String message;

    public ExampleDTO() {
    }

    public ExampleDTO(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ExampleDTO.class.getSimpleName() + "[", "]")
                .add("message='" + message + "'")
                .toString();
    }
}
