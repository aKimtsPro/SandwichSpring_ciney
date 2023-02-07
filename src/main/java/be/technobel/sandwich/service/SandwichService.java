package be.technobel.sandwich.service;

import be.technobel.sandwich.models.dto.SandwichDTO;

import java.util.List;

public interface SandwichService {

    List<SandwichDTO> getAll();
    SandwichDTO getOne(Long id);
}
