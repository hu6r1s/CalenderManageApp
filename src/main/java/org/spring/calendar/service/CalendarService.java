package org.spring.calendar.service;

import org.spring.calendar.dto.CalendarRequestDto;
import org.spring.calendar.dto.CalendarResponseDto;
import org.spring.calendar.entity.Calendar;
import org.spring.calendar.repository.CalendarRepository;
import org.springframework.stereotype.Service;

@Service
public class CalendarService {
    private final CalendarRepository calenderRepository;

    public CalendarService(CalendarRepository calenderRepository) {
        this.calenderRepository = calenderRepository;
    }

    public CalendarResponseDto createCalender(CalendarRequestDto requestDto) {
        Calendar calender = new Calendar(requestDto);
        calenderRepository.save(calender);
        return new CalendarResponseDto(calender);
    }
}