package com.xib.assessment.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "managers")
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
}
