package dao;

import java.util.ArrayList;

public interface InterfazDao<T> {
      
	/**
	 * Devuelve todos los objetos T de la base de datos
	 * 
	 * @return
	 */
    public ArrayList<T> getAll();
    
    /**
     * Busca un objeto T de la base de datos a partir de su id
     * 
     * @param id
     * @return
     */
    public T getById(int id);
    
    /**
     * Inserta un objeto T en la base de datos
     * 
     * @param t
     */
    public void insert(T t);
    
    /**
     * Modifica un objeto T de la base de datos
     * 
     * @param t
     */
    public void modify(T t);
    
    /**
     * Elimina un objeto T de la base de datos
     * 
     * @param t
     */
    public void delete(T t);
}