package bst;

public interface IBST<T extends Comparable>{
	void insert(T prod);
	boolean contain(int id);
	T search(int id);
	void delete(int id);
	boolean isLeafNode();
	boolean isEmpty(); //tree null
	
	void inOrder();
	void preOrder();
	void postOrden();
	
	int Height();
}