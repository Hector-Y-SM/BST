package bst;

public class BST implements IBST<Product>{
	
	private class Nodo{
		Product product;
		Nodo left, right;
		
		Nodo(Product product){
			this.product = product;
			this.left = null;
			this.right = null;
		}
	}
	
	private Nodo root;
	
	@Override
	public void insert(Product prod) {
		root = insertAux(root, prod); //recursive
	}
	
	private Nodo insertAux(Nodo current, Product prod) {
		if(current == null) {
			return new Nodo(prod);
		}
		
		if(prod.compareTo(current.product) < 0) {
			current.left = insertAux(current.left, prod);
		} else if (prod.compareTo(current.product) > 0) {
			current.right = insertAux(current.right, prod);
		} else {
			throw new Error("Error duplicate ID");
		}
		
		return current;
	}

	@Override
	public boolean contain(int id) {
		return search(id) != null;
	}

	@Override
	public Product search(int id) {
	    return searchAux(root, id);
	}

	private Product searchAux(Nodo current, int id) {
	    if (current == null){ return null; }
	    if (id == current.product.getId()){ return current.product; }

	    return id < current.product.getId()
	    			? searchAux(current.left, id)
	    					: searchAux(current.right, id);
	}

	@Override
	public void delete(int id) {
		root = deleteAux(root, id);
	}

	private Nodo deleteAux(Nodo current, int id) {
		if(current == null){ return null; }
		
		if(id < current.product.getId()) {
			current.left = deleteAux(current.left, id);
		} else if(id > current.product.getId()) {
			current.right = deleteAux(current.right, id);
		} else {
			if(current.left == null && current.right == null) {
				return null;
			} else if( current.left == null || current.right == null) {
				Nodo child = (current.left != null)? current.left : current.right;
				return child;
			} else {
				Nodo successor = findMin(current.right);
				current.product = successor.product;
				current.right = deleteAux(current.right, successor.product.getId());
			}
		}
		return current;
	}

	private Nodo findMin(Nodo current) {
		while(current.left != null) {
			current = current.left;
		}
		return current;
	}

	@Override
	public boolean isLeafNode() {
		return root != null && isLeafNodeAux(root);
	}

	private boolean isLeafNodeAux(Nodo current) {
		if(current == null) {return false;}
		return current.left == null && current.right == null;
	}

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public void inOrder() {
		inOrderAux(root);
	}

	private void inOrderAux(Nodo current) {
	    if (current != null) {
	        inOrderAux(current.left);  
	        System.out.println(current.product);  
	        inOrderAux(current.right); 
	    }
	}

	@Override
	public void preOrder() {
	    preOrderAux(root);
	}

	private void preOrderAux(Nodo current) {
	    if (current != null) {
	        System.out.println(current.product);  
	        preOrderAux(current.left);  
	        preOrderAux(current.right); 
	    }
	}

	@Override
	public void postOrden() {
	    postOrderAux(root);
	}

	private void postOrderAux(Nodo current) {
	    if (current != null) {
	        postOrderAux(current.left);  
	        postOrderAux(current.right);  
	        System.out.println(current.product); 
	    }
	}

	@Override
	public int Height() {
		return heightAux(root);
	}

	private int heightAux(Nodo current) {
		if(current == null) { return 0; }
		int leftHeight = heightAux(current.left);
		int rightHeight = heightAux(current.right);
		return Math.max(leftHeight, rightHeight) + 1;
	}
}