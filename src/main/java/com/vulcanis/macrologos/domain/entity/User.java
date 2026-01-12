package com.vulcanis.macrologos.domain.entity;

import com.vulcanis.macrologos.domain.enums.ActivityLevel;
import com.vulcanis.macrologos.domain.enums.BiologicalSex;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "tb_users")
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    private Double weight;

    private Double height;

    @Enumerated(EnumType.STRING)
    private BiologicalSex sex;

    @Enumerated(EnumType.STRING)
    private ActivityLevel activityLevel;

}