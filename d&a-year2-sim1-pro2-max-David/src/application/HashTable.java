package application;

public class HashTable{
	Hashable[] hashArray = new Hashable[10];

	public HashTable() {
	}

	public void add(Hashable add) {
		
		int hashNum = (add.toString().length())%(hashArray.length);//generates hash num
		boolean placeFound = false;
		int Trycount = 0;
		
		while (placeFound == false) {
			if (hashArray[hashNum] == null) {//if the place is empty it is placed in the hash table
				hashArray[hashNum] = add;
				placeFound = true;
			}
			else {
				hashNum++;//moves onto the next hash num
				if(hashNum == hashArray.length) {//raps back to the top if it gose past the last space
					hashNum = 0;
				}
				Trycount++;
				if(Trycount >= (hashArray.length/2)) {//if the hash table is over half full
					this.rehash();
				}
			}
		}
		add.setHashNum(hashNum);
	}
	
	
	private void rehash() {
		Hashable[] newHashArray = new Hashable[(int) (hashArray.length*1.5)];//creats new larger hash table
		
		for(Hashable c: hashArray) {//gose trow eatch elament in the ople hash table add add it to the new one whith a new hash
			if(c != null) {
				int hashNum =((c.toString().length())%(newHashArray.length));
				boolean placeFound = false;
				while (placeFound == false) {
 					if (newHashArray[hashNum] == null) {
						newHashArray[hashNum] = c;
						placeFound = true;
					}
					else {
						hashNum++;
						if(hashNum == newHashArray.length) {
							hashNum = 0;
						}
						
					}
				}
				
				LinkedListNode<Integer> temp = c.getList().head;//adjusts the hash list of characters or books that the rehashed list is in
				boolean changed = false;
				while(temp != null && changed == false) {
					if(temp.equals(c.getHashNum())) {
						temp.setContents(hashNum);
						changed = true;
					}
				temp = temp.next;
				}
				c.setHashNum(hashNum);
			}
		}
		hashArray = newHashArray;
	}
	
	public int length() {
		return hashArray.length;
	}
	
	public Hashable getHash(int i)
	{
		return hashArray[i];
	}
	
	public Hashable get(int item) {
		int count = -1;
		for (int i = 0; i < hashArray.length; i ++)
		{
			if (hashArray[i] != null)
			{
				count++;
			}
			if (item == count)
			{
				return hashArray[i];
			}
		}
		return null;
	}
	
	public int size()
	{
		int count = 0;
		for (int i = 0; i < hashArray.length; i ++)
		{
			if (hashArray[i] != null)
			{
				count++;
			}
		}
		return count;
	}

}
