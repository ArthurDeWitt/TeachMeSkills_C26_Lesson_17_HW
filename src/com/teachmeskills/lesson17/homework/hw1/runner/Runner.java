package com.teachmeskills.lesson17.homework.hw1.runner;

import com.teachmeskills.lesson17.homework.hw1.exceptions.EmptyInputException;
import com.teachmeskills.lesson17.homework.hw1.exceptions.InvalidDateFormatException;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        // Ввод даты от пользователя
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the date in dd-MM-yyyyy format:");
        String inputDate = scanner.nextLine();

        try {
            // Пытаемся преобразовать введенную строку в объект LocalDate
            LocalDate date = parseDate(inputDate);

            // Получение дня недели из объекта LocalDate
            DayOfWeek dayOfWeek = date.getDayOfWeek();

            // Вывод результата
            System.out.println("Day of the week for " + inputDate + " - " + dayOfWeek);
        } catch (InvalidDateFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    // Вспомогательная функция для парсинга строки с датой в объект LocalDate и обработки пустого ввода
    private static LocalDate parseDate(String inputDate) throws InvalidDateFormatException, EmptyInputException {
        // Проверка на пустой ввод
        if (inputDate.isEmpty()) {
            throw new EmptyInputException("Error: Empty input.", inputDate, 0);
        }

        try {
            // Преобразование введенной строки в объект LocalDate
            return LocalDate.parse(inputDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        } catch (DateTimeParseException e) {
            // В случае ошибки парсинга выбрасываем кастомное исключение
            throw new InvalidDateFormatException(inputDate, inputDate, 0);
        }
    }
}
