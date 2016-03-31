/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.home.test;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author олег
 */
@Named(value = "testJSFManagedBean")
@SessionScoped
public class TestJSFManagedBean implements Serializable {

    /**
     * Creates a new instance of TestJSFManagedBean
     */
    public TestJSFManagedBean() {
    }
    
}
