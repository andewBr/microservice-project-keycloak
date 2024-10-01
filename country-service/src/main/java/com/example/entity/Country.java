package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "countries")
@Data
@NoArgsConstructor
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Автоинкрементное поле ID
    private Long id;

    @Column(name = "country_name", nullable = false)
    private String countryName;

//    @JsonIgnore
//    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
//    private List<CurriculumVitae> cvs;

    // Конструктор для удобства
    public Country(String countryName) {
        this.countryName = countryName;
    }
}