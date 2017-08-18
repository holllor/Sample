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
import ru.home.entity.Tovar;

/**
 *
 * @author katy
 */
@Stateless
public class LoadInfoEJB {

    @PersistenceContext(unitName = "samplePG")
    private EntityManager em;

    /**
     * выбор всего товара из базы
     *
     * @return лист
     */
    public List<Tovar> selectAllTovar() {
        String sql = "select * from tovar t ";
        Query qer = em.createNativeQuery(sql, Tovar.class);
        return qer.getResultList();
    }
}
