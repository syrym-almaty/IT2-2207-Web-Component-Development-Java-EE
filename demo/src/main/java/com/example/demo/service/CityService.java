package com.example.demo.service;

import com.example.demo.entity.City;
import com.example.demo.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    public City findCityById(UUID uuid) {
        return cityRepository.findById(uuid).orElse(null);
    }

    public City createCity(City city) {
        return cityRepository.save(city);
    }

    public void deleteCityById(UUID uuid) {
        cityRepository.deleteById(uuid);
    }
}
