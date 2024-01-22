package org.spring.calendar.controller;

import java.util.List;
import java.util.Map;
import org.spring.calendar.dto.CalendarRequestDto;
import org.spring.calendar.dto.CalendarResponseDto;
import org.spring.calendar.service.CalendarService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/calendar/{id}")
    public CalendarResponseDto getOne(@PathVariable Long id) {
        return calendarService.getOne(id);
    }

    @PatchMapping("/calendar/{id}")
    public CalendarResponseDto update(@PathVariable Long id, @RequestBody CalendarRequestDto requestDto) {
        return calendarService.update(id, requestDto);
    }

    @DeleteMapping("/calendar/{id}")
    public String delete(@PathVariable Long id, @RequestBody Map<String, String> password) {
        return calendarService.delete(id, password.get("password"));
    }
}
