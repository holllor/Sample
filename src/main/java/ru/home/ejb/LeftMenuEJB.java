/*
 EJB класс предназначен для выполнения методов с запросами к БД
и упрощении работы с транзакциями 
Для работы левого меню
 */
package ru.home.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import ru.home.entity.LeftmenuEasy;

/**
 *
 * @author олег
 */
@Stateless
public class LeftMenuEJB {
    
    @PersistenceContext(unitName = "samplePG")
    private EntityManager em;
    
    /**
     * выводит все корневые элементы
     * @return 
     */
    public List<LeftmenuEasy> selectKorenElement(){
        String sql = "select * from leftmenueasy  where parent_id = 0";
        Query qer = em.createNativeQuery(sql, LeftmenuEasy.class);
        return qer.getResultList();
    }
     public List<LeftmenuEasy> selectGroup(int id){
         
        String sql = "select * from leftmenueasy  where id = ? and  \"isGroup\" = true  ";
        Query qer = em.createNativeQuery(sql, LeftmenuEasy.class).setParameter(1, id);
        return qer.getResultList();
    }
      public List<LeftmenuEasy> selectList(int id){
         
        String sql = "select * from leftmenueasy  where parent_id = ? and  \"isGroup\" = false  ";
        Query qer = em.createNativeQuery(sql, LeftmenuEasy.class).setParameter(1, id);
        return qer.getResultList();
    }
}
