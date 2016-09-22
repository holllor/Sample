/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.home.cdi;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import ru.home.ejb.LeftMenuEJB;

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
        model = new DefaultMenuModel();
// Прописать вызов и заполнение модели данными из БД с помощью методов EJB класса
        //First submenu
        DefaultSubMenu firstSubmenu = new DefaultSubMenu("Dynamic Submenu");

        DefaultMenuItem item = new DefaultMenuItem("External");
        item.setUrl("http://www.primefaces.org");
        item.setIcon("ui-icon-home");
        firstSubmenu.addElement(item);

        model.addElement(firstSubmenu);

        //Second submenu
        DefaultSubMenu secondSubmenu = new DefaultSubMenu("Dynamic Actions");

        item = new DefaultMenuItem("Save");
        item.setIcon("ui-icon-disk");
        item.setCommand("#{menuView.save}");
        item.setUpdate("messages");
        secondSubmenu.addElement(item);

        item = new DefaultMenuItem("Delete");
        item.setIcon("ui-icon-close");
        item.setCommand("#{menuView.delete}");
        item.setAjax(false);
        secondSubmenu.addElement(item);

        item = new DefaultMenuItem("Redirect");
        item.setIcon("ui-icon-search");
        item.setCommand("#{menuView.redirect}");
        secondSubmenu.addElement(item);

        model.addElement(secondSubmenu);
    }

    public MenuModel getModel() {
        return model;
    }

}
