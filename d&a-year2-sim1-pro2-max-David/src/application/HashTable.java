package application;

public class HashTable{
	Hashable[] hashArray = new Hashable[10];
	Hashable hold;

	public HashTable() {
	}

	public void add(Hashable add) {
		
		int hashNum = (add.toString().length())%(hashArray.length);
		boolean placeFound = false;
		int Trycount = 0;
		
		while (placeFound == false) {
			if (hashArray[hashNum] == null) {
				hashArray[hashNum] = add;
				placeFound = true;
			}
			else {
				hashNum++;
				if(hashNum == hashArray.length) {
					hashNum = 0;
				}
				Trycount++;
				if(Trycount >= (hashArray.length/2)) {
					hold = add;
					this.rehash();
				}
			}
		}
		add.setHashNum(hashNum);
	}
	
	
	private void rehash() {
		Hashable[] newHashArray = new Hashable[(int) (hashArray.length*1.5)];
		
		for(Hashable c: hashArray) {
			int hashNum = (c.toString().length())%(newHashArray.length);
			boolean placeFound = false;
				
			while (placeFound == false) {
				if (hashArray[hashNum] == null) {
					hashArray[hashNum] = c;
					placeFound = true;
				}
				else {
					hashNum++;
					if(hashNum == newHashArray.length) {
						hashNum = 0;
					}
				}
			}
		}
		hashArray = newHashArray;
	}
	

}
