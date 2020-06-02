package com.xib.assessment.repository;

import com.xib.assessment.model.ManagerTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerTeamRepository extends JpaRepository<ManagerTeam, Long> {
}
