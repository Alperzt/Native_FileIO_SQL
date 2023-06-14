package dao;

import database.DatabaseConnection;

import java.sql.Connection;
import java.util.ArrayList;

public interface IDaoGenerics <T>{
    public void Create(T t);
    public void Update(T t);
    public void Delete(T t);
    public T FindById(Long id);
    public ArrayList<T> list();
    default Connection getInterfaceConnection(){
        return DatabaseConnection.getInstance().getConnection();
    }
}
