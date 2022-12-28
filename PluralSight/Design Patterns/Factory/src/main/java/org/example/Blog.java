package org.example;

import org.example.pages.AboutPage;
import org.example.pages.ContactPage;
import org.example.pages.DailyBlogPage;
import org.example.pages.HomePage;

public class Blog extends Website {
    @Override
    public void createWebsite() {
        pages.add(new HomePage());
        pages.add(new AboutPage());
        pages.add(new ContactPage());
        pages.add(new DailyBlogPage());
    }
}
