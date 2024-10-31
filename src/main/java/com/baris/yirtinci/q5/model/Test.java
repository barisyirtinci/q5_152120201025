package com.baris.yirtinci.q5.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "test")
@Data
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String password;
}