package com.example.tidtagarur;

import java.time.LocalDate;

public record StopwatchDTO(Integer id,
                           double time,
                           LocalDate date) {}