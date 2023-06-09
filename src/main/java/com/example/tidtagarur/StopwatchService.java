package com.example.tidtagarur;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StopwatchService {

    private final StopwatchRepository stopwatchRepository;

    public Optional<StopwatchEntity> saveTime(StopwatchDTO stopwatchDTO) {
        StopwatchEntity stopwatchEntity = new StopwatchEntity(
                null,
                stopwatchDTO.time(),
                LocalDate.now()
        );
        stopwatchRepository.save(stopwatchEntity);
        return Optional.of(stopwatchEntity);
    }

    public List<StopwatchEntity> getSavedTimes() {
        return stopwatchRepository.findAll();
    }

    public void deleteTime(Integer id) throws NotFoundException {
        if (stopwatchRepository.existsById(id)) {
            stopwatchRepository.deleteById(id);
        } else {
            throw new NotFoundException("Stopwatch not found");
        }
    }
}
