package com.srping.jpa.schedule;

import java.util.List;
import static java.util.stream.Collectors.toList;
import static java.util.stream.StreamSupport.stream;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import static org.springframework.util.CollectionUtils.isEmpty;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
class ScheduleEventService {
  private final MongoScheduleEventRepository mongoRepo;

  public ScheduleEvent createScheduleEvent(@RequestBody ScheduleEvent event) {
    return mongoRepo.insert(event);
  }

  public ScheduleEvent updateEvent(ScheduleEvent event) throws Exception {
    List<ScheduleEvent> events = getEvents(List.of(event.getId()));
    return events.stream().findFirst().map(mongoRepo::save).orElseThrow(Exception::new);
  }

  public List<ScheduleEvent> getEvents(List<String> eventIds) {
    if (isEmpty(eventIds)) {
      return mongoRepo.findAll();
    }
    return stream(mongoRepo.findAllById(eventIds).spliterator(), false).collect(toList());
  }

  public void deleteEvents(List<String> eventIds) {
    if (isEmpty(eventIds)) {
      return;
    }
    mongoRepo.deleteAllById(eventIds);
  }

}
