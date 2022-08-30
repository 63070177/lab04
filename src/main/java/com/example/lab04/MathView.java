package com.example.lab04;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route(value = "index1")
public class MathView extends VerticalLayout {

    public MathView() {
        TextField num1 = new TextField();
        num1.setLabel("Number 1");
        num1.setWidth("500px");

        TextField num2 = new TextField();
        num2.setLabel("Number 2");
        num2.setWidth("500px");

        Button plus = new Button("+");
        Button minus = new Button("-");
        Button multi = new Button("x");
        Button divide = new Button("/");
        Button mod = new Button("mod");
        Button max = new Button("max");
        Label lb = new Label("Operator");
        HorizontalLayout h1 = new HorizontalLayout();

        TextField ans = new TextField();
        ans.setLabel("Answer");
        ans.setWidth("500px");

        h1.add(plus, minus, multi, divide, mod, max);
        add(num1, num2, lb, h1, ans);
    }
}
