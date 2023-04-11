package com.example.tidtagarur;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public void saveTime(StopwatchDTO stopwatchDTO, UUID id) throws NotFoundException {
        Optional<StopwatchEntity> stopwatchEntity = stopwatchRepository.findById(id);

        if (stopwatchEntity.isPresent()) {
            stopwatchEntity.get().setTime(stopwatchDTO.time());
            stopwatchRepository.save(stopwatchEntity.get());
        } else {
            throw new NotFoundException("Can't find stopwatch.");
        }
    }

    public List<StopwatchEntity> getSavedTimes() {
        return stopwatchRepository.findAll();
    }
}
