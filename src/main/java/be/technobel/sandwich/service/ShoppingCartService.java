package be.technobel.sandwich.service;

import be.technobel.sandwich.models.dto.ShoppingCartDTO;
import be.technobel.sandwich.models.form.AddToCartForm;

public interface ShoppingCartService {

    ShoppingCartDTO getCartByUserEmail(String email);
    void addToCart(String userEmail, AddToCartForm form);

}
