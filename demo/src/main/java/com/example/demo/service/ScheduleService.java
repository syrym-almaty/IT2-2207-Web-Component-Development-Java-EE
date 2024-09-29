package com.example.demo.service;


import com.example.demo.entity.Schedule;
import com.example.demo.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    public Schedule createSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    public Schedule getScheduleById(UUID id) {
        return scheduleRepository.findById(id).orElse(null);
    }

    public void deleteScheduleById(UUID id) {
        scheduleRepository.deleteById(id);
    }
}

