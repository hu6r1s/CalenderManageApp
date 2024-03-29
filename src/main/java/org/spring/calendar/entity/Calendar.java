package org.spring.calendar.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.spring.calendar.dto.CalendarRequestDto;

@Entity
@Getter
@NoArgsConstructor
@Table(name="calender")
public class Calendar extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "person_charge", nullable = false)
    private String personCharge;

    @Column(name = "password", nullable = false)
    private String password;

    public Calendar(CalendarRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.personCharge = requestDto.getPersonCharge();
        this.password = requestDto.getPassword();
    }

    public void update(CalendarRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.personCharge = requestDto.getPersonCharge();
    }
}
