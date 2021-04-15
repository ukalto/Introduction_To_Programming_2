//This class represents a linked list for objects of class 'Body'
public class CosmicSystem {

    //TODO: Define variables.
    private String name;
    private MyListNode head;
    private MyListNode tail;

    // Initialises this system as an empty system with a name.
    public CosmicSystem(String name) {
        //TODO: implement constructor.
        this.name = name;
        this.head = null;
        this.tail = null;
    }

    public String getName() {
        return name;
    }

    // Adds 'body' to the end of the list of bodies if the list does not already contain a
    // body with the same name as 'body', otherwise does not change the object state. The method
    // returns 'true' if the list was changed as a result of the call and 'false' otherwise.
    public boolean add(Body body) {
        //TODO: implement method.
        MyListNode node = new MyListNode(body);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            MyListNode current = head;
            while (current != null) {
                if (current.value().getName().equals(name)) return false;
                current = current.next();
            }
            tail.setNext(node);
            tail = node;
        }
        return true;
    }

    // Returns the 'body' with the index 'i'. The body that was first added to the list has the
    // index 0, the body that was most recently added to the list has the largest index (size()-1).
    // Precondition: 'i' is a valid index.
    public Body get(int i) {
        //TODO: implement method.
        MyListNode current = head;
        while (i >= 1) {
            i--;
            current = current.next();
        }
        return current.value();
    }

    // Returns the body with the specified name or 'null' if no such body exits in the list.
    public Body get(String name) {
        //TODO: implement method.
        MyListNode current = head;
        while (current != null) {
            if (current.value().getName().equals(name)) return current.value();
            current = current.next();
        }
        return null;
    }

    // Returns the body with the same name as the input body or 'null' if no such body exits in the list.
    public Body get(Body body) {
        //TODO: implement method.
        MyListNode current = head;
        while (current != null) {
            if (current.value().getName().equals(body.getName())) return current.value();
            current = current.next();
        }
        return null;
    }

    // returns the number of entries of the list.
    public int size() {
        //TODO: implement method.
        int counter = 0;
        MyListNode current = head;
        while (current != null) {
            current = current.next();
            counter++;
        }
        return counter;
    }
    //TODO: Define additional class(es) implementing the linked list (either here or outside class).
}