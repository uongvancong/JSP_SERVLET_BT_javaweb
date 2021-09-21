package model;

public class Student {
	private Long id;
	private String name;
	private String age;
	private String address;

	public Student(Long id, String name, String age, String address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public Student(String name, String age, String address) {
		super();

		this.name = name;
		this.age = age;
		this.address = address;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Student() {

	}

	 

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	 

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String toString() {
		return this.id + " " + this.name + " " + this.age + " " + this.address + " \n";
	}
}
