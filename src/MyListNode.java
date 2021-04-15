public class MyListNode {
    private Body value;
    private MyListNode next;

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

    public void setNext(MyListNode n) {
        next = n;
    }
}