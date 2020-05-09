package com.example.lab10.controllers;

import com.example.lab10.entity.City;
import com.example.lab10.entity.Country;
import com.example.lab10.service.CityService;
import com.example.lab10.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/country")
public class CountryController {
    @Autowired
    private CountryService countryService;
    @GetMapping
    private List<Country> getAll()
    {
        return countryService.getAll();
    }
    @GetMapping("/{id}")
    private Country getById(@PathVariable int id){
        return countryService.getById(id);
    }
    @PostMapping
    private ResponseEntity<?> add(@Valid @RequestBody Country country, BindingResult result){
        if(result.hasErrors()){
            Map<String, String> errors=new HashMap<>();
            for (FieldError error:result.getFieldErrors()){
                errors.put(error.getField(),error.getDefaultMessage());
            }
            return new ResponseEntity<Map<String, String>>(errors, HttpStatus.BAD_REQUEST);
        }
        Country country1= countryService.addOrUpdate(country);
        return new ResponseEntity<Country>(country1,HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    private ResponseEntity<?> update(@PathVariable int id, @RequestBody Country country, BindingResult result){
        country.setCountryId(id);
        if(result.hasErrors()){
            Map<String, String> errors=new HashMap<>();
            for (FieldError error:result.getFieldErrors()){
                errors.put(error.getField(),error.getDefaultMessage());
            }
            return new ResponseEntity<Map<String, String>>(errors, HttpStatus.BAD_REQUEST);
        }
        Country country1= countryService.addOrUpdate(country);
        return new ResponseEntity<Country>(country1,HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    private ResponseEntity<?> delete(@PathVariable int id){
        countryService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
