//This class represents a linked list for objects of class 'Body'
public class CosmicSystem {

    //TODO: Define variables.
    private String name;
    private MyListNode head;

    // Initialises this system as an empty system with a name.
    public CosmicSystem(String name) {
        //TODO: implement constructor.
        this.name = name;
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
        MyListNode current = head;
        node.setNext(null);
        if (head == null) {
            node.setPrev(null);
            head = node;
            return true;
        }
        if (current.hasValue(body)) return false;
        while (current.next() != null) {
            current = current.next();
        }
        current.setNext(node);
        node.setPrev(current);
        return true;
    }

    // Returns the 'body' with the index 'i'. The body that was first added to the list has the
    // index 0, the body that was most recently added to the list has the largest index (size()-1).
    // Precondition: 'i' is a valid index.
    public Body get(int i) {
        //TODO: implement method.
        MyListNode current = head;
        while (i > 0) {
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

    public MyListNode getNodeWithI(int i) {
        if (i < 0 || i > size()) return null;
        MyListNode current = head;
        while (i > 0) {
            i--;
            current = current.next();
        }
        return current;
    }

    public MyListNode getNodeWithBody(Body body) {
        MyListNode current = head;
        while (current != null) {
            if (current.value().getName().equals(body.getName())) return current;
            current = current.next();
        }
        return null;
    }

    // Inserts the specified 'body' at the specified position
    // in this list if 'i' is a valid index and there is no body
    // in the list with the same name as that of 'body'.
    // Shifts the element currently at that position (if any) and
    // any subsequent elements to the right (adds 1 to their
    // indices). The first element of the list has the index 0.
    // Returns 'true' if the list was changed as a result of
    // the call, 'false' otherwise.
    public boolean add(int i, Body body) {
        MyListNode node = new MyListNode(body);
        MyListNode current = head;
        if (i < 0 || i > size()) return false;
        if (current.hasValue(body)) return false;
        current = getNodeWithI(i);
        if (current == null) {
            MyListNode last = getNodeWithI(i - 1);
            last.setNext(node);
            node.setPrev(last);
            node.setNext(null);
            return true;
        }
        current.prev().setNext(node);
        node.setPrev(current.prev());
        node.setNext(current);
        current.setPrev(node);
        if (current.next() != null)
            current.next().setPrev(current);
        return true;
    }

    public boolean remove(MyListNode del) {
        if (head == null || del == null) return false;
        if (head == del && head.next() != null) {
            head = del.next();
            return true;
        }
        if (del.next() != null) {
            del.next().setPrev(del.prev());
        }
        if (del.prev() != null) {
            del.prev().setNext(del.next());
        }
        return true;
    }

    //removes the body at index i from the list, if i is a valid index
    //returns true if removal was done, and false otherwise (invalid index)
    public boolean remove(int i) {
        //TODO: implement method.
        if (i < 0 || i > size()) return false;
        MyListNode del = getNodeWithI(i);
        return remove(del);
    }

    //removes a body from the list, if the list contains a body with the same name as the input body
    //returns true if removal was done, and false otherwise (no body with the same name)
    public boolean remove(Body body) {
        //TODO: implement method.
        MyListNode del = getNodeWithBody(body);
        return remove(del);
    }

    // Returns a new list that contains the same elements as this list in reverse order. The list 'this'
    // is not changed and only the references to the bodies are copied, not their content (shallow copy).
    public CosmicSystem reverse() {
        //TODO: implement method.
        MyListNode current = head, temp = null;

        /* swap next and prev for all nodes of
         doubly linked list */
        while (current != null) {
            temp = current.prev();
            current.setPrev(current.next());
            current.setNext(temp);
            current = current.prev();
        }

        /* Before changing head, check for the cases like
         empty list and list with only one node */
        if (temp != null) {
            head = temp.prev();
        }
        return this;
    }

    // Returns a readable representation with the name of the system and all bodies in order of the list.
    // E.g.,
    // Jupiter System:
    // Jupiter, 1.898E27 kg, radius: 6.9911E7 m, position: [0.0,0.0,0.0] m, movement: [0.0,0.0,0.0] m/s.
    // Io, 8.9E22 kg, radius: 1822000.0 m, position: [0.0,0.0,0.0] m, movement: [0.0,0.0,0.0] m/s.
    //
    //Hint: also use toString() in Body.java for this.
    public String toString() {
        //TODO: implement method.
        MyListNode current = head;
        String output = getName() + ":\n";
        for (int i = 0; i < size(); i++) {
            output += current.value().toString() + "\n";
            current = current.next();
        }
        return output;
    }
}