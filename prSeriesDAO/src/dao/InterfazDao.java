package dao;

import java.util.ArrayList;

public interface Dao<T> {
        
    public ArrayList<T> getAll();
    
    public T getById(int id);
    
    public void insert(T t);
    
    public void modify(T t);
    
    public void delete(T t);
}