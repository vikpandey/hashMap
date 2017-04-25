package com.vikas.hashMap;

/**
 * 
 * @author vikas
 *
 */

public class HashItem {
	
	private String key;
	private int value;
	private HashItem nextHashItem;
	
	public HashItem getNextHashItem() {
		return nextHashItem;
	}

	public void setNextHashItem(HashItem nextHashItem) {
		this.nextHashItem = nextHashItem;
	}

	public HashItem(String key, int value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
