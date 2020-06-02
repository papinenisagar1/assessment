package com.xib.assessment.service;

import com.xib.assessment.dto.ManagerDto;
import com.xib.assessment.exception.ResourceNotFoundException;
import com.xib.assessment.model.Agent;
import com.xib.assessment.model.Manager;
import com.xib.assessment.model.ManagerTeam;
import com.xib.assessment.model.Team;
import com.xib.assessment.repository.AgentRepository;
import com.xib.assessment.repository.ManagerRepository;
import com.xib.assessment.repository.ManagerTeamRepository;
import com.xib.assessment.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssessmentService {

    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private ManagerTeamRepository managerTeamRepository;

    public Agent createAgent(Agent agent) {
        return agentRepository.save(agent);
    }

    public Team createTeam(Team team) { return teamRepository.save(team); }

    public ResponseEntity<Agent> getAgentById(Long id) throws ResourceNotFoundException {
                Agent agent = agentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Agent not found for this id :: " + id));
        return ResponseEntity.ok().body(agent);
    }

    public ResponseEntity<Team> getTeamById(Long id) throws ResourceNotFoundException {
        Team team = teamRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Team not found for this id :: " + id));
        return ResponseEntity.ok().body(team);
    }

    public List<Agent> getAllAgents() {
        return agentRepository.findAll();
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Page<Agent> agentsPageable(Pageable pageable) {
        return agentRepository.findAll(pageable);
    }

    public void createManager(ManagerDto managerDto) {
        Manager manager = new Manager();
        manager.setName(managerDto.getName());
        manager = managerRepository.save(manager);


        ManagerTeam managerTeam = null;
        Team team = null;
        for (Long teamId : managerDto.getTeamIds()) {

            managerTeam = new ManagerTeam();
            team = new Team();
            team.setId(teamId);
            managerTeam.setManager(manager);
            managerTeam.setTeam(team);
            managerTeamRepository.save(managerTeam);

        }

    }

    public ResponseEntity<Agent> updateAgent(Long id, Team teamDetails) throws ResourceNotFoundException {
                Agent agent = agentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Agent not found for this id :: " + id));
        agent.setTeam(teamDetails);
        final Agent updatedAgent = agentRepository.save(agent);
        return ResponseEntity.ok(updatedAgent);
    }

}
