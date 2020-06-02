package com.xib.assessment.dto;

import lombok.Data;

import java.util.List;

@Data
public class ManagerDto {
    private Long id;
    private String name;
    private List<Long> teamIds;
}
