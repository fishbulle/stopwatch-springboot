package com.example.tidtagarur;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@AllArgsConstructor
public class StopwatchController {

    private final StopwatchService stopwatchService;

    @PostMapping("/create")
    public UUID createStopwatch() {
        return stopwatchService.createStopwatch()
                .getId();
    }

    @PostMapping("/save")
    public void saveTime(@RequestHeader(value = "id") UUID id,
                         @RequestBody StopwatchDTO stopwatchDTO) throws NotFoundException {
        stopwatchService.saveTime(stopwatchDTO, id);
    }

    @GetMapping("/savedTimes")
    public List<StopwatchEntity> getSavedTimes() {
        return new ArrayList<>(stopwatchService.getSavedTimes());
    }
}
