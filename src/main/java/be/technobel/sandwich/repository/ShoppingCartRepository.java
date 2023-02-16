package be.technobel.sandwich.repository;

import be.technobel.sandwich.models.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

    Optional<ShoppingCart> findFirstByOwner_Email(String email);

}
