/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.home.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import ru.home.entity.LeftmenuEasy;
import ru.home.entity.Tovar;

/**
 *
 * @author олег
 */
@Stateless
public class TovarEJBean {

    @PersistenceContext(unitName = "samplePG")
    private EntityManager em;

   /**
    * выбирает товар привязанный к пункту или группе меню
    * @param id
    * @return  список товаров
    */
    public List<Tovar> selectTovarForGroup(int id) {

        String sql = "select * from tovar where leftmenueasy_id = ? ";
        
        Query qer = em.createNativeQuery(sql, Tovar.class).setParameter(1, id);
        System.out.println(sql);
        return qer.getResultList();
    }
}
