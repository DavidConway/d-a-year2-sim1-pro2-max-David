package application;

public class Character implements Hashable{
private String name,gender,description;
private int sort,hashNum;

private LinkedList<Integer> book = new LinkedList<Integer>();
//constructor
	public Character() {};
	public Character(String name, String gender, String description, int sort) {
		this.setDescription(description);
		this.setGender(gender);
		this.setName(name);
		this.setSort(sort);
	}
//
	
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
			this.gender = "Other";
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

	// adds the hash of the book to list
		public void addToBook(Book toAdd) {
			book.add(toAdd.getHashNum());
		}
	//
	
	@Override
	public void setHashNum(int hash) {
		this.hashNum = hash;
		
	}

	@Override
	public int getHashNum() {
		return this.hashNum;
	}
	
	@Override
	public LinkedList<Integer> getList() {
		return book;
	}
	public int getBook(int i) {
		return book.get(i).getContents();
	}
}
