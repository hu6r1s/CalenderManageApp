package org.spring.calendar.repository;

import java.util.List;
import org.spring.calendar.entity.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalendarRepository extends JpaRepository<Calendar, Long> {
    public List<Calendar> findAllByOrderByCreatedAtDesc();
}
