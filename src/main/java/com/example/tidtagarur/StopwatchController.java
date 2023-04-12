package com.example.tidtagarur;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class StopwatchController {

    private final StopwatchService stopwatchService;

    @CrossOrigin
    @PostMapping("/saveTime")
    public StopwatchDTO saveTime(@RequestBody StopwatchDTO stopwatchDTO) {
        return stopwatchService.saveTime(stopwatchDTO)
                .map(StopwatchController::timeDTO)
                .orElse(null);
    }

    @CrossOrigin
    @GetMapping("/listTimes")
    public List<StopwatchDTO> getSavedTimes() {
        return stopwatchService.getSavedTimes()
                .stream()
                .map(StopwatchController::timeDTO)
                .collect(Collectors.toList());
    }

    @CrossOrigin
    @DeleteMapping("/delete")
    public void deleteTime(@RequestBody StopwatchDTO stopwatchDTO) throws NotFoundException {
        stopwatchService.deleteTime(stopwatchDTO.id());
    }

    private static StopwatchDTO timeDTO(StopwatchEntity stopwatchEntity) {
        return new StopwatchDTO(
                stopwatchEntity.getId(),
                stopwatchEntity.getTime()
        );
    }
}
