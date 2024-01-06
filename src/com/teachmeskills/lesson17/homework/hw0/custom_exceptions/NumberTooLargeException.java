package com.teachmeskills.lesson17.homework.hw0.custom_exceptions;

// Исключение если введена пустая строка
public class NumberTooLargeException extends Exception{
    public NumberTooLargeException (String message){
        super(message);
    }
}
