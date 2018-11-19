package application;

public class Character {
private int HashNum;
private String Name,Gender,Description;

	public Character(String name, String gender, String description) {
		this.setDescription(description);
		this.setGender(gender);
		this.setName(name);
	}
	
	public String getName() {
		return Name;
	}
	public String getGender() {
		return Gender;
	}
	public String getDescription() {
		return Description;
	}
	public int getHashNum() {
		return HashNum;
	}

	
	public void setDescription(String description) {
		Description = description;
	}
	public void setName(String name) {
		Name = name;
	}
	public void setGender(String gender) {
		String workingName = gender.toLowerCase();
		if(workingName.equals("f")||workingName.equals("female")){
			this.Gender = gender;
		}
		else if(workingName.equals("m")||workingName.equals("male")) {
			this.Gender = gender;
		}
		else {
			this.Gender = "N/A";
		}
	}
	public void setHashNum(int hashNum) {
		HashNum = hashNum;
	}

	
}
