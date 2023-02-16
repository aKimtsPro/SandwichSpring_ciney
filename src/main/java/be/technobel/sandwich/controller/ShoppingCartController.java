package be.technobel.sandwich.controller;

import be.technobel.sandwich.models.form.AddToCartForm;
import be.technobel.sandwich.service.ShoppingCartService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @PostMapping("/add")
    public String addToCart(@ModelAttribute @Valid AddToCartForm form, BindingResult bindingResult, HttpServletRequest request){
        shoppingCartService.addToCart("user@customer.be", form);
        return "redirect:"+request.getHeader("referer");
    }

    @GetMapping
    public String displayCart(Model model){
        model.addAttribute("cart", shoppingCartService.getCartByUserEmail("user@customer.be"));
        return "cart/display-cart";
    }

}
