package application;

public class Character implements Hashable{
private String name,gender,description;
private int sort;

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

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public String toString()
	{
		return name;
	}

	
	@Override
	public void setHashNum(int hash) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getHashNum() {
		// TODO Auto-generated method stub
		return 0;
	}
}
