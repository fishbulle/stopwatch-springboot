package com.example.tidtagarur;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@AllArgsConstructor
public class StopwatchController {

    private final StopwatchService stopwatchService;

    @PostMapping("/save")
    public void saveTime(@RequestBody StopwatchDTO stopwatchDTO) {
        stopwatchService.saveTime(stopwatchDTO);
    }

    // GetMapping för att lista sparade tider

    private StopwatchDTO stopwatchEntityToDTO(StopwatchEntity stopwatchEntity) {

        return new StopwatchDTO(
                stopwatchEntity.getId(),
                stopwatchEntity.getTime()
        );
    }
}
