package step2.treemap;

public class Person{
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
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Person other = (Person) obj;
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
		if(obj instanceof Person) {
			Person person = (Person) obj;
			return (this.id ==person.id);
		}
		return true;
	}
}
