package com.teachmeskills.lesson17.homework.hw1.exceptions;

import java.time.format.DateTimeParseException;

public class InvalidDateFormatException extends DateTimeParseException {
    public InvalidDateFormatException(String input, CharSequence parsedData, int errorIndex) {
        super("Invalid date format: " + input, parsedData, errorIndex);
    }
}
