package step2.treemap;

public class PersonTreeMapTest {
    public static void main(String[] args) {
        PersonTreeMap manager = new PersonTreeMap();
        Person personLee = new Person(1,"Lee", 3);
        Person personKim = new Person(2, "Kim", 7);
        Person personPark = new Person(3, "Park", 8);
        Person personLim = new Person(4, "Lim", 2);

        manager.addPerson(personLee);
        manager.addPerson(personKim);
        manager.addPerson(personPark);
        manager.addPerson(personLim);

        manager.showAllPerson();

        manager.removePerson(2);
    }
}
