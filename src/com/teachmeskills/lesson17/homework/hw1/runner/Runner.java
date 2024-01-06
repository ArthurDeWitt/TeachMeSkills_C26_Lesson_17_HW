package com.teachmeskills.lesson17.homework.hw1.runner;


import com.teachmeskills.lesson17.homework.hw0.custom_exceptions.EmptyInputException;
import com.teachmeskills.lesson17.homework.hw1.exceptions.InvalidDateFormatException;
import com.teachmeskills.lesson17.homework.hw1.func_interface1.DateProcessor;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the date in the format dd-MM-yyyy:");
        String inputDate = scanner.nextLine();

        try {
            LocalDate date = parseDate(inputDate);

            // Используем лямбда-выражение для функционального интерфейса DateProcessor
            DateProcessor dateProcessor = d -> d.getDayOfWeek();
            DayOfWeek dayOfWeek = dateProcessor.processDate(date);

            System.out.println("Day of the week for " + inputDate + " - " + dayOfWeek);
        } catch (InvalidDateFormatException | EmptyInputException e) {
            System.out.println(e.getMessage());
        }
    }

    private static LocalDate parseDate(String inputDate) throws InvalidDateFormatException, EmptyInputException {
        // Проверка на пустой ввод
        if (inputDate.isEmpty()) {
            throw new EmptyInputException("Error: Empty string entered.");
        }

        try {
            // Преобразуем введенную строку в объект LocalDate
            return LocalDate.parse(inputDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        } catch (DateTimeParseException e) {
            // В случае ошибки парсинга выбрасываем кастомное исключение
            throw new InvalidDateFormatException("Error: Invalid date format.", inputDate, 0);
        }
    }
}
