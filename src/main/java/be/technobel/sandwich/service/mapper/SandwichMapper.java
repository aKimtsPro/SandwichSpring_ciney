package be.technobel.sandwich.service.mapper;

import be.technobel.sandwich.models.dto.SandwichDTO;
import be.technobel.sandwich.models.entity.Sandwich;
import org.springframework.stereotype.Service;

@Service
public class SandwichMapper {

    public SandwichDTO toDto(Sandwich entity){

        if( entity == null )
            return null;

        return SandwichDTO.builder()
                .id( entity.getId() )
                .name( entity.getName() )
                .desc( entity.getDescription() )
                .price( entity.getPrice() )
                .build();

    }

}
