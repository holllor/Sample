/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.home.cdi;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.ViewExpiredException;

import javax.inject.Named;
import ru.home.ejb.TovarEJBean;
import ru.home.entity.Tovar;
import ru.home.sample.LeftMenuModel;

/**
 *
 * @author олег
 */
@Named(value = "tovarCDI")
@SessionScoped
public class TovarCDI implements Serializable{

    private List<Tovar> listTovar;
    private Tovar selectedTovar;
    
    public TovarCDI() {
    }
    
    @EJB
    TovarEJBean TovarEjb;

    //метод отрабатывает при загрузке CDI Bean
    @PostConstruct
    public void init() {
      listTovar = new ArrayList<>(); // начальная инициализация пока еще нет выбранных значений
       listTovar = TovarEjb.selectTovarForGroup(12);// загрузка по умолчанию на чальной странице
    }
    public void selectTovar(){
        String id ="13";
       int id2 = Integer.parseInt(id);
       listTovar = TovarEjb.selectTovarForGroup(id2);
        System.out.println("select 1 ");
    }
    
    
     public void selectTovar2(String id){
       
       int id2 = Integer.parseInt(id);
        listTovar = TovarEjb.selectTovarForGroup(id2);
    }
public String opisanie() throws ViewExpiredException{
    System.out.println("select "+selectedTovar);
    return "opisanie";
}
     
    public List<Tovar> getListTovar() {
        return listTovar;
    }

    public void setListTovar(List<Tovar> listTovar) {
        this.listTovar = listTovar;
    }

    public Tovar getSelectedTovar() {
        return selectedTovar;
    }

    public void setSelectedTovar(Tovar selectedTovar) {
        System.out.println(selectedTovar.getNametovar());
        this.selectedTovar = selectedTovar;
    }

    
    
}
