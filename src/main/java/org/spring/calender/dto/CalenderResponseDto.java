package org.spring.calender.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import org.spring.calender.entity.Calender;

@Getter
public class CalenderResponseDto {
    private Long id;
    private String title;
    private String content;
    private String personCharge;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public CalenderResponseDto(Calender calender) {
        this.id = calender.getId();
        this.title = calender.getTitle();
        this.content = calender.getContent();
        this.personCharge = calender.getPersonCharge();
        this.password = calender.getPassword();
        this.createdAt = calender.getCreatedAt();
        this.modifiedAt = calender.getModifiedAt();
    }
}
