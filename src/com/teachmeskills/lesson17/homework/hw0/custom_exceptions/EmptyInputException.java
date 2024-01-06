package com.teachmeskills.lesson17.homework.hw0.custom_exceptions;

// Исключение если введённое число больше типа int
public class EmptyInputException extends Exception{
    public EmptyInputException(String message) {
        super(message);
    }
}
