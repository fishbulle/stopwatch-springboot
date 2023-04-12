package com.example.tidtagarur;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/api/timer")
public class StopwatchController {

    private final StopwatchService stopwatchService;

    @PostMapping
    public StopwatchDTO saveTime(@RequestBody StopwatchDTO stopwatchDTO) {
        return stopwatchService.saveTime(stopwatchDTO)
                .map(StopwatchController::timeDTO)
                .orElse(null);
    }

    @GetMapping
    public List<StopwatchDTO> getSavedTimes() {
        return stopwatchService.getSavedTimes()
                .stream()
                .map(StopwatchController::timeDTO)
                .collect(Collectors.toList());
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public void deleteTime(@PathVariable("id") Integer id) throws NotFoundException {
        stopwatchService.deleteTime(id);
    }

    private static StopwatchDTO timeDTO(StopwatchEntity stopwatchEntity) {
        return new StopwatchDTO(
                stopwatchEntity.getId(),
                stopwatchEntity.getTime(),
                stopwatchEntity.getDate()
        );
    }
}
