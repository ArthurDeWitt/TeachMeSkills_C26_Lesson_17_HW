package com.teachmeskills.lesson17.homework.hw1.exceptions;

class invalidDateFormatException extends Exception {
    public invalidDateFormatException(String message, String input, int errorIndex) {
        super(message + " Entered string: '" + input + "'. Error index: " + errorIndex);
    }
}
