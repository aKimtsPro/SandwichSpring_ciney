package be.technobel.sandwich.service;

import be.technobel.sandwich.models.dto.SandwichDTO;
import be.technobel.sandwich.models.form.SandwichInsertForm;

import java.util.List;

public interface SandwichService {

    List<SandwichDTO> getAll();
    SandwichDTO getOne(Long id);
    void insert(SandwichInsertForm form);
}
