public class MyTreeNode {
    private String key;
    private CosmicSystem value;
    private MyTreeNode left, right;

    public MyTreeNode(String k, CosmicSystem v) {
        key = k;
        value = v;
    }

    private int compare(String k) {
        if (k == null) {
            return key == null ? 0 : -1;
        }
        if (key == null) {
            return 1;
        }
        return k.compareTo(key);
    }

    public CosmicSystem put(String k, CosmicSystem v) {
        int cmp = compare(k);
        if (cmp < 0) {
            if (left != null) {
                return left.put(k, v);
            }
            left = new MyTreeNode(k, v);
        } else if (cmp > 0) {
            if (right != null) {
                return right.put(k, v);
            }
            right = new MyTreeNode(k, v);
        } else {
            CosmicSystem result = value;
            value = v;
            return result;
        }
        return null;
    }

    public MyTreeNode find(String k) {
        int cmp = compare(k);
        if (cmp == 0) {
            return this;
        }
        MyTreeNode node = cmp < 0 ? left : right;
        if (node == null) {
            return null;
        }
        return node.find(k);
    }

    public boolean hasValue(CosmicSystem v) {
        return (v == null ? value == v
                : v.equals(value)) ||
                (left != null && left.hasValue(v)) ||
                (right != null && right.hasValue(v));
    }

    public CosmicSystem value() {
        return value;
    }

    public int size(MyTreeNode root) {
        if (null == root) return 0;
        return 1 + size(root.left) + size(root.right);
    }

    public MyTreeNode firstLeft(MyTreeNode root){
        return root.left;
    }

    public MyTreeNode firstRight(MyTreeNode root){
        return root.right;
    }

    public String toString() {
        if (left != null && right != null)
            return "(" + key + "," + value.getName() + ")\n" + left.toString() + right.toString();
        else if (left != null) return "(" + key + "," + value.getName() + ")\n" + left.toString();
        else if(right != null) return "(" + key + "," + value.getName() + ")\n" + right.toString();
        return "(" + key + "," + value.getName() + ")\n";
    }

    public void draw(double x, double y, boolean textLeft) {
        StdDraw.filledCircle(x, y, 0.02);
        if (textLeft) {
            StdDraw.textLeft(x + 0.05, y, key + " (" + value.getName() + ")");
        } else {
            StdDraw.textRight(x - 0.05, y, key + " (" + value.getName() + ")");
        }

        if (left != null) {
            StdDraw.line(x, y, x - 0.2, y - 0.1);
            left.draw(x - 0.2, y - 0.1, false);
        }
        if (right != null) {
            StdDraw.line(x, y, x + 0.2, y - 0.1);
            right.draw(x + 0.2, y - 0.1, true);
        }
    }
}