package org.spring.calendar.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import org.spring.calendar.entity.Calendar;

@Getter
public class CalendarResponseDto {
    private Long id;
    private String title;
    private String content;
    private String personCharge;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public CalendarResponseDto(Calendar calender) {
        this.id = calender.getId();
        this.title = calender.getTitle();
        this.content = calender.getContent();
        this.personCharge = calender.getPersonCharge();
        this.password = calender.getPassword();
        this.createdAt = calender.getCreatedAt();
        this.modifiedAt = calender.getModifiedAt();
    }
}
