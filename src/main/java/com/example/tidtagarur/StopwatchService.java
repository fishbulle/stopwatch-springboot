package com.example.tidtagarur;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class StopwatchService {

    private final StopwatchRepository stopwatchRepository;

    public StopwatchEntity createStopwatch() {
        StopwatchEntity stopwatchEntity = new StopwatchEntity(
                UUID.randomUUID()
        );
        stopwatchRepository.save(stopwatchEntity);

        return stopwatchEntity;
    }

    public void saveTime(StopwatchDTO stopwatchDTO) {


        stopwatchEntity.setTime(stopwatchDTO.time());
        stopwatchRepository.save(stopwatchEntity);
    }

    public List<StopwatchEntity> getSavedTimes() {
        return stopwatchRepository.findAll();
    }
}
