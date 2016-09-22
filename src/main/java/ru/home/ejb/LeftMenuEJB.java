/*
 EJB класс предназначен для выполнения методов с запросами к БД
и упрощении работы с транзакциями 
Для работы левого меню
 */
package ru.home.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author олег
 */
@Stateless
public class LeftMenuEJB {
    
    @PersistenceContext(unitName = "samplePG")
    private EntityManager em;
    
    
}
