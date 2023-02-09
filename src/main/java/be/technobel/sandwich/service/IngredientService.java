package be.technobel.sandwich.service;


import be.technobel.sandwich.models.dto.IngredientDTO;

import java.util.List;

public interface IngredientService {

    List<IngredientDTO> getAll();
    IngredientDTO getOne(long id);

    void insert(String name);

    void delete(long id);

}
