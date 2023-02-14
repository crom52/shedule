package com.srping.jpa.schedule;

import java.time.Instant;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleEvent {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  Long id;
  String title;
  Instant start;
  Instant end;
  boolean allDay;
  String content;
}
