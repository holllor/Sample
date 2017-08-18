/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.home.cdi;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import ru.home.ejb.LoadInfoEJB;
import ru.home.entity.Tovar;

/**
 *
 * @author katy
 */
@Named(value = "loadInfoCDI")
@SessionScoped
public class LoadInfoCDI implements Serializable {

    private List<Tovar> listTovar;
    @EJB
    LoadInfoEJB loadEjb;
    //метод отрабатывает при загрузке CDI Bean

    @PostConstruct
    public void init() {
        listTovar = loadEjb.selectAllTovar(); // загружает модель данных меню

    }

    // getter and setter
    public List<Tovar> getListTovar() {
        return listTovar;
    }

    public void setListTovar(List<Tovar> listTovar) {
        this.listTovar = listTovar;
    }

}
