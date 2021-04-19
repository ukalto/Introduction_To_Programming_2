import java.awt.*;

// This class represents celestial bodies like stars, planets, asteroids, etc..
public class Body {

    //TODO: change modifiers.
    private String name;
    private double mass;
    private double radius;
    private Vector3 position; // position of the center.
    private Vector3 currentMovement;
    private Color color; // for drawing the body.
    private Vector3 force;

    //TODO: define constructor.
    public Body(String name, double mass, double radius, Vector3 position, Vector3 currentMovement, Color color) {
        this.name = name;
        this.mass = mass;
        this.radius = radius;
        this.position = position;
        this.currentMovement = currentMovement;
        this.color = color;
    }

    // Returns the distance between this body and the specified 'body'.
    public double distanceTo(Body body) {
        //TODO: implement method.
        return this.position.distance(body.position);
    }

    public String getName() {
        return name;
    }

    public void setForce(Vector3 force) {
        this.force = force;
    }

    public Vector3 getForce() {
        return force;
    }

    //Returns a vector representing the gravitational force exerted by 'body' on this body.
    //The gravitational Force F is calculated by F = G*(m1*m2)/(r*r), with m1 and m2 being the masses of the objects
    //interacting, r being the distance between the centers of the masses and G being the gravitational constant.
    //To calculate the force exerted on b1, simply multiply the normalized vector pointing from b1 to b2 with the
    //calculated force
    public Vector3 gravitationalForce(Body body) {
        //TODO: implement method.
        Vector3 direction = body.position.minus(this.position);
        double distance = direction.length();
        direction.normalize();
        double force = Simulation.G * this.mass * body.mass / (distance * distance);
        return direction.times(force);
    }

    // Moves this body to a new position, according to the specified force vector 'force' exerted
    // on it, and updates the current movement accordingly.
    // (Movement depends on the mass of this body, its current movement and the exerted force)
    // Hint: see simulation loop in Simulation.java to find out how this is done
    public void move(Vector3 force) {
        //TODO: implement method.
        Vector3 oldPosition = this.position;
        this.position = currentMovement.plus(this.position.plus(force.times(1 / this.mass)));
        this.currentMovement = position.minus(oldPosition); // new minus old position.
    }

    public void move(){
        Vector3 oldPosition = this.position;
        this.position = currentMovement.plus(this.position.plus(force.times(1 / this.mass)));
        this.currentMovement = position.minus(oldPosition);
    }

    // Returns a string with the information about this body including
    // name, mass, radius, position and current movement. Example:
    // "Earth, 5.972E24 kg, radius: 6371000.0 m, position: [1.48E11,0.0,0.0] m, movement: [0.0,29290.0,0.0] m/s."
    public String toString() {
        //TODO: implement method.
        return String.format("%s, %s kg, radius: %s m, position: %s m, movement: %s m/s.", this.name, this.mass, this.radius, position.toString(), currentMovement.toString());
    }

    // Draws the body to the current StdDraw canvas as a dot using 'color' of this body.
    // The radius of the dot is in relation to the radius of the celestial body
    // (use a conversion based on the logarithm as in 'Simulation.java').
    // Hint: use the method drawAsDot implemented in Vector3 for this
    public void draw() {
        //TODO: implement method.
        this.position.drawAsDot(this.radius, this.color);
    }
}