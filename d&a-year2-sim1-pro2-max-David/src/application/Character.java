package application;

public class Character {
private int hashNum;
private String name,gender,description;

	public Character(String name, String gender, String description) {
		this.setDescription(description);
		this.setGender(gender);
		this.setName(name);
	}
	
	public String getName() {
		return name;
	}
	public String getGender() {
		return gender;
	}
	public String getDescription() {
		return description;
	}
	public int getHashNum() {
		return hashNum;
	}

	
	public void setDescription(String description) {
		this.description = description;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setGender(String gender) {
		String workingName = gender.toLowerCase();
		if(workingName.equals("f")||workingName.equals("female")){
			this.gender = gender;
		}
		else if(workingName.equals("m")||workingName.equals("male")) {
			this.gender = gender;
		}
		else {
			this.gender = "N/A";
		}
	}
	public void setHashNum(int hashNum) {
		this.hashNum = hashNum;
	}

	
}
