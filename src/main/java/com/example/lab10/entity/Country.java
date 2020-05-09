package com.example.lab10.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private int countryId;
    @NotNull
    @Size(min = 2,max = 100,message = "Country name must be minimum 2 characters and maximum 100 characters")
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="cID", referencedColumnName = "countryId")
    private List<City> cities;
}
