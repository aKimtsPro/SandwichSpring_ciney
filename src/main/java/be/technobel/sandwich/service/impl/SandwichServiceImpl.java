package be.technobel.sandwich.service.impl;

import be.technobel.sandwich.models.dto.SandwichDTO;
import be.technobel.sandwich.models.entity.Sandwich;
import be.technobel.sandwich.models.form.SandwichInsertForm;
import be.technobel.sandwich.repository.SandwichRepository;
import be.technobel.sandwich.service.SandwichService;
import be.technobel.sandwich.service.mapper.SandwichMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SandwichServiceImpl implements SandwichService {

    private final SandwichRepository sandwichRepository;
    private final SandwichMapper mapper;

    public SandwichServiceImpl(SandwichRepository sandwichRepository, SandwichMapper mapper) {
        this.sandwichRepository = sandwichRepository;
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
                .orElseThrow( () -> new RuntimeException("Sandwich not found") );
    }

    @Override
    public void insert(SandwichInsertForm form) {
        if( form == null )
            throw new IllegalArgumentException("form should not be null");

        Sandwich entity = mapper.toEntity(form);
        sandwichRepository.save( entity );
    }

}
