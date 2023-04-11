package com.example.tidtagarur;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@AllArgsConstructor
public class TimerController {

    private final TimerService timerService;

    @PostMapping("/save")
    public void saveTime(@RequestBody TimerDTO timerDTO) {
        timerService.saveTime(timerDTO);
    }

    private TimerDTO timerEntityToDTO(TimerEntity timerEntity) {

        return new TimerDTO(
                timerEntity.getId(),
                timerEntity.getTime()
        );
    }
}
