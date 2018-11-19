package application;

public class HashTable<T>{
	Object[] HashArray = new Object[10];
	T hold;

	public HashTable() {
	}
	
	public void add(T add) {
		
		int HashNum = (add.toString().length())%(HashArray.length);
		boolean placeFound = false;
		int Trycount = 0;
		
		while (placeFound == false) {
			if (HashArray[HashNum] == null) {
				HashArray[HashNum] = add;
				placeFound = true;
			}
			else {
				HashNum++;
				if(HashNum == HashArray.length) {
					HashNum = 0;
				}
				Trycount++;
				if(Trycount >= (HashArray.length/2)) {
					hold = add;
					//rehash//
				}
			}
		}
		
	}

}
