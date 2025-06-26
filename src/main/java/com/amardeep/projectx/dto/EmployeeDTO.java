package com.amardeep.projectx.dto;

import com.amardeep.projectx.entities.EmployeeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDTO {
    private long id;
    private String name;
    private LocalDate dateOfJoining;
    private boolean isActive;

    public static EmployeeDTO getBasicDTO(EmployeeEntity employee) {
        return EmployeeDTO.builder()
                .id(employee.getId())
                .name(employee.getName())
                .build();
    }

    public static EmployeeDTO getDetailDTO(EmployeeEntity employee) {
        return EmployeeDTO.builder()
                .id(employee.getId())
                .name(employee.getName())
                .dateOfJoining(employee.getDateOfJoining())
                .build();
    }

}
