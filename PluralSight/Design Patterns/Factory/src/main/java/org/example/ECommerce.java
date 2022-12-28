package org.example;

import org.example.pages.CartPage;
import org.example.pages.HomePage;
import org.example.pages.OrdersPage;

public class ECommerce extends Website{
    @Override
    public void createWebsite() {
        pages.add(new HomePage());
        pages.add(new CartPage());
        pages.add(new OrdersPage());
    }
}
