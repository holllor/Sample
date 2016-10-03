/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.home.sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author олег
 */
public class LeftMenuModel {

    public static void main(String[] args) {
        LeftMenuModel l = new LeftMenuModel();
        l.testMenu();
    }

    private void testMenu() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {

        }
        String sql = "select * from leftmenu";
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:5432/sample", "sample",
                    "sample");
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ResultSetMetaData rsmt = rs.getMetaData();

            while (rs.next()) {
                int i1 = rs.getInt("id");
                System.out.println(i1);
            }
        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;

        }

    }
}
