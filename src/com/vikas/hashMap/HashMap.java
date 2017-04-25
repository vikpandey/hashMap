package com.vikas.hashMap;

/**
 * 
 * @author vikas
 *
 */

public class HashMap {
	
	private HashItem[] hashMap;
	private int tableSize = 5;
	public double loadFactor = (1/2)*tableSize;
	double size = 0;
	
	public HashMap() {
		if(size == loadFactor) {
			tableSize = 2 * tableSize;
			this.hashMap = new HashItem[tableSize];
		}
		else {
		this.hashMap = new HashItem[tableSize];
		}
	}
	
	public int hash(String key) {
		int index = (key.hashCode() & 0x7fffffff) % tableSize;
		return index;
	}
	
	public void put(String key, int value) {
		//System.out.println("size is :- " + size);
		
	//	if(size == loadFactor) {
	//		System.out.println("size is equal to loadFactor " + size + " loadFactor is :- " + loadFactor);
	//		tableSize = tableSize*2;
	//	}
		
		int hashArrayIndex = hash(key);
		
		if(hashMap[hashArrayIndex] == null) {
			HashItem hashItem = new HashItem(key, value);
			hashMap[hashArrayIndex] = hashItem;
		}
		else {
			HashItem hashItem = hashMap[hashArrayIndex];
			
			while(hashItem.getNextHashItem() != null && hashItem.getKey() != key) {
				System.out.println("hashItem key is:- " + hashItem.getKey());
				hashItem = hashItem.getNextHashItem();
			}
		    System.out.println("hashItem key outside loop is :- " + hashItem.getKey());
		    if(hashItem.getKey() == key) {
		    	hashItem.setValue(value);
		    }
		    else {
		    	hashItem.setNextHashItem(new HashItem(key, value));
		    }
			
		}
		//size++;
		//System.out.println("size after adding hashitem : " + size);
	}
	
	public int get(String key) {
		
		int hashArrayIndex = hash(key);
		
		if(hashMap[hashArrayIndex] == null) {
			return -1;
		}
		else {
			HashItem hashItem = hashMap[hashArrayIndex];
			while(hashItem != null && key != hashItem.getKey()) {
				hashItem = hashItem.getNextHashItem();
			}
			return hashItem.getValue();
		}
	}

}
