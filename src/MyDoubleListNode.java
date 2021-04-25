public class MyDoubleListNode {
    private Body value;
    private MyDoubleListNode next;
    private MyDoubleListNode prev;

    public MyDoubleListNode(Body v) {
        this.value = v;
    }

    public Body value() {
        return value;
    }

    public MyDoubleListNode next() {
        return next;
    }

    public MyDoubleListNode prev() {
        return prev;
    }

    public void setNext(MyDoubleListNode n) {
        next = n;
    }

    public void setPrev(MyDoubleListNode n) {
        prev = n;
    }

    public boolean hasValue(Body v) {
        return (v == null ? value == v
                : v.getName().equals(value.getName())) ||
                (next != null && next.hasValue(v));
    }
}