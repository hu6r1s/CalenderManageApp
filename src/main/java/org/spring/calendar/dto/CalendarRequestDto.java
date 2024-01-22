package org.spring.calendar.dto;

import lombok.Getter;

@Getter
public class CalendarRequestDto {
    private String title;
    private String content;
    private String personCharge;
    private String password;
}
