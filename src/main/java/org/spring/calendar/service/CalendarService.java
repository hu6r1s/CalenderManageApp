package org.spring.calendar.service;

import jakarta.transaction.Transactional;
import java.util.List;
import org.spring.calendar.dto.CalendarRequestDto;
import org.spring.calendar.dto.CalendarResponseDto;
import org.spring.calendar.entity.Calendar;
import org.spring.calendar.exception.CalendarExceptionHandler;
import org.spring.calendar.exception.CalendarNotFoundException;
import org.spring.calendar.exception.InvalidPasswordException;
import org.spring.calendar.repository.CalendarRepository;
import org.springframework.stereotype.Service;

@Service
public class CalendarService {
    private final CalendarRepository calenderRepository;
    private CalendarExceptionHandler calendarExceptionHandler;
    public CalendarService(CalendarRepository calenderRepository) {
        this.calenderRepository = calenderRepository;
    }

    @Transactional
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

    @Transactional
    public CalendarResponseDto update(Long id, CalendarRequestDto requestDto) {
        Calendar calendar = calenderRepository.findById(id).orElseThrow(() ->
                new CalendarNotFoundException("일정 수정 실패: 존재하지 않은 ID입니다.")
        );
        if (!calendar.getPassword().equals(requestDto.getPassword())) {
            throw new InvalidPasswordException("일정 수정 실패: 비밀번호가 일치하지 않습니다.");
        }
        calendar.update(requestDto);
        calenderRepository.save(calendar);

        return new CalendarResponseDto(calendar);
    }

    @Transactional
    public String delete(Long id, String password) {
        Calendar calendar = calenderRepository.findById(id).orElseThrow(() ->
                new CalendarNotFoundException("일정 삭제 실패: 존지하지 않은 ID입니다.")
        );
        if (!password.equals(calendar.getPassword())) {
            throw new InvalidPasswordException("일정 삭제 실패: 비밀번호가 일치하지 않습니다.");
        }
        calenderRepository.delete(calendar);

        return "정상적으로 삭제 완료하였습니다.";
    }
}
