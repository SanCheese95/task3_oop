package model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int birthYear;
    private Person mother;
    private Person father;
    private List<Person> children;
    public Person(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
        this.children = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public int getBirthYear() {
        return birthYear;
    }
    public void setMother(Person mother) {
        this.mother = mother;
    }
    public void setFather(Person father) {
        this.father = father;
    }
    public void addChild(Person child) {
        this.children.add(child);
    }
    public List<Person> getChildren() {
        return children;
    }
    public Person getMother() {
        return mother;
    }
    public Person getFather() {
        return father;
    }
}