package training.center.tub.Controllers;

import java.util.ArrayList;

public class GenericController<T> {
	
	public ArrayList<T> items = new ArrayList<T>();

	public ArrayList<T> getItems() {
		return this.items;
	}
	
	public T getItem(int id) {
		return (T) items.get(id - 1);
	}
	
	public void addItems(ArrayList<T> items) {
		this.items.addAll(items); 
	}
	
	public void addItem(T item) {
		this.items.add(item); 
	}

	public void removeItem(T item) {
		this.items.remove(item);
	}
	
	
}
