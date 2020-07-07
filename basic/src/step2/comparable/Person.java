package step2.comparable;

public class Person implements Comparable<Person>{
	private int id;
    private String name;
    private int age;
    public Person(){}

    public Person(int age) {
        this.age = age;
    }

    public Person(String name){
        this.name = name;
    }

    public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Person(int id, String name, int age) {
    	  this.id = id;
    	  this.age = age;
    	  this.name = name;
    }
    

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

    @Override
    public String toString() {
        return "\r\nPerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Person) {
			Person person = (Person) obj;
			return (this.id ==person.id);
		}
		return true;
	}

	@Override
	public int compareTo(Person o) {
		if(age < o.age) return -1;
		else if(age == o.age) return 0;
		else return 1;
	}
}
