//This class represents a binary search tree for objects of class 'CosmicSystem'
public class CosmicSystemTree {

    //TODO: Define variables.
    private MyTreeNode root;

    // Adds a system of bodies to the tree. Since the keys of the tree are the names of bodies,
    // adding a system adds multiple (key, value) pairs to the tree, one for each body of the
    // system, with the same value, i.e., reference to the cosmic system.
    // An attempt to add a system with a body that already exists in the tree
    // leaves the tree unchanged and the returned value would be 'false'.
    // For example, it is not allowed to have a system with the bodies "Earth" and "Moon" and another
    // system with the bodies "Jupiter" and "Moon" indexed by the tree, since "Moon" is not unique.
    // The method returns 'true' if the tree was changed as a result of the call and
    // 'false' otherwise.
    public boolean add(CosmicSystem system) {
        //TODO: implement method
        for (int i = 0; i < system.size(); i++) {
            if (root == null) break;
            else if (root.find(system.get(i).getName()) != null) return false;
        }
        for (int i = 0; i < system.size(); i++) {
            if (root == null) root = new MyTreeNode(system.get(i).getName(), system);
            else root.put(system.get(i).getName(), system);
        }
        return true;
    }
    
    public String determineLargerSide(){
        int countLeft = root.size(root.firstLeft(root));
        int countRight = root.size(root.firstRight(root));
        if(countLeft > countRight) return "Left";
        else if(countLeft < countRight) return "Right";
        else return "Even";
    }

    // Returns the cosmic system in which a body with the specified name exists.
    // For example, if the specified name is "Europa", the system of Jupiter (Jupiter, Io,
    // Europa, Ganymed, Kallisto) will be returned.
    // If no such system is found, 'null' is returned.
    public CosmicSystem get(String name) {
        //TODO: implement method
        if (root.find(name).value() == null) return null;
        return root.find(name).value();
    }

    // Returns the overall number of bodies indexed by the tree.
    public int numberOfBodies() {
        //TODO: implement method
        return root.size(root);
    }

    // Returns a readable representation with (key, value) pairs, sorted alphabetically by the key.
    //E.g.,
    //    (Deimos,Mars System)
    //    (Earth,Earth System)
    //
    //Hint: for this you will also need a method in CosmicSystem.java to access the name of a CosmicSystem object.
    public String toString() {
        //TODO: implement method
        return root.toString();
    }

    //BONUS TASK: sets a new canvas and draws the tree using StdDraw
    public void drawTree() {
        //TODO: implement method
        StdDraw.setCanvasSize(1000, 500);
        StdDraw.setXscale(0, 2);
        StdDraw.setYscale(0, 1);

        if (root != null) {
            root.draw(1, 0.95, false);
        }
    }

    //TODO: Define additional class(es) implementing the binary tree (either here or outside class).
}