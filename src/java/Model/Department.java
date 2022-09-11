/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Lenovo
 */
public class Department {
    private String id;
    private String name;
    private String infor;

    public Department(String id, String name, String infor) {
        this.id = id;
        this.name = name;
        this.infor = infor;
    }

    public Department() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getInfor() {
        return infor;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInfor(String infor) {
        this.infor = infor;
    }
    
    
    
}
