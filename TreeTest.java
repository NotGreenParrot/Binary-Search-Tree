public class TreeTest {

    public static void main(String[] args){
                MySearchTree<Integer> tree = new MySearchTree<>();
        
                // Test isEmpty
                System.out.println("Is tree empty? " + tree.isEmpty());
        
                // Test insert
                System.out.println("Inserting 50: " + tree.insert(50));
                System.out.println("Inserting 30: " + tree.insert(30));
                System.out.println("Inserting 70: " + tree.insert(70));
                System.out.println("Inserting 20: " + tree.insert(20));
                System.out.println("Inserting 40: " + tree.insert(40));
                System.out.println("Inserting 60: " + tree.insert(60));
                System.out.println("Inserting 80: " + tree.insert(80));
                System.out.println("Inserting 50 again (duplicate): " + tree.insert(50));
        
                // Test getSize
                System.out.println("Tree size: " + tree.getSize());
        
                // Test search
                System.out.println("Searching for 30: " + tree.search(30));
                System.out.println("Searching for 100: " + tree.search(100));
        
                // Test traversals
                System.out.print("Inorder traversal: ");
                tree.inorder();
        
                System.out.print("Preorder traversal: ");
                tree.preorder();
        
                System.out.print("Postorder traversal: ");
                tree.postorder();
        
                // Test delete
                System.out.println("Deleting 20 (leaf): " + tree.delete(20));
                System.out.println("Deleting 70 (node with one child): " + tree.delete(70));
                System.out.println("Deleting 50 (node with two children): " + tree.delete(50));
                System.out.print("Inorder traversal after deletions: ");
                tree.inorder();
        
                // Test iterator
                System.out.print("Tree elements using iterator: ");
                java.util.Iterator<Integer> iterator = tree.iterator();
                while (iterator.hasNext()) {
                    System.out.print(iterator.next() + " ");
                }
                System.out.println();
        
                // Test clear
                tree.clear();
                System.out.println("Tree cleared.");
                System.out.println("Is tree empty? " + tree.isEmpty());
                System.out.print("Inorder traversal after clearing: ");
                tree.inorder();
            
    }
}