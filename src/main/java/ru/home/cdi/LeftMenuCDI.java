/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.home.cdi;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import ru.home.ejb.LeftMenuEJB;
import ru.home.sample.LeftMenuModel;

/**
 *
 * @author олег
 */
@Named(value = "leftMenuCDI")
@SessionScoped
public class LeftMenuCDI implements Serializable {

    private MenuModel model;

    @EJB
    LeftMenuEJB leftEjb;

    //метод отрабатывает при загрузке CDI Bean
    @PostConstruct
    public void init() {
        model = new LeftMenuModel().getModelEasy3(leftEjb);// загружает модель данных меню

    }

    public MenuModel getModel() {
        try {
            model = new LeftMenuModel().getModelEasy3(leftEjb);
        } catch (Exception e) {
            System.out.println("ERROR ");
            e.printStackTrace();
        }
        //model = new LeftMenuModel().getModelEasy2();
         return model;
    }

}
