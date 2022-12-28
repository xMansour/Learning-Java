package org.example;

public class WebsiteFactory {
    public static Website getWebsite(WebsiteType type) {
        return switch (type) {
            case ECOMMERCE -> new ECommerce();
            case BLOG -> new Blog();
        };
    }
}
