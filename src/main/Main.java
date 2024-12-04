package main;
import model.FamilyTree;
import model.Person;
import service.FileOperations;
import service.FileOperationsImpl;
import java.io.IOException;
public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
        Person john = new Person("John", 1950);
        Person mary = new Person("Mary", 1955);
        Person susan = new Person("Susan", 1980);
        susan.setMother(mary);
        susan.setFather(john);
        john.addChild(susan);
        mary.addChild(susan);
        familyTree.addPerson(john);
        familyTree.addPerson(mary);
        familyTree.addPerson(susan);
        System.out.println("Сортировка по имени:");
        familyTree.sortByName();
        for (Person person : familyTree) {
            System.out.println(person.getName() + " - " +
                    person.getBirthYear());
        }
        System.out.println("\nСортировка по дате рождения:");
        familyTree.sortByBirthYear();
        for (Person person : familyTree) {
            System.out.println(person.getName() + " - " +
                    person.getBirthYear());
        }
        FileOperations fileOps = new FileOperationsImpl();
        try {
            fileOps.saveToFile(familyTree, "familyTree.dat");
            System.out.println("\nFamily tree saved to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        FamilyTree loadedFamilyTree = null;
        try {
            loadedFamilyTree =
                    fileOps.loadFromFile("familyTree.dat");
            System.out.println("Family tree loaded from file.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (loadedFamilyTree != null) {
            System.out.println("\nLoaded persons:");
            for (Person person : loadedFamilyTree) {
                System.out.println(person.getName() + ", born in " +
                        person.getBirthYear());
            }
        }
    }
}