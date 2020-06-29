package step2.hashmap;

public class PersonHashMapTest {
    public static void main(String[] args) {
        PersonHashMap manager = new PersonHashMap();
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
