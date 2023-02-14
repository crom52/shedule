package com.srping.jpa.schedule;

import java.util.List;
import static java.util.stream.Collectors.toList;
import static java.util.stream.StreamSupport.stream;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import static org.springframework.util.CollectionUtils.isEmpty;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
  private final MongoScheduleEventRepository mongoRepo;

  @GetMapping("events")
  public List<ScheduleEvent> getEvents(List<String> eventIds) {
    if (isEmpty(eventIds)) {
      return mongoRepo.findAll();
    }
    return stream(mongoRepo.findAllById(eventIds).spliterator(), false).collect(toList());
  }

  @PostMapping("/event")
  public ScheduleEvent createScheduleEvent(@RequestBody ScheduleEvent event) {
    return mongoRepo.insert(event);
  }
}
