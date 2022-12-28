package org.example;

public class FactoryDemo {
    public static void main(String[] args) {
        Website ecommerce = WebsiteFactory.getWebsite(WebsiteType.ECOMMERCE);
        System.out.println(ecommerce.getPages());

        Website blog = WebsiteFactory.getWebsite(WebsiteType.BLOG);
        System.out.println(blog.getPages());
    }
}