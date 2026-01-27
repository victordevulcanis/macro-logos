package com.vulcanis.macrologos.domain.entity;

import com.vulcanis.macrologos.domain.enums.ActivityLevel;
import com.vulcanis.macrologos.domain.enums.BiologicalSex;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "tb_users")
@Data
@ToString(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class User {

    @Id
    @ToString.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false)
    private Double weight;

    @Column(nullable = false)
    private Double height;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BiologicalSex biologicalSex;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ActivityLevel activityLevel;

    public Integer getAge(LocalDate referenceDate){
        return Period.between(this.birthDate, referenceDate).getYears();
    }

}