public class NBody {
    public static void main(String[] args) {
        double T = Double.valueOf(args[0]);
        double dt = Double.valueOf(args[1]);
        String filename = args[2];

        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);

        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(0 - radius, radius);

        StdDraw.clear();

        StdDraw.picture(0, 0, "./images/starfield.jpg");

        for (Planet planet : planets) {
            planet.draw();
        }

        double[] xForces = new double[planets.length];
        double[] yForces = new double[planets.length];

        for (int t = 0; t < T; t += dt) {
            for (int i = 0; i < planets.length; i++) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
                planets[i].update(dt, xForces[i], yForces[i]);
            }
            StdDraw.picture(0, 0, "./images/starfield.jpg");

            for (Planet planet : planets) {
                planet.draw();
            }

            StdDraw.show();
            StdDraw.pause(10);
        }
        
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }

    }

    public static double readRadius(String filename) {
        In in = new In(filename);
        return Double.parseDouble(in.readAllLines()[1]);
    }

    public static Planet[] readPlanets(String filename) {
        In in = new In(filename);

        int N = in.readInt();
        Planet[] planets = new Planet[N];

        double radius = in.readDouble();
        for (int i = 0; i < N; i++) {
            planets[i] = new Planet(in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(),
                    in.readString());
        }
        return planets;

    }
}
