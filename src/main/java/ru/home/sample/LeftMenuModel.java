/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.home.sample;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.DynamicMenuModel;
import org.primefaces.model.menu.MenuModel;
import ru.home.ejb.LeftMenuEJB;
import ru.home.entity.LeftmenuEasy;

/**
 *
 * @author олег
 */
public class LeftMenuModel implements Serializable {

//    public static void main(String[] args) {
//        LeftMenuModel l = new LeftMenuModel();
//        l.testMenu();
//    }
    public DynamicMenuModel getModelEasy3() {
        DynamicMenuModel model = new DynamicMenuModel();
        model.generateUniqueIds();
        //DynamicSubMenu subMenu = new d
        return null;
    }

    public DefaultMenuModel getModelEasy2() {
        DefaultMenuModel model = new DefaultMenuModel();//инициализация модели меню
        DefaultMenuItem item = new DefaultMenuItem("one");

        //item.setId("0");
        item.setCommand("#{tovarCDI.selectTovar}");
        item.setUpdate("tovar1");

        DefaultMenuItem item2 = new DefaultMenuItem("two");
        //item2.setId("1");
        item2.setCommand("#{tovarCDI.selectTovar2('12')}");
        item2.setUpdate("tovar1");

        DefaultMenuItem item3 = new DefaultMenuItem("three");
        // item3.setId("2");
        item3.setCommand("#{tovarCDI.selectTovar2('15')}");
        item3.setUpdate("tovar1");

        model.addElement(item);
        model.addElement(item2);
        model.addElement(item3);
        model.generateUniqueIds();
        return model;
    }

    public DefaultMenuModel getModelEasy(LeftMenuEJB ejb) {
        DefaultMenuModel model = new DefaultMenuModel();//инициализация модели меню
        // int idMenu = 0;
        List<LeftmenuEasy> listKor = ejb.selectKorenElement();

        for (LeftmenuEasy leftmenuKoren : listKor) { //All element

            if (leftmenuKoren.getIsGruop()) { // проверка на группу 
                //    System.out.println("grup " + idMenu);
                List<LeftmenuEasy> listGrup = ejb.selectGroup(leftmenuKoren.getId());//заполнение групп
                for (LeftmenuEasy leftmenuGrup : listGrup) {// заполнение групповых листов  SubMenu
                    DefaultSubMenu GrupSubmenu = new DefaultSubMenu(leftmenuGrup.getNameMenu());

                    List<LeftmenuEasy> listList = ejb.selectList(leftmenuGrup.getId());
                    for (LeftmenuEasy leftmenuEasyRow : listList) {// item
                        // System.out.println("grup " + leftmenuEasyRow.getNameMenu() + " " + idMenu + " " + leftmenuEasyRow.getId().toString() + " ");
                        DefaultMenuItem item = new DefaultMenuItem(leftmenuEasyRow.getNameMenu());
                        //item.setId(String.valueOf(leftmenuEasyRow.getId()));
                        // System.out.println("gr "+String.valueOf(leftmenuEasyRow.getId()));
                        //    item.setId(leftmenuEasyRow.);
                        item.setCommand("#{tovarCDI.selectTovar2('" + leftmenuEasyRow.getId().toString() + "')}");
                        item.setUpdate("tovar1");
                        item.setAjax(true);
                        //  item.setIcon("ui-icon-home");
                        GrupSubmenu.addElement(item);
                        // idMenu += 1;
                    }
//                    if (listList.size() > 1) {
//                        idMenu += 1;
//                    }
                    model.addElement(GrupSubmenu);
                }

            } else {// заполнение корневых листов
                // System.out.println("koren list "+idMenu); 
//   List<LeftmenuEasy> listGrup = ejb.selectList(0); //
                //  System.out.println("list " + leftmenuKoren.getNameMenu() + " " + idMenu + " " + leftmenuKoren.getId().toString() + " ");
                DefaultMenuItem item = new DefaultMenuItem(leftmenuKoren.getNameMenu());
                //item.setId(String.valueOf(leftmenuEasyRow.getId()));
//                System.out.println("kor list "+String.valueOf(leftmenuKoren.getId()));
//                item.setId(String.valueOf(leftmenuKoren.getId()));
                item.setCommand("#{tovarCDI.selectTovar2('" + leftmenuKoren.getId().toString() + "')}");
                item.setUpdate("tovar1");
                item.setAjax(true);
                // idMenu += 1;
                //item.setIcon("ui-icon-home");

                model.addElement(item);
                //     leftmenuKoren   // item koren

            }
        }

// после всех добавлений ОБЯЗАТЕЛЬНЫЙ вызов этого метода!!!
        model.generateUniqueIds();// после добавление всех пунктов и групп, генерирует уникальные номера. Это решает проблему их самостоятельной генерации!!
        return model;
    }

    private List<LeftmenuEasy> recurse(List<LeftmenuEasy> rec) {

        return null;
    }

    public DefaultMenuModel getModelEasy3(LeftMenuEJB ejb) {
        DefaultMenuModel model = new DefaultMenuModel();//инициализация модели меню

        List<LeftmenuEasy> listKor = ejb.selectKorenElement();

        for (LeftmenuEasy leftmenuKoren : listKor) { //All element

            if (leftmenuKoren.getIsGruop()) { // проверка на группу 
                //    System.out.println("grup " + idMenu);
//                List<LeftmenuEasy> listGrup = ejb.selectGroup(leftmenuKoren.getId());//заполнение групп
//                for (LeftmenuEasy leftmenuGrup : listGrup) {// заполнение групповых листов  SubMenu
                DefaultSubMenu GrupSubmenu = new DefaultSubMenu(leftmenuKoren.getNameMenu());
                //if(){}
                List<LeftmenuEasy> listList = ejb.selectList(leftmenuKoren.getId());
                for (LeftmenuEasy leftmenuEasyRow : listList) {// item
                    // System.out.println("grup " + leftmenuEasyRow.getNameMenu() + " " + idMenu + " " + leftmenuEasyRow.getId().toString() + " ");
                    DefaultMenuItem item = new DefaultMenuItem(leftmenuEasyRow.getNameMenu());

                    item.setCommand("#{tovarCDI.selectTovar2('" + leftmenuEasyRow.getId().toString() + "')}");
                    item.setUpdate("tovar1");
                    item.setAjax(true);

                    GrupSubmenu.addElement(item);

                }
                model.addElement(GrupSubmenu);
//                }

            } else {// заполнение корневых листов

                DefaultMenuItem item = new DefaultMenuItem(leftmenuKoren.getNameMenu());

                item.setCommand("#{tovarCDI.selectTovar2('" + leftmenuKoren.getId().toString() + "')}");
                item.setUpdate("tovar1");
                item.setAjax(true);

                model.addElement(item);

            }
        }
// после всех добавлений ОБЯЗАТЕЛЬНЫЙ вызов этого метода!!!
        model.generateUniqueIds();// после добавление всех пунктов и групп, генерирует уникальные номера. Это решает проблему их самостоятельной генерации!!
        return model;
    }

    private void testMenu() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {

        }
        String sql = "select * from \"leftmenuEasy\" where parent_id = 0";
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
