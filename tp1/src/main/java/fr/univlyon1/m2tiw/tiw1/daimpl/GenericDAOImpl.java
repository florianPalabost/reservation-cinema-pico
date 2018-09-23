/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univlyon1.m2tiw.tiw1.daimpl;

import fr.univlyon1.m2tiw.tiw1.dao.GenericDAO;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.usertype.ParameterizedType;

/**
 *
 * @author florian
 */
public abstract class GenericDAOImpl<K,E> implements GenericDAO<K,E>  {
    protected Class<E> entityClass;
    @PersistenceContext
    protected EntityManager em;

    public GenericDAOImpl() {
        ParameterizedType genericSuperClass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<E>) genericSuperClass.getClass();
       
    }
    
    @Override
    public E findById(K id){
         return em.find(entityClass, id);
    }
 
    @Override
    public void persist(E entity){
       em.persist(entity); 
    }
    
    @Override
    public boolean update(E entity){
        return false;
    }
 
    @Override
    public boolean delete(E entity){
        em.remove(entity);
        //return !(em.find(entity)==null);
        return false;
    }

}
