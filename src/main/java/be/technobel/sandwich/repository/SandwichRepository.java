package be.technobel.sandwich.repository;

import be.technobel.sandwich.models.entity.Sandwich;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SandwichRepository extends JpaRepository<Sandwich, Long> {
}
