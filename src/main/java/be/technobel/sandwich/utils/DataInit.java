package be.technobel.sandwich.utils;

import be.technobel.sandwich.models.entity.Ingredient;
import be.technobel.sandwich.models.entity.Sandwich;
import be.technobel.sandwich.models.entity.ShoppingCart;
import be.technobel.sandwich.models.entity.User;
import be.technobel.sandwich.repository.IngredientRepository;
import be.technobel.sandwich.repository.SandwichRepository;
import be.technobel.sandwich.repository.ShoppingCartRepository;
import be.technobel.sandwich.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Set;

@Component
@Log4j2
public class DataInit implements InitializingBean {

    private final SandwichRepository sandwichRepository;
    private final UserRepository userRepository;
    private final IngredientRepository ingredientRepository;
    private final ShoppingCartRepository shoppingCartRepository;

    public DataInit(SandwichRepository sandwichRepository, UserRepository userRepository, IngredientRepository ingredientRepository, ShoppingCartRepository shoppingCartRepository) {
        this.sandwichRepository = sandwichRepository;
        this.userRepository = userRepository;
        this.ingredientRepository = ingredientRepository;
        this.shoppingCartRepository = shoppingCartRepository;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        log.info("-- INITIALIZING DB DATA --");

        Ingredient ingredient1 = new Ingredient();
        ingredient1.setName("tomate");
        Ingredient ingredient2 = new Ingredient();
        ingredient2.setName("pesto");
        Ingredient ingredient3 = new Ingredient();
        ingredient3.setName("houmous");
        Ingredient ingredient4 = new Ingredient();
        ingredient4.setName("huile d'olive");

        ingredient1 = ingredientRepository.save(ingredient1);
        ingredient2 = ingredientRepository.save(ingredient2);
        ingredient3 = ingredientRepository.save(ingredient3);
        ingredient4 = ingredientRepository.save(ingredient4);


        Sandwich s1 = new Sandwich();
        s1.setName("Italien");
        s1.setPrice(4.5);
        s1.setDescription("Les bons gouts de l'Italie");
        s1.setIngredients(
                Set.of(
                        ingredient1,
                        ingredient2
                )
        );

        Sandwich s2 = new Sandwich();
        s2.setName("Houmous");
        s2.setPrice(4.5);
        s2.setDescription("Houmous/sésame");
        s2.setIngredients(
                Set.of(
                        ingredient3,
                        ingredient4
                )
        );

        s1 = sandwichRepository.save(s1);
        s2 = sandwichRepository.save(s2);

        User user = new User();

        user.setEmail("user@customer.be");
        user.setPassword("pass");
        user.setRole("CUSTOMER");
        user.setFirstName("user");
        user.setLastName("customer");
        user.setBirthdate(LocalDate.EPOCH);

        user = userRepository.save(user);

        ShoppingCart cart = new ShoppingCart();
        cart.setOwner(user);
        cart = shoppingCartRepository.save(cart);

        log.info("-- DATA INIT FINISHED --");
    }

}
