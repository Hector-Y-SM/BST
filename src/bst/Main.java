package bst;

public class Main {

    public static void main(String[] args) {
    	int aux;
        BST bst = new BST();
        
        Product p1 = new Product(10, "Product 1", "test-1", 100.0, 10);
        Product p2 = new Product(20, "Product 2", "test-2", 200.0, 5);
        Product p3 = new Product(5, "Product 3", "test-3", 50.0, 20);
        Product p4 = new Product(15, "Product 4", "test-4", 150.0, 30);
        Product p5 = new Product(25, "Product 5", "test-5", 250.0, 12);
        Product p6 = new Product(30, "Product 6", "test-6", 250.0, 12);
        
        bst.insert(p1);
        bst.insert(p2);
        bst.insert(p3);
        bst.insert(p4);
        bst.insert(p5);
        bst.insert(p6);

        aux = 15;
        boolean containsProduct = bst.contain(aux); 
        System.out.println("Tree contains product with ID "+aux+": " + containsProduct);

        aux = 20;
        Product foundProduct = bst.search(aux); 
        if (foundProduct != null) {
            System.out.println("Product found: " + foundProduct);
        } else {
            System.out.println("Product with ID "+aux+" not found");
        }

        aux = 10;
        bst.delete(10); 
        System.out.println("Product with ID "+aux+" removed");

        
        Product afterDelete = bst.search(aux);
        if (afterDelete == null) {
            System.out.println("Product with ID "+aux+" no longer exists in the tree");
        }

        System.out.println("Tour pre-order:");
        bst.preOrder();
        System.out.println("Tour in-order:");
        bst.inOrder(); 
        
        /* tree
         *       15
     			/  \
    		   5   20
          			 \
           			 25
             		   \
              		   30
         */

        int height = bst.Height();
        System.out.println("tree height: " + height);
        
    }
}
