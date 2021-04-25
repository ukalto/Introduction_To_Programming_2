import javax.swing.plaf.IconUIResource;

//This class represents a double-linked list for objects of class 'CosmicComponent'.
public class ComplexCosmicSystem implements CosmicComponent {

    //TODO: Define variables.
    private MyDoubleListNodeCCS head;
    private String name;

    // Initialises this system as an empty system with a name.
    public ComplexCosmicSystem(String name) {
        //TODO: implement constructor.
        this.name = name;
    }

    // Adds 'comp' to the list of cosmic components of the system if the list does not already contain a
    // component with the same name as 'comp', otherwise does not change the object state. The method
    // returns 'true' if the list was changed as a result of the call and 'false' otherwise.
    public boolean add(CosmicComponent comp) {
        //TODO: implement method.
        if (comp == null) return false;
        MyDoubleListNodeCCS node = new MyDoubleListNodeCCS(comp);
        if (head == null) {
            node.setPrev(null);
            head = node;
            return true;
        }
        MyDoubleListNodeCCS current = head;
        if (current.hasValue(comp)) return false;
        while (current.next() != null) {
            current = current.next();
        }
        current.setNext(node);
        node.setPrev(current);
        return true;
    }

    public MyDoubleListNodeCCS getNodeWithCosmicComponent(CosmicComponent cs) {
        MyDoubleListNodeCCS current = head;
        while (current != null) {
            if (current.value().getName().equals(cs.getName())) return current;
            current = current.next();
        }
        return null;
    }

    public boolean remove(MyDoubleListNodeCCS del) {
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

    //Removes a component from the list if the list contains a component with the same name as the input component.
    //Returns true if removal was done, and false otherwise (no component with the same name).
    public boolean remove(CosmicComponent comp) {
        //TODO: implement method.
        MyDoubleListNodeCCS del = getNodeWithCosmicComponent(comp);
        return remove(del);
    }

    // Returns the CosmicComponent with the specified name or 'null' if no such component exists in the list.
    public CosmicComponent get(String name) {
        //TODO: implement method.
        if (head == null) return null;
        MyDoubleListNodeCCS current = head;
        while (current != null) {
            if (current.value().getName().equals(name)) return current.value();
            current = current.next();
        }
        return null;
    }

    // Returns the CosmicComponent with the same name as the input component or 'null' if no such CosmicComponent exists in the list.
    public CosmicComponent get(CosmicComponent c) {
        //TODO: implement method.
        if (head == null) return null;
        if (!head.hasValue(c)) return null;
        MyDoubleListNodeCCS current = head;
        while (current != null) {
            if (current.value().getName().equals(c.getName())) return current.value();
            current = current.next();
        }
        return null;
    }

    // Returns the name of this system.
    public String getName() {
        //TODO: implement method.
        return name;
    }

    // Returns the number of CosmicComponent entries of the list.
    public int size() {
        //TODO: implement method.
        if (head == null) return 0;
        int counter = 0;
        MyDoubleListNodeCCS current = head;
        while (current != null) {
            counter++;
            current = current.next();
        }
        return counter;
    }

    // Returns a readable representation of the ComplexCosmicSystem.
    // The representation should list all the names of its bodies and sub-systems, where the hierarchy is indicated by {} brackets
    //For instance, considering if we have a system called "Solar System" with the entries "Sun", "Earth System" and "Jupiter System".
    //"Sun" is a body, "Earth System" is a system with the bodies "Earth" and "Moon", and "Jupiter System" is a system with the body "Jupiter".
    //Then the output should be "Solar System{Sun, Earth System{Earth, Moon}, Jupiter System{Jupiter}}"
    //An empty system is indicated by empty brackets, e.g. "Jupiter System{}"
    //
    //CONSTRAINT: use the concept of dynamic binding to fulfill this task, i.e. don't use type casts, getClass() or instanceOf().
    public String toString() {
        //TODO: implement method.
        MyDoubleListNodeCCS current = head;
        String system = getName() + "{";
        while (current != null) {
            if(current!= head) system += ", "+current.value().toString();
            else system += current.value().toString();
            current = current.next();
        }
        return system+"}";
    }

    //Returns the overall number of bodies (i.e. objects of type 'Body') contained in the ComplexCosmicSystem.
    //For instance, the System "Solar System{Sun, Earth System{Earth, Moon}, Jupiter System{Jupiter}}" contains 4 bodies (Sun, Earth, Moon and Jupiter).
    //
    //CONSTRAINT: use the concept of dynamic binding to fulfill this task, i.e. don't use type casts, getClass() or instanceOf().
    public int numberOfBodies() {
        //TODO: implement method.
        MyDoubleListNodeCCS current = head;
        int counter = 0;
        while (current != null) {
            counter += current.value().numberOfBodies();
            current = current.next();
        }
        return counter;
    }

    //Returns the overall mass (sum of all contained components).
    //In case of an empty system, a mass of 0.0 should be returned.
    //
    //CONSTRAINT: use the concept of dynamic binding to fulfill this task, i.e. don't use type casts, getClass() or instanceOf().
    public double getMass() {
        //TODO: implement method.
        MyDoubleListNodeCCS current = head;
        int sum = 0;
        while (current != null) {
            sum += current.value().getMass();
            current = current.next();
        }
        return sum;
    }

    //Returns the gravitational center of this component (weighted average of contained components).
    //In case of an empty system, a vector [0.0, 0.0, 0.0] should be returned.
    //
    //CONSTRAINT: use the concept of dynamic binding to fulfill this task, i.e. don't use type casts, getClass() or instanceOf().
    public Vector3 getMassCenter() {
        //TODO: implement method.
        MyDoubleListNodeCCS current = head;
        Vector3 sum = new Vector3(0, 0, 0);
        if(getMass() == 0) return sum;
        while (current != null) {
            sum = sum.plus(current.value().getMassCenter().times(current.value().getMass()));
            current = current.next();
        }
        return sum.divide(getMass());
    }

}

//TODO: Define additional class(es) implementing the double-linked list (either here or outside class).