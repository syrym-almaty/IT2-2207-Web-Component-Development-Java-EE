package com.example.demo.controller;

import com.example.demo.entity.City;
import com.example.demo.service.CityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/cities")
@Tag(name = "City Controller", description = "CRUD operations for City")
public class CityController {

    @Autowired
    private CityService cityService;

    @Operation(summary = "Get all Cities", description = "Gives a list of all cities")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved list")
    @GetMapping
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }

    @Operation(summary = "Create City", description = "Creates a new City")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "City was created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping
    public City createCity(
            @Parameter(description = "City object to be created", required = true)
            @RequestBody City city) {
        return cityService.createCity(city);
    }

    @Operation(summary = "Get City by ID", description = "Finds a city by its ID")
    @GetMapping("/{id}")
    public City getCityById(
            @Parameter(description = "UUID of the City to find", required = true)
            @PathVariable UUID id) {
        return cityService.findCityById(id);
    }

    @Operation(summary = "Delete City by ID", description = "Deletes a city by its ID")
    @DeleteMapping("/{id}")
    public void deleteCityById(
            @Parameter(description = "UUID of the City to delete", required = true)
            @PathVariable UUID id) {
        cityService.deleteCityById(id);
    }
}
