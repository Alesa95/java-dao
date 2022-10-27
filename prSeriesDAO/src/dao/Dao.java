package dao;

import java.util.ArrayList;
import java.util.Optional;

public interface Dao<T> {
        
    public ArrayList<T> getAll();
    
    public T getById(int id);
    
    void insertar(T t);
    
    public void modificar(T t);
    
    public void borrar(T t);
}