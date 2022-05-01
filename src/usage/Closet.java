package usage;

import usage.model.Cloth;

public class Closet {

	private int capacity;
	private int length;
	private Cloth[] clothArray;
	
	public Closet(int capacity) {
		this.capacity = capacity;
		clothArray = new Cloth[capacity];
	}

	public void add(Cloth cloth) {
		if(length == capacity) {
			throw new RuntimeException("capacity is not enough");
		}
		
		// TODO
		
		length++;
	}
	
	public Cloth findById(Integer id) {
		if(id == null) {
			throw new RuntimeException("parameter id cannot be null");
		}
		
		Cloth result = null;
		for(Cloth cloth : clothArray) {
			if(cloth.getId() == id) {
				result = cloth;
				break;
			}
		}
		return result;
	}
	
	public Cloth[] findByType() {
		Cloth[] result = null;
		
		// TODO
		
		return result;
	}
	
	public Cloth[] findByName() {
		Cloth[] result = null;
		
		// TODO
		
		return result;
	}
	
	public int getLength() {
		return this.length;
	}
}
