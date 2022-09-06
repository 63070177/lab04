package com.example.lab04;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.web.reactive.function.client.WebClient;


@Route(value = "index1")
public class MathView extends VerticalLayout {
    private TextField t1, t2, t3;
    private Button btn1, btn2, btn3, btn4, btn5, btn6;
    public MathView() {
        t1 = new TextField("Number1");
        t2 = new TextField("Number2");
        t3 = new TextField("Answer");

        btn1 = new Button("+");
        btn2 = new Button("-");
        btn3 = new Button("*");
        btn4 = new Button("/");
        btn5 = new Button("Mod");
        btn6 = new Button("Max");

        HorizontalLayout hl = new HorizontalLayout();
        VerticalLayout vl = new VerticalLayout();

        hl.add(btn1, btn2, btn3, btn4, btn5, btn6);
        vl.add(t1, t2);
        this.add(vl, hl, t3);

        btn1.addClickListener(event ->{
            double num1 = Double.parseDouble(t1.getValue());
            double num2 = Double.parseDouble(t2.getValue());

            String out = WebClient.create().get().uri("http://localhost:8080/plus/"+num1+"/"+num2).retrieve().bodyToMono(String.class).block();
            t3.setValue(out);
        });

        btn2.addClickListener(event ->{
            double num1 = Double.parseDouble(t1.getValue());
            double num2 = Double.parseDouble(t2.getValue());

            String out = WebClient.create().get().uri("http://localhost:8080/minus/"+num1+"/"+num2).retrieve().bodyToMono(String.class).block();
            t3.setValue(out);
        });

        btn4.addClickListener(event ->{
            double num1 = Double.parseDouble(t1.getValue());
            double num2 = Double.parseDouble(t2.getValue());

            String out = WebClient.create().get().uri("http://localhost:8080/divide/"+num1+"/"+num2).retrieve().bodyToMono(String.class).block();
            t3.setValue(out);
        });

        btn3.addClickListener(event ->{
            double num1 = Double.parseDouble(t1.getValue());
            double num2 = Double.parseDouble(t2.getValue());

            String out = WebClient.create().get().uri("http://localhost:8080/multi/"+num1+"/"+num2).retrieve().bodyToMono(String.class).block();
            t3.setValue(out);
        });

        btn5.addClickListener(event ->{
            double num1 = Double.parseDouble(t1.getValue());
            double num2 = Double.parseDouble(t2.getValue());

            String out = WebClient.create().get().uri("http://localhost:8080/mod/"+num1+"/"+num2).retrieve().bodyToMono(String.class).block();
            t3.setValue(out);
        });

        btn6.addClickListener(event ->{
            double num1 = Double.parseDouble(t1.getValue());
            double num2 = Double.parseDouble(t2.getValue());

            String out = WebClient.create().post().uri("http://localhost:8080/max/?n1="+num1+"&n2="+num2).retrieve().bodyToMono(String.class).block();
            t3.setValue(out);
        });
    }
}
