package com.xib.assessment.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "manager_team")
public class ManagerTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "team_id")
    private Team team;

    @ManyToOne()
    @JoinColumn(name = "manager_id")
    private Manager manager;
}
