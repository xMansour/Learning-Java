package org.example;

public class WebsiteFactory {
    public static Website getWebsite(String type) {
        return switch (type) {
            case "ecommerce" -> new ECommerce();
            case "blog" -> new Blog();
            default -> null;
        };
    }
}
