package com.example.tidtagarur;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StopwatchService {

    private final StopwatchRepository stopwatchRepository;

    public void saveTime(StopwatchDTO stopwatchDTO) {
        StopwatchEntity stopwatchEntity = new StopwatchEntity();
        stopwatchEntity.setTime(stopwatchDTO.time());
        stopwatchRepository.save(stopwatchEntity);
    }
}
