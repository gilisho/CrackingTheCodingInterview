package chapter16;

import java.util.HashMap;

public class LRUCache<K, V> {

	//question 16.25
	
	private int maxSize;
	private HashMap<K,LinkedListNode> hashmap;
	private LinkedListNode MRU;
	
	public LRUCache(int maxSize){
		this.maxSize = maxSize;
		this.hashmap = new HashMap<K,LinkedListNode>();
	}
	
	public int size(){
		return this.hashmap.size();
	}
	
	public boolean isFull(){
		return maxSize==this.size();
	}
	
	public V retrieve(K key){
		LinkedListNode node = hashmap.get(key);
		this.updateMRU(node);
		return (node!=null) ? node.value : null ;
	}
	
	public void updateMRU(LinkedListNode node){
		if (node == null)
			return;
		
		node.prev.next = node.next;
		node.next.prev = node.prev;

		this.MRU.prev.next = node;
		node.prev = this.MRU.prev;
		this.MRU.prev = node;
		node.next = this.MRU;
		this.MRU = node;
	}
	
	public void insert(K key, V value){
		if (isFull())
			this.deleteLRU();
		LinkedListNode node = new LinkedListNode(key, value);
		updateMRU(node);
		hashmap.put(key, node);
	}
	
	public void deleteLRU(){
		LinkedListNode node = this.MRU.prev;
		node.prev.next = node.next;
		node.next.prev = node.prev;
		hashmap.remove(node.key);
	}
	
	private class LinkedListNode {
		K key;
		V value;
		LinkedListNode next;
		LinkedListNode prev;
		
		public LinkedListNode(K key, V value){
			this.key = key;
			this.value = value;
			this.next = this;
			this.prev = this;
		}
		
	}
	
}
