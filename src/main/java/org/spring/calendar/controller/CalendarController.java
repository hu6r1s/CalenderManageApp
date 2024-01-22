package org.spring.calendar.controller;

import java.util.List;
import org.spring.calendar.dto.CalendarRequestDto;
import org.spring.calendar.dto.CalendarResponseDto;
import org.spring.calendar.service.CalendarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CalendarController {
    private final CalendarService calendarService;

    public CalendarController(CalendarService calendarService) {
        this.calendarService = calendarService;
    }

    @PostMapping("/calendar")
    public CalendarResponseDto createCalender(@RequestBody CalendarRequestDto requestDto) {
        return calendarService.createCalender(requestDto);
    }

    @GetMapping("/calendars")
    public List<CalendarResponseDto> getAll() {
        return calendarService.getAll();
    }
}
