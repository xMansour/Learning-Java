package org.example;

public class FactoryDemo {
    public static void main(String[] args) {
        Website ecommerce = WebsiteFactory.getWebsite("ecommerce");
        System.out.println(ecommerce.getPages());

        Website blog = WebsiteFactory.getWebsite("blog");
        System.out.println(blog.getPages());
    }
}