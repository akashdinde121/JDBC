package JDBCConnect;

public class team {

	
	private int idteam;
	private String name;
	private int age;
	
	public team(int idteam, String name, int age) {
		super();
		this.idteam = idteam;
		this.name = name;
		this.age = age;
	}

	public int getIdteam() {
		return idteam;
	}

	public void setIdteam(int idteam) {
		this.idteam = idteam;
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

	@Override
	public String toString() {
		return "team [idteam=" + idteam + ", name=" + name + ", age=" + age + "]";
	}
	
	
	
}
