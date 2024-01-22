package org.spring.calender.service;

import java.util.List;
import org.spring.calender.dto.CalenderRequestDto;
import org.spring.calender.dto.CalenderResponseDto;
import org.spring.calender.entity.Calender;
import org.spring.calender.repository.CalenderRepository;
import org.springframework.stereotype.Service;

@Service
public class CalenderService {
    private final CalenderRepository calenderRepository;

    public CalenderService(CalenderRepository calenderRepository) {
        this.calenderRepository = calenderRepository;
    }

    public CalenderResponseDto createCalender(CalenderRequestDto requestDto) {
        Calender calender = new Calender(requestDto);
        calenderRepository.save(calender);
        return new CalenderResponseDto(calender);
    }
}
