/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.home.cdi;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author katy
 */
@Named(value = "horizontMenu")
@SessionScoped
public class HorizontMenu implements Serializable {

    public HorizontMenu() {
    }

    public String loadInfo() {
        System.out.println("load info");
        return "loadInfo";
    }
}
