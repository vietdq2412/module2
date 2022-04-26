package model;

import java.io.Serializable;

public class AppUser implements Serializable {
    private  int id;
    private String name;
    private String username;
    private String password;

    public AppUser() {
    }
    public AppUser(int id, String username, String password, String name) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public AppUser(String username, String password, String name) {
        this.name = name;
        this.username = username;
        this.password = password;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        String str = String.format("|Name: %-10s|Username: %-10s|Password: %s", name,username,password);
        return str;
    }
}
