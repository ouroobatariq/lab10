package com.example.lab10.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="user")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ApplicationUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Username cannot be blank")
    @Column(unique = true)
    private String username;
    @NotBlank(message = "Password cannot be blank")
    private String password;

}
