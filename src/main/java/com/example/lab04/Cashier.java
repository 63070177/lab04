package com.example.lab04;

import com.vaadin.flow.router.Route;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Cashier {
    @RequestMapping(value="getChange/{money}", method = RequestMethod.GET)
    public Change getChange(@PathVariable("money") int money){
        Change total = new Change();
        int ton;
        if (money >= 1000){
            ton = money / 1000;
            total.setB1000(ton);
            money = money - (ton*1000);
        } if (money < 1000){
            ton = money / 500;
            total.setB500(ton);
            money = money - (ton*500);
        } if (money < 500){
            ton = money / 100;
            total.setB100(ton);
            money = money - (ton*100);
        } if (money < 100){
            ton = money / 20;
            total.setB20(ton);
            money = money - (ton*20);
        } if (money < 20){
            ton = money / 10;
            total.setB10(ton);
            money = money - (ton*10);
        } if (money < 10){
            ton = money / 5;
            total.setB5(ton);
            money = money - (ton*5);
        } if (money < 5){
            total.setB1(money);
        }

        return total;

    }
}
