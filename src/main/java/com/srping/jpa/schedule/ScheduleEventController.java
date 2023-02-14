package com.srping.jpa.schedule;

import java.util.List;
import static java.util.stream.Collectors.toList;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/schedule")
@RequiredArgsConstructor
class ScheduleEventController {
  private final ScheduleEventService scheduleEventService;

  @GetMapping("events")
  public List<ScheduleEvent> getEvents(List<String> eventIds) {
    return scheduleEventService.getEvents(eventIds);
  }

  @PostMapping("/event")
  public ResponseEntity<ScheduleEvent> addEvent(@RequestBody ScheduleEvent event) {
    return ResponseEntity.ok(scheduleEventService.createScheduleEvent(event));
  }

  @PutMapping("/event")
  public ResponseEntity<ScheduleEvent> updateEvent(@RequestBody ScheduleEvent event) throws Exception {
    return ResponseEntity.ok(scheduleEventService.updateEvent(event));
  }

  @DeleteMapping("/event")
  public ResponseEntity<ScheduleEvent> updateEvent(@RequestBody List<ScheduleEvent> event) {
    List<String> eventIds = event.stream().map(ScheduleEvent::getId).collect(toList());
    scheduleEventService.deleteEvents(eventIds);
    return ResponseEntity.ok().build();
  }

}
