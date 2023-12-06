package com.mercadolibre.people_list_group_6.exceptions;

import lombok.Data;

@Data
public class ErrorClassDoc {
    private String message;
    private String error;
    private String status;
    private String path;

    public ErrorClassDoc(String message, String error, String status, String path) {
        this.message = message;
        this.error = error;
        this.status = status;
        this.path = path;
    }

    public ErrorClassDoc() {
    }
}
