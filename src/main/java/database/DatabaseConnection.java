package database;

import lombok.Getter;
import lombok.Setter;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

@Getter @Setter
public class DatabaseConnection extends DatabaseInformation{
    // Üst classtan gelen verileri alma
    // Connection için gerekli veriler
    private Connection connection;
    private String user=super.getUser();
    private String password=super.getPassword();
    private String url=super.getUrl();
    private String forNameData=super.getForNameData();
    private static DatabaseConnection instance;

    public static DatabaseConnection getInstance() {
        try {
            // eğer instance null ise veya kapatılmışsa yen bağlantı oluştur
            if (instance==null || instance.connection.isClosed()){
                instance=new DatabaseConnection();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return instance;
    }

    // Design Pattern (Singgleton Design Pattern)
    private DatabaseConnection() throws ClassNotFoundException, SQLException {
    try {
        Class.forName(this.forNameData);
        System.out.println("basarili bir sekilde yuklendi");
        connection = DriverManager.getConnection(url,user,password);
    }catch (Exception e){
        e.printStackTrace();
    }

    }

}
