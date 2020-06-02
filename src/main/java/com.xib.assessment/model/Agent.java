package com.xib.assessment.model;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
@Table(name = "agents")
    public class Agent implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        @Column(name = "first_name", nullable = false)
        private String firstName;
        @Column(name = "last_name", nullable = false)
        private String lastName;
        @Column(name = "id_number", nullable = false)
        private String idNumber;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "teamId")
    private Team team;
    @ManyToOne
    @JoinColumn(name = "managerId")
    private Manager manager;
}
