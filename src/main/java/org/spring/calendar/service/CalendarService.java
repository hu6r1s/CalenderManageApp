package org.spring.calendar.service;

import java.util.List;
import java.util.Optional;
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

    public List<CalendarResponseDto> getAll() {
        return calenderRepository.findAllByOrderByCreatedAtDesc().stream().map(CalendarResponseDto::new).toList();
    }

    public CalendarResponseDto getOne(Long id) {
        Calendar calendar = calenderRepository.findById(id).orElse(null);
        return new CalendarResponseDto(calendar);
    }

    public CalendarResponseDto update(Long id, CalendarRequestDto requestDto) {
        Calendar calendar = calenderRepository.findById(id).orElse(null);
        if (calendar.getPassword().equals(requestDto.getPassword())) {
            calendar.update(requestDto);
            calenderRepository.save(calendar);
        }
        return new CalendarResponseDto(calendar);
    }

    public String delete(Long id, String password) {
        Calendar calendar = calenderRepository.findById(id).orElse(null);
        if (password.equals(calendar.getPassword())) {
            calenderRepository.delete(calendar);
            return "삭제 완료";
        } else {
            return "삭제 실패";
        }
    }
}
