package application;

public class HashTable<T>{
	Object[] hashArray = new Object[10];
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
					//rehash//
				}
			}
		}
		add.setHashNum(hashNum);
	}

}
