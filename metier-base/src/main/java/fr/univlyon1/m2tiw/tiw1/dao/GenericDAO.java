
package fr.univlyon1.m2tiw.tiw1.dao;
 
public interface GenericDAO<K,E> {
    // find Entity E by id(k)
    public E findById(K id);
 
    public void persist(E entity);
    
    public boolean update(E entity);
 
    public boolean delete(E entity) ; 
}
