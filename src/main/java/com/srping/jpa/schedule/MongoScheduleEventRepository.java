package com.srping.jpa.schedule;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoScheduleEventRepository extends MongoRepository<ScheduleEvent, String> {
}
