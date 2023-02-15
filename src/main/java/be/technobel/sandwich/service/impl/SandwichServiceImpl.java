package be.technobel.sandwich.service.impl;

import be.technobel.sandwich.exception.NotFoundException;
import be.technobel.sandwich.models.dto.SandwichDTO;
import be.technobel.sandwich.models.entity.Ingredient;
import be.technobel.sandwich.models.entity.Sandwich;
import be.technobel.sandwich.models.form.SandwichInsertForm;
import be.technobel.sandwich.models.form.SandwichUpdateForm;
import be.technobel.sandwich.repository.IngredientRepository;
import be.technobel.sandwich.repository.SandwichRepository;
import be.technobel.sandwich.service.SandwichService;
import be.technobel.sandwich.service.mapper.SandwichMapper;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SandwichServiceImpl implements SandwichService {

    private final SandwichRepository sandwichRepository;
    private final IngredientRepository ingredientRepository;
    private final SandwichMapper mapper;

    public SandwichServiceImpl(SandwichRepository sandwichRepository, IngredientRepository ingredientRepository, SandwichMapper mapper) {
        this.sandwichRepository = sandwichRepository;
        this.ingredientRepository = ingredientRepository;
        this.mapper = mapper;
    }

    @Override
    public List<SandwichDTO> getAll() {
        return sandwichRepository.findAll().stream()
                .map( mapper::toDto )
                .toList();
    }

    @Override
    public SandwichDTO getOne(Long id) {
        return sandwichRepository.findById(id)
                .map( mapper::toDto )
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public void insert(SandwichInsertForm form) {
        if( form == null )
            throw new IllegalArgumentException("form should not be null");

        Sandwich entity = mapper.toEntity(form);
        entity.setIngredients(
                new HashSet<>(ingredientRepository.findAllById(form.getIngredientsId()))
        );
        sandwichRepository.save( entity );
    }

    @Override
    public void update(Long id, SandwichUpdateForm form) {
        Sandwich toUpdate = sandwichRepository.findById(id)
                .orElseThrow(NotFoundException::new);

        toUpdate.setName( form.getName() );
        toUpdate.setDescription( form.getDesc() );
        toUpdate.setPrice( form.getPrice() );
        toUpdate.setIngredients(
                new HashSet<>(ingredientRepository.findAllById(form.getIngredientsId()))
        );

        sandwichRepository.save(toUpdate);
    }

}
