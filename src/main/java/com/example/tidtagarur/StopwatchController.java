package com.example.tidtagarur;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor
public class StopwatchController {

    private final StopwatchService stopwatchService;

    @PostMapping("/save")
    public void saveTime(@RequestBody StopwatchDTO stopwatchDTO) {
        stopwatchService.saveTime(stopwatchDTO);
    }

    @GetMapping("/savedTimes")
    public List<StopwatchEntity> getSavedTimes() {
        return new ArrayList<>(stopwatchService.getSavedTimes());
    }
}
