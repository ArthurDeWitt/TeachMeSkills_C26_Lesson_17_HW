package com.teachmeskills.lesson17.homework.hw0.runner;

import com.teachmeskills.lesson17.homework.hw0.custom_exceptions.EmptyInputException;
import com.teachmeskills.lesson17.homework.hw0.custom_exceptions.NumberTooLargeException;
import com.teachmeskills.lesson17.homework.hw0.func_interface.ReverseFactorialInterface;

import java.util.Scanner;

// Запуск логики
public class Operation {
    public static void main(String[] args) {
        Operation operation = new Operation();
        operation.OperationBasedOnInput();
    }

    // Ввод кода операции
    public void OperationBasedOnInput() {
        System.out.println("Enter 1 to reverse string or 2 to calculate the factorial: ");
        Scanner scanner = new Scanner(System.in);
        int code = scanner.nextInt();

        switch (code) {
            case 1:
                stringReverse();
                break;
            case 2:
                factorialCalculation();
                break;
            default:
                System.out.println("Wrong input.");
        }
    }

    // Метод реверса для строки (код 2)
    private void stringReverse() {
        System.out.println("Enter the string for reverse: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (input.isEmpty()) {
            // Если строка пуста, выводим ошибку и завершаем метод
            System.out.println("Error: An empty string was entered.");
            return;
        }

        // Создаем функциональный интерфейс для реверса строки
        ReverseFactorialInterface<String> reverseString = s -> new StringBuilder(s).reverse().toString();
        // Выполняем операцию реверса строки
        String result = processOperation(input, reverseString);

        // Результат реверса строки
        System.out.println("Result of string reversal: " + result);
    }

    // Метод вычисления факториала (код 1)
    private void factorialCalculation() {
        System.out.println("Enter a number to calculate the factorial:");
        Scanner scanner = new Scanner(System.in);

        try {
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                // Если строка пуста, выбрасываем исключение
                throw new EmptyInputException("Error: An empty string was entered.");
            }

            // Преобразуем строку в целочисленное значение
            int value = Integer.parseInt(input);

            if (value > Integer.MAX_VALUE) {
                // Если значение больше типа int, выбрасываем исключение
                throw new NumberTooLargeException("Error: The entered number is of type int.");
            }

            // Функциональный интерфейс для вычисления факториала
            ReverseFactorialInterface<Integer> factorial = n -> {
                int result = 1;
                for (int i = 1; i <= n; i++) {
                    result *= i;
                }
                return result;
            };

            // Выполняем операцию вычисления факториала
            int result = processOperation(value, factorial);

            // Выводим результат вычисления факториала
            System.out.println("Result of calculating a factorial: " + result);
        } catch (NumberFormatException e) {
            // Обрабатываем исключение если введено невалидное значение
            System.out.println("Error: Invalid value.");
        } catch (EmptyInputException e) {
            // Обрабатываем исключение если введена пустая строка
            System.out.println(e.getMessage());
        } catch (NumberTooLargeException e) {
            // Обрабатываем исключение, если введенное число больше типа int
            System.out.println(e.getMessage());
        }
    }

    // Обобщённый метод-процесс для работы с разными типами данных (числа и строки)
    private <T> T processOperation(T value, ReverseFactorialInterface<T> operation) {
        return operation.operations(value);
    }
}