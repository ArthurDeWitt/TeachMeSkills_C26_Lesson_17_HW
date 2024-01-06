package com.teachmeskills.lesson17.homework.hw1.exceptions;

import java.time.format.DateTimeParseException;

public class EmptyInputException extends DateTimeParseException {

    public EmptyInputException(String message, CharSequence parsedData, int errorIndex) {
        super(message, parsedData, errorIndex);
    }
}
