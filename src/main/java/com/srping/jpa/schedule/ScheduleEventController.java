package com.srping.jpa.schedule;

import java.time.Instant;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/schedule")
@Component
@RequiredArgsConstructor
class ScheduleEventController {
  private final MongoBillRepository mongoBillRepository;

  @PostMapping("/event")
  public ScheduleEvent createScheduleEvent(@RequestBody ScheduleEvent event) {
    return mongoBillRepository.insert(event);
  }
}
