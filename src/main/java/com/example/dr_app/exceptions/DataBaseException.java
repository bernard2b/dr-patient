package com.example.dr_app.exceptions;

import java.sql.SQLException;

public class DataBaseException extends SQLException {

    public DataBaseException(String message) {
        super(message);
    }
    public DataBaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
