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
    public void saveTime(@RequestBody StopwatchDTO stopwatchDTO) {
        stopwatchService.saveTime(stopwatchDTO);
    }

    @GetMapping("/savedTimes")
    public List<StopwatchEntity> getSavedTimes() {
        return new ArrayList<>(stopwatchService.getSavedTimes());
    }
}
