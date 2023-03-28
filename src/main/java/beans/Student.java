/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

/**
 *
 * @author willi
 */
public class Student {

    private Integer id;
    private String name;
    private String course;
    private String fee;

    public Student(Integer id, String name, String course, String fee) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.fee = fee;
    }

    public Student(String name, String course, String fee) {
        this.name = name;
        this.course = course;
        this.fee = fee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", course=" + course + ", fee=" + fee + '}';
    }
}
