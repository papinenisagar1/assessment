package com.xib.assessment.controller;

import com.xib.assessment.dto.ManagerDto;
import com.xib.assessment.exception.ResourceNotFoundException;
import com.xib.assessment.model.Agent;
import com.xib.assessment.model.Team;
import com.xib.assessment.service.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class AssessmentController {

    @Autowired
    private AssessmentService assessmentService;

    /**
     * create agent agent
     * @param agent
     * @return
     */
    @PostMapping("/agents/createAgent")
    public Agent createAgent(@Valid @RequestBody Agent agent) {
        return assessmentService.createAgent(agent);
    }

    /**
     *
     * @param team
     * @return
     */
    @PostMapping("/teams/createTeam")
    public Team createTeam(@Valid @RequestBody Team team) {
        return assessmentService.createTeam(team);
    }


    /**
     *
     * @param id
     * @return
     * @throws ResourceNotFoundException
     */
    @GetMapping("/agents/{id}")
    public ResponseEntity < Agent > getAgentById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        return assessmentService.getAgentById(id);

    }

    /**
     *
     * @param id
     * @return
     * @throws ResourceNotFoundException
     */
    @GetMapping("/teams/{id}")
    public ResponseEntity < Team > getTeamById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        return assessmentService.getTeamById(id);

    }


    /**
     *
     * @return
     */
    @GetMapping("/allAgents")
    public List< Agent > getAllAgents() {
        return assessmentService.getAllAgents();
    }

    /**
     *
     * @return
     */
    @GetMapping("/allTeams")
    public List< Team > getAllTeams() {
        return assessmentService.getAllTeams();
    }

    /**
     *
     * @param pageable
     * @return
     */
    @RequestMapping(value = "agents/listPageable", method = RequestMethod.GET)
    Page<Agent> agentsPageable(Pageable pageable) {
        return assessmentService.agentsPageable(pageable);
    }

    /**
     *
     * @param
     * @return
     */
    @PostMapping("/manager/createManager")
    public String createManager(@Valid @RequestBody ManagerDto managerDto) {
         assessmentService.createManager(managerDto);
         return "sucessfully manager created";
    }

    /**
     *
     * @param id
     * @param teamDetails
     * @return
     * @throws ResourceNotFoundException
     */
    @PutMapping("/team/{id}/agent")
    public ResponseEntity < Agent > updateAgent(@PathVariable(value = "id") Long id,
                                                      @Valid @RequestBody Team teamDetails) throws ResourceNotFoundException {
        return assessmentService.updateAgent(id, teamDetails);

    }


}
