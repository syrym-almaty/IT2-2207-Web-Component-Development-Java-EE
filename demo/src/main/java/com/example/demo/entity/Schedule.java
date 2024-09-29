package com.example.demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String eventName;
    private LocalDate eventDate;
    private LocalTime startTime;
    private LocalTime endTime;

    public Schedule() {}

    public Schedule(String eventName, LocalDate eventDate, LocalTime startTime, LocalTime endTime) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getEventName() {return eventName;}

    public void setEventName(String eventName) {this.eventName = eventName;}

    public LocalDate getEventDate() {return eventDate;}

    public void setEventDate(LocalDate eventDate) {this.eventDate = eventDate;}

    public LocalTime getStartTime() {return startTime;}

    public void setStartTime(LocalTime startTime) {this.startTime = startTime;}

    public LocalTime getEndTime() {return endTime;}

    public void setEndTime(LocalTime endTime) {this.endTime = endTime;}
}
