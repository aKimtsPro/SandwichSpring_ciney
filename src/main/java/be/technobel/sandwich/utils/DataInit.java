package be.technobel.sandwich.utils;

import be.technobel.sandwich.models.entity.Sandwich;
import be.technobel.sandwich.models.entity.User;
import be.technobel.sandwich.repository.SandwichRepository;
import be.technobel.sandwich.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Log4j2
public class DataInit implements InitializingBean {

    private final SandwichRepository sandwichRepository;
    private final UserRepository userRepository;

    public DataInit(SandwichRepository sandwichRepository, UserRepository userRepository) {
        this.sandwichRepository = sandwichRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        log.info("-- INITIALIZING DB DATA --");

        Sandwich s1 = new Sandwich();
        s1.setName("Pesto");
        s1.setPrice(4.5);
        s1.setDescription("Pesto/Tomate");

        Sandwich s2 = new Sandwich();
        s2.setName("Houmous");
        s2.setPrice(4.5);
        s2.setDescription("Houmous/sésame");

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

        log.info("-- DATA INIT FINISHED --");
    }

}
