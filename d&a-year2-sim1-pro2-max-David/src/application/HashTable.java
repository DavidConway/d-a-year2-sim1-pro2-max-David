package application;

public class HashTable<T>{
	Object[] hashArray = new Object[10];
	T hold;

	public HashTable() {
	}
	
	public void add(T add) {
		
		int HashNum = (add.toString().length())%(hashArray.length);
		boolean placeFound = false;
		int Trycount = 0;
		
		while (placeFound == false) {
			if (hashArray[HashNum] == null) {
				hashArray[HashNum] = add;
				placeFound = true;
			}
			else {
				HashNum++;
				if(HashNum == hashArray.length) {
					HashNum = 0;
				}
				Trycount++;
				if(Trycount >= (hashArray.length/2)) {
					hold = add;
					//rehash//
				}
			}
		}
		
	}

}
