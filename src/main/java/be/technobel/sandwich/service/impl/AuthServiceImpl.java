package be.technobel.sandwich.service.impl;

import be.technobel.sandwich.exception.EmailAlreadyTakenException;
import be.technobel.sandwich.models.entity.ShoppingCart;
import be.technobel.sandwich.models.entity.User;
import be.technobel.sandwich.models.form.RegisterForm;
import be.technobel.sandwich.repository.ShoppingCartRepository;
import be.technobel.sandwich.repository.UserRepository;
import be.technobel.sandwich.service.AuthService;
import be.technobel.sandwich.service.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final ShoppingCartRepository shoppingCartRepository;
    private final UserMapper userMapper;

    public AuthServiceImpl(UserRepository userRepository, ShoppingCartRepository shoppingCartRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.shoppingCartRepository = shoppingCartRepository;
        this.userMapper = userMapper;
    }

    @Override
    public void register(RegisterForm form) {

        if( userRepository.existsByEmail(form.getEmail()) )
            throw new EmailAlreadyTakenException();

        User user = userMapper.toEntity(form);
        user.setRole("CUSTOMER");
        user = userRepository.save( user );

        ShoppingCart cart = new ShoppingCart();
        cart.setOwner(user);
        shoppingCartRepository.save(cart);

    }

}
