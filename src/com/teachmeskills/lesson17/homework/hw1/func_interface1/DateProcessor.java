package com.teachmeskills.lesson17.homework.hw1.func_interface1;

import java.time.DayOfWeek;
import java.time.LocalDate;

@FunctionalInterface
public interface DateProcessor {
    DayOfWeek processDate(LocalDate date);
}
