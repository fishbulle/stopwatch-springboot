package com.example.tidtagarur;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class TimerService {

    private final TimerRepository timerRepository;

    public TimerEntity saveTime(TimerDTO timerDTO) {
        TimerEntity timerEntity = new TimerEntity(
                UUID.randomUUID()
        );
    }
}
