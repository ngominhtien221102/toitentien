/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Lenovo
 */
public class Users {
    private String id;
    private String password;
    private byte role;

    public Users(String id, String password, byte role) {
        this.id = id;
        this.password = password;
        this.role = role;
    }

    public Users() {
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public byte getRole() {
        return role;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(byte role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Users{" + "id=" + id + ", password=" + password + ", role=" + role + '}';
    }
    
    
    
}
