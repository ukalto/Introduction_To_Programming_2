public class MyListNode {
    private Body value;
    private MyListNode next;
    private MyListNode prev;

    public MyListNode(Body v) {
        this.value = v;
        this.next = null;
    }

    public Body value() {
        return value;
    }

    public MyListNode next() {
        return next;
    }

    public MyListNode prev() {
        return prev;
    }

    public void setNext(MyListNode n) {
        next = n;
    }

    public void setPrev(MyListNode n) {
        prev = n;
    }

    public boolean hasValue(Body v) {
        return (v == null ? value == v
                : v.getName().equals(value.getName())) ||
                (next != null && next.hasValue(v));
    }
}