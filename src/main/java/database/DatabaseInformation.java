package database;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DatabaseInformation {
    private String user;
    private String password;
    private String url;
    private String forNameData;

    public DatabaseInformation() {
        this.user = "root";
        this.password = "root";
        this.url = "jdbc:mysql://localhost:3306/blog";
        this.forNameData = "com.mysql.cj.jdbc.Driver";
    }

    public DatabaseInformation(String user, String password, String url, String forNameData) {
        this.user = user;
        this.password = password;
        this.url = url;
        this.forNameData = forNameData;
    }
}
