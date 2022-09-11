/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Lenovo
 */
public class Student {

    private String id;
    private String name;
    private String departId;
    private boolean gender;
    private float GPA;
    private String add;

    public Student() {
    }

    public Student(String id, String name, String departId, boolean gender, float GPA, String add) {
        this.id = id;
        this.name = name;
        this.departId = departId;
        this.gender = gender;
        this.GPA = GPA;
        this.add = add;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartId() {
        return departId;
    }

    public boolean isGender() {
        return gender;
    }

    public float getGPA() {
        return GPA;
    }

    public String getAdd() {
        return add;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartId(String departId) {
        this.departId = departId;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void setGPA(float GPA) {
        this.GPA = GPA;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String toRow(String departName) {
        String s = "<tr>";
        s += "<td>" + id + "</td>";
        s += "<td>" + name + "</td>";
        s += "<td>" + departName + "</td>";
        s += "<td>" + (gender ? "Male" : "Female") + "</td>";
        s += "<td>" + GPA + "</td>";
        s += "<td>" + add + "</td>";
        s += "<td> <a href = 'Update?type=0&id="+ id +"'> Delete </a></td>";
        s += "<td> <a href = 'Update?type=1&id="+ id +"'> Update </a></td>";

        s += "</tr>";
        return s;

    }
}
