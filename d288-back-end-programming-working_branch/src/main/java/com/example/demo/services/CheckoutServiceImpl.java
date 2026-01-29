package com.example.demo.services;

import com.example.demo.dao.CartItemRepository;
import com.example.demo.dao.CartRepository;
import com.example.demo.dao.CustomerRepository;
import com.example.demo.entities.Cart;
import com.example.demo.entities.CartItem;
import com.example.demo.entities.Customer;
import com.example.demo.entities.StatusType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Service
public class CheckoutServiceImpl implements CheckoutService {

   //private CustomerRepository customerRepository;
   private CartRepository cartRepository;
   //private CartItemRepository cartItemRepository;

//   public CheckoutServiceImpl(CustomerRepository customerRepository, CartRepository cartRepository, CartItemRepository cartItemRepository) {
   public CheckoutServiceImpl(CartRepository cartRepository) {
    //this.customerRepository = customerRepository;
    this.cartRepository = cartRepository;
   // this.cartItemRepository = cartItemRepository;

    }
   @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

       //Retrieve cart
       Cart cart = purchase.getCart();


       //tracking number
       String orderTrackingNumber = generateOrderTrackingNumber();
       cart.setOrderTrackingNumber(orderTrackingNumber);

       //populate cart with cartItems
       Set<CartItem> cartItems = purchase.getCartItems();
       //cartItems.forEach(item -> item.setCart(cart));
       cartItems.forEach(item -> cart.add(item));

       //save cart to DB
       cart.setStatus(StatusType.ordered);
       cartRepository.save(cart);

       //empty carts or null
      // Customer customer = purchase.getCustomer();
      // customer.add(cart);

       //response
       return new PurchaseResponse(orderTrackingNumber);
   }
    private String generateOrderTrackingNumber() {

       //Generate random UUID
        return UUID.randomUUID().toString();
    }
}




