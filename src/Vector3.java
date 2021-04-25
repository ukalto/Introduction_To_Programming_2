import java.awt.*;

// This class represents vectors in a 3D vector space.
public class Vector3 {

    //TODO: change modifiers.
    private double x;
    private double y;
    private double z;

    //TODO: define constructor.
    public Vector3(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Returns the sum of this vector and vector 'v'.
    public Vector3 plus(Vector3 v) {
        //TODO: implement method.
        return new Vector3(v.x + this.x, v.y + this.y, v.z + this.z);
    }

    // Returns the product of this vector and 'd'.
    public Vector3 times(double d) {
        //TODO: implement method.
        return new Vector3(this.x * d, this.y * d, this.z * d);
    }

    public Vector3 divide(double d) {
        //TODO: implement method.
        return new Vector3(this.x/d, this.y/d, this.z/d);
    }

    // Returns the sum of this vector and -1*v.
    public Vector3 minus(Vector3 v) {
        //TODO: implement method.
        return new Vector3(this.x - v.x, this.y - v.y, this.z - v.z);
    }

    // Returns the Euclidean distance of this vector
    // to the specified vector 'v'.
    public double distance(Vector3 v) {
        //TODO: implement method.
        double dX = this.x - v.x;
        double dY = this.y - v.y;
        double dZ = this.z - v.z;

        return Math.sqrt(dX * dX + dY * dY + dZ * dZ);
    }

    // Returns the length (norm) of this vector.
    public double length() {
        //TODO: implement method.
        return distance(new Vector3(0, 0, 0));
    }

    // Normalizes this vector: changes the length of this vector such that it becomes 1.
    // The direction and orientation of the vector is not affected.
    public void normalize() {
        //TODO: implement method.
        double length = length();
        this.x /= length;
        this.y /= length;
        this.z /= length;
    }

    // Draws a filled circle with a specified radius centered at the (x,y) coordinates of this vector
    // in the existing StdDraw canvas. The z-coordinate is not used.
    public void drawAsDot(double radius, Color color) {
        //TODO: implement method.
        StdDraw.setPenColor(color);
        StdDraw.filledCircle(this.x, this.y,
                1e9*Math.log10(radius));
    }

    // Returns the coordinates of this vector in brackets as a string
    // in the form "[x,y,z]", e.g., "[1.48E11,0.0,0.0]".
    public String toString() {
        //TODO: implement method.
        return String.format("[%s,%s,%s]", this.x, this.y, this.z);
    }
}