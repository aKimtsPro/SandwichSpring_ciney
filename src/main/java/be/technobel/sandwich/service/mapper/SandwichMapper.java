package be.technobel.sandwich.service.mapper;

import be.technobel.sandwich.models.dto.SandwichDTO;
import be.technobel.sandwich.models.entity.Sandwich;
import be.technobel.sandwich.models.form.SandwichInsertForm;
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

    public Sandwich toEntity(SandwichInsertForm form){
        if( form == null )
            return null;

        Sandwich sandwich = new Sandwich();

        sandwich.setName(form.getName() );
        sandwich.setPrice(form.getPrice());
        sandwich.setDescription(form.getDesc());

        return sandwich;
    }

}
