public class Simulation {

    // gravitational constant
    public static final double G = 6.6743e-11;

    // one astronomical unit (AU) is the average distance of earth to the sun.
    public static final double AU = 150e9;

    // all quantities are based on units of kilogram respectively second and meter.

    // The main simulation method using instances of other classes.
    public static void main(String[] args) {

        //TODO: change implementation of this method according to 'Aufgabe1.md'.

        Body sun = new Body("Sol",1.989e30,696340e3,new Vector3(0,0,0),new Vector3(0,0,0),StdDraw.YELLOW);
        Body earth = new Body("Earth",5.972e24,6371e3,new Vector3(-1.394555e11,5.103346e10,0),new Vector3(-10308.53,-28169.38,0),StdDraw.BLUE);
        Body mercury = new Body("Mercury",3.301e23,2440e3,new Vector3(-5.439054e10,9.394878e9,0),new Vector3(-17117.83,-46297.48,-1925.57),StdDraw.GRAY);
        Body venus = new Body("Venus",4.86747e24,6052e3,new Vector3(-1.707667e10,1.066132e11,2.450232e9),new Vector3(-34446.02,-5567.47,2181.10),StdDraw.PINK);
        Body mars = new Body("Mars",6.41712e23,3390e3,new Vector3(-1.010178e11,-2.043939e11,-1.591727E9),new Vector3(20651.98,-10186.67,-2302.79),StdDraw.RED);

        CosmicSystem cs = new CosmicSystem("CosmicSystem");
        cs.add(sun);
        cs.add(earth);
        cs.add(mercury);
        cs.add(venus);
        cs.add(mars);

        StdDraw.setCanvasSize(500, 500);
        StdDraw.setXscale(-2 * AU, 2 * AU);
        StdDraw.setYscale(-2 * AU, 2 * AU);
        StdDraw.enableDoubleBuffering();
        StdDraw.clear(StdDraw.BLACK);

        double seconds = 0;

        // simulation loop
        while (true) {
            seconds++; // each iteration computes the movement of the celestial bodies within one second.
            // for each body (with index i): compute the total force exerted on it.
            for (int i = 0; i < cs.size(); i++) {
                cs.get(i).setForce(new Vector3(0, 0, 0)); // begin with zero
                for (int j = 0; j < cs.size(); j++) {
                    if (i == j) continue;
                    Vector3 forceToAdd = cs.get(i).gravitationalForce(cs.get(j));
                    cs.get(i).setForce(forceToAdd.plus(cs.get(i).getForce()));
                }
            }
            // now forceOnBody[i] holds the force vector exerted on body with index i.

            // for each body (with index i): move it according to the total force exerted on it.
            for (int i = 0; i < cs.size(); i++) {
                cs.get(i).move();
            }

            // show all movements in StdDraw canvas only every 3 hours (to speed up the simulation)
            if (seconds % (3 * 3600) == 0) {
                // clear old positions (exclude the following line if you want to draw orbits).
                StdDraw.clear(StdDraw.BLACK);
                // draw new positions
                for (int i = 0; i < cs.size(); i++) {
                    cs.get(i).draw();
                }
                // show new positions
                StdDraw.show();
            }
        }
    }
}

//TODO: answer additional questions of 'Aufgabe1'.

//Was versteht man unter Datenkapselung? Geben Sie ein Beispiel, wo dieses Konzept in dieser Aufgabenstellung angewendet wird.
//      Unter der Datenkapselung versteht man, dass zusammenfassen von Methoden und Variablen zu einer Einheit.
//
//      Bei der Methode gravitationalForce wurde dieses System angewandt.


//Was versteht man unter Data Hiding?  Geben Sie ein Beispiel, wo dieses Konzept in dieser Aufgabenstellung angewendet wird.
//      private/public
//      public gehört zur Außen- und Innensicht
//      private gehört nur zur Innensicht
//      Man versteckt bewusst Informationen und verhindert so unbefugten Zugriff.
//
//      Alle Variablen oder Methoden.
//      Beispielsweise bei der Klasse Vector3 x,y,z.