package com.example.demo.controller;

import com.example.demo.entity.Schedule;
import com.example.demo.service.ScheduleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/schedules")
@Tag(name = "Schedule Controller", description = "CRUD operations for Schedules")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @Operation(summary = "Get All Schedules", description = "Retrieve a list of all schedules")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved list")
    @GetMapping
    public List<Schedule> getAllSchedules() {
        return scheduleService.getAllSchedules();
    }

    @Operation(summary = "Create Schedule", description = "Create a new schedule")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Schedule created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping
    public Schedule createSchedule(
            @Parameter(description = "Schedule object to be created", required = true)
            @RequestBody Schedule schedule) {
        return scheduleService.createSchedule(schedule);
    }

    @Operation(summary = "Get Schedule by ID", description = "Retrieve a schedule by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved schedule"),
            @ApiResponse(responseCode = "404", description = "Schedule not found")
    })
    @GetMapping("/{id}")
    public Schedule getScheduleById(
            @Parameter(description = "UUID of the schedule to retrieve", required = true)
            @PathVariable UUID id) {
        return scheduleService.getScheduleById(id);
    }

    @Operation(summary = "Delete Schedule", description = "Delete a schedule by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Schedule deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Schedule not found")
    })
    @DeleteMapping("/{id}")
    public void deleteSchedule(
            @Parameter(description = "UUID of the schedule to delete", required = true)
            @PathVariable UUID id) {
        scheduleService.deleteScheduleById(id);
    }
}
