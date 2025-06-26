package com.amardeep.projectx.services;

import com.amardeep.projectx.dto.EmployeeDTO;
import com.amardeep.projectx.entities.EmployeeEntity;
import com.amardeep.projectx.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    final EmployeeRepository employeeRepository;
    final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public EmployeeDTO getEmployeeById(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));

//          return new EmployeeDTO(employeeEntity.getId(), employeeEntity.getName(), employeeEntity.getDateOfJoining(), employeeEntity.isActive());
//          return modelMapper.map(employeeEntity, EmployeeDTO.class);
        return EmployeeDTO.getDetailDTO(employeeEntity);
    }

    public EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        return modelMapper.map(employeeRepository.save(employeeEntity), EmployeeDTO.class);
    }

    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        return employeeEntities.stream()
                .map(EmployeeDTO::getDetailDTO)
                .collect(Collectors.toList());
    }

    public void deleteEmployee(Long id) {
        boolean isPresent = employeeRepository.existsById(id);
        if (isPresent) {
            employeeRepository.deleteById(id);
        }
    }
}
