package application;

public class Character {
private String Name,Gender,Description;

	public Character(String name, String gender, String description) {
		this.Name = name;
		this.Gender = gender;
		this.Description = description;
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}

}
