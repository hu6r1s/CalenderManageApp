package org.spring.calender.controller;

import java.util.List;
import org.spring.calender.dto.CalenderRequestDto;
import org.spring.calender.dto.CalenderResponseDto;
import org.spring.calender.service.CalenderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CalenderController {
    private final CalenderService calenderService;

    public CalenderController(CalenderService calenderService) {
        this.calenderService = calenderService;
    }

    @PostMapping("/calender")
    public CalenderResponseDto createCalender(@RequestBody CalenderRequestDto requestDto) {
        return calenderService.createCalender(requestDto);
    }
}
