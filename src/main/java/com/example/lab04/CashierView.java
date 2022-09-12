package com.example.lab04;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.web.reactive.function.client.WebClient;

@Route(value = "index2")
public class CashierView extends VerticalLayout{
    private TextField ton, t1000, t500, t100, t20, t10, t5, t1;
    private Button calTon;

    public CashierView (){
        ton = new TextField("เงินทอน");
        ton.setPlaceholder("$");
        calTon = new Button("คำนวณเงินทอน");
        t1000 = new TextField();
        t1000.setPlaceholder("$1000: ");
        t500 = new TextField();
        t500.setPlaceholder("$500: ");
        t100 = new TextField();
        t100.setPlaceholder("$100: ");
        t20 = new TextField();
        t20.setPlaceholder("$20: ");
        t10 = new TextField();
        t10.setPlaceholder("$10: ");
        t5 = new TextField();
        t5.setPlaceholder("$5: ");
        t1 = new TextField();
        t1.setPlaceholder("$1: ");

        this.add(ton, calTon, t1000, t500, t100, t20, t10, t5 ,t1);

        calTon.addClickListener(event ->{
           int money = Integer.parseInt(ton.getValue());
           Change out = WebClient.create().get().uri("http://localhost:8080/getChange/"+money).retrieve().bodyToMono(Change.class).block();
           t1000.setPlaceholder("$1000:" + out.getB1000());
           t500.setPlaceholder("$500:" + out.getB500());
           t100.setPlaceholder("$100:" + out.getB100());
           t20.setPlaceholder("$20:" + out.getB20());
           t10.setPlaceholder("$10:" + out.getB10());
           t5.setPlaceholder("$5:" + out.getB5());
           t1.setPlaceholder("$1:" + out.getB1());
        });

    }
}
