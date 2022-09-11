/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Lenovo
 */
public class Menu {
    private int id;
    private String name;
    private String link;
    private String title;
    private int pid;

    public Menu() {
    }

    public Menu(int id, String name, String link, String title, int pid) {
        this.id = id;
        this.name = name;
        this.link = link;
        this.title = title;
        this.pid = pid;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLink() {
        return link;
    }

    public String getTitle() {
        return title;
    }

    public int getPid() {
        return pid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }
    
    
}
