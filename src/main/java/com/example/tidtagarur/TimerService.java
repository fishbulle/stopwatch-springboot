package com.example.tidtagarur;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class TimerService {

    private final TimerRepository timerRepository;

    public void saveTime(TimerDTO timerDTO) {
        TimerEntity timerEntity = new TimerEntity();
        timerEntity.setTime(timerDTO.time());
        timerRepository.save(timerEntity);
    }
}
