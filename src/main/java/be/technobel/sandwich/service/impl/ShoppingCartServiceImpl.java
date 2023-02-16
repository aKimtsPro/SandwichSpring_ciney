package be.technobel.sandwich.service.impl;

import be.technobel.sandwich.exception.NotFoundException;
import be.technobel.sandwich.models.dto.ShoppingCartDTO;
import be.technobel.sandwich.models.entity.CartItem;
import be.technobel.sandwich.models.entity.ShoppingCart;
import be.technobel.sandwich.models.form.AddToCartForm;
import be.technobel.sandwich.repository.SandwichRepository;
import be.technobel.sandwich.repository.ShoppingCartRepository;
import be.technobel.sandwich.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final SandwichRepository sandwichRepository;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository, SandwichRepository sandwichRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.sandwichRepository = sandwichRepository;
    }

    @Override
    public ShoppingCartDTO getCartByUserEmail(String email) {
        return shoppingCartRepository.findFirstByOwner_Email(email)
                .map(ShoppingCartDTO::from)
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public void addToCart(String userEmail, AddToCartForm form) {
        ShoppingCart cart = shoppingCartRepository.findFirstByOwner_Email(userEmail)
                .orElseThrow(NotFoundException::new);

        Optional<CartItem> cartItemOpt = cart.getItems().stream()
                .filter( item -> item.getProduct().getId().equals( form.getProductId() ) )
                .findFirst();

        if(cartItemOpt.isPresent() ){
            CartItem item = cartItemOpt.get();
            item.setQtt( item.getQtt() + form.getQtt() );
        }
        else {
            CartItem item = new CartItem();
            item.setCart(cart);
            item.setQtt(form.getQtt());
            item.setProduct( sandwichRepository.findById(form.getProductId()).orElseThrow(NotFoundException::new) );
            item.setId(
                    new CartItem.Id(
                            item.getCart().getId(),
                            item.getProduct().getId()
            ));
            cart.getItems().add(item);
        }

        shoppingCartRepository.save(cart);
    }

}
