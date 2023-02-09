package be.technobel.sandwich.service.impl;

import be.technobel.sandwich.models.dto.IngredientDTO;
import be.technobel.sandwich.models.entity.Ingredient;
import be.technobel.sandwich.repository.IngredientRepository;
import be.technobel.sandwich.service.IngredientService;
import be.technobel.sandwich.service.mapper.IngredientMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;
    private final IngredientMapper ingredientMapper;

    public IngredientServiceImpl(IngredientRepository ingredientRepository, IngredientMapper ingredientMapper) {
        this.ingredientRepository = ingredientRepository;
        this.ingredientMapper = ingredientMapper;
    }

    @Override
    public List<IngredientDTO> getAll() {
        return ingredientRepository.findAll().stream()
                .map(ingredientMapper::toDto)
                .toList();
    }

    @Override
    public IngredientDTO getOne(long id) {
        return ingredientRepository.findById(id)
                .map( ingredientMapper::toDto )
                .orElseThrow(() -> new RuntimeException("Ingredient not found"));
    }

    @Override
    public void insert(String name) {
        Ingredient entity = new Ingredient();
        entity.setName(name);
        ingredientRepository.save(entity);
    }

    @Override
    public void delete(long id) {
        if( !ingredientRepository.existsById(id) )
            throw new RuntimeException("Ingredient not found");

        ingredientRepository.deleteById(id);
    }
}
