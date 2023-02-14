package com.srping.jpa.repository;

import com.srping.jpa.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
}
