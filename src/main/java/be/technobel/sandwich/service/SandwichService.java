package be.technobel.sandwich.service;

import be.technobel.sandwich.models.dto.SandwichDTO;
import be.technobel.sandwich.models.form.SandwichInsertForm;
import be.technobel.sandwich.models.form.SandwichUpdateForm;

import java.util.List;

public interface SandwichService {

    List<SandwichDTO> getAll();
    SandwichDTO getOne(Long id);
    void insert(SandwichInsertForm form);
    void update(Long id, SandwichUpdateForm form);
}
