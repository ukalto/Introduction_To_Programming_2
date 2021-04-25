public class MyDoubleListNodeCCS {
    private CosmicComponent value;
    private MyDoubleListNodeCCS next;
    private MyDoubleListNodeCCS prev;

    public MyDoubleListNodeCCS(CosmicComponent v) {
        this.value = v;
        this.next = null;
    }

    public CosmicComponent value() {
        return value;
    }

    public MyDoubleListNodeCCS next() {
        return next;
    }

    public MyDoubleListNodeCCS prev() {
        return prev;
    }

    public void setNext(MyDoubleListNodeCCS n) {
        next = n;
    }

    public void setPrev(MyDoubleListNodeCCS n) {
        prev = n;
    }

    public boolean hasValue(CosmicComponent v) {
        return (v == null ? value == v
                : v.getName().equals(value.getName())) ||
                (next != null && next.hasValue(v));
    }
}