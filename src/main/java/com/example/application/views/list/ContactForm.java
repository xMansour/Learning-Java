package com.example.application.views.list;

import com.example.application.data.entity.Company;
import com.example.application.data.entity.Status;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;

import java.util.List;

public class ContactForm extends FormLayout {
    private TextField firstName = new TextField("First Name");
    private TextField lastname = new TextField("Last Name");
    private EmailField email = new EmailField("Email");
    private ComboBox<Status> status = new ComboBox<>("Status");
    private ComboBox<Company> company = new ComboBox<>("Company");

    private Button saveBtn = new Button("Save");
    private Button deleteBtn = new Button("Delete");
    private Button cancelBtn = new Button("Cancel");



    public ContactForm(List<Company> companies, List<Status> statuses){
        addClassName("contact-form");

        company.setItems(companies);
        company.setItemLabelGenerator(Company::getName);

        status.setItems(statuses);
        status.setItemLabelGenerator(Status::getName);

        add(firstName, lastname, email, company, status, createButtonsLayout());

    }

    private Component createButtonsLayout() {
        saveBtn.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        deleteBtn.addThemeVariants(ButtonVariant.LUMO_ERROR);
        cancelBtn.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        saveBtn.addClickShortcut(Key.ENTER);
        cancelBtn.addClickShortcut(Key.ESCAPE);

        return new HorizontalLayout(saveBtn, deleteBtn, cancelBtn);

    }
}
