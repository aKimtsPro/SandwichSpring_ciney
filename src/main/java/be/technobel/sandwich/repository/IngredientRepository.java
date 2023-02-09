package be.technobel.sandwich.repository;

import be.technobel.sandwich.models.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
