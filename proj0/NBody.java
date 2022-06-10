public class NBody {
	public static double readRadius(String filename) {
		In in = new In(filename);
		in.readLine(); // skip the first line
		double radiusUniverse = in.readDouble();
		return radiusUniverse;
	}

	public static Planet[] readPlanets(String filename) {
		In in = new In(filename);
		int numPlanets = in.readInt();
		Planet[] allPlanets = new Planet[numPlanets];

		/* skip first two lines */
		in.readLine();
		in.readLine();

		for (int i = 0; i < allPlanets.length; i++) {
			double xxPos = in.readDouble();
			double yyPos = in.readDouble();
			double xxVel = in.readDouble();
			double yyVel = in.readDouble();
			double mass = in.readDouble();
			String imgFileName = in.readString();
			allPlanets[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
		}
		return allPlanets;
	}

	public static void main(String[] args) {
		// 1. Collecting all needed input
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		Planet[] allPlanets = readPlanets(filename);
		double radius = readRadius(filename);

		// 2. Drawing the background
		StdDraw.setScale(-radius, radius);
		StdDraw.clear();
		StdDraw.picture(0, 0, "images/starfield.jpg");

		// 3. Drawing one planet

		// 4. Drawing all of the planets
		for (Planet p : allPlanets) {
			p.draw();
		}

		StdDraw.enableDoubleBuffering();

		for (double time = 0; time <= T; time += dt) {
			double[] xForces = new double[allPlanets.length];
			double[] yForces = new double[allPlanets.length];

			for (int i = 0; i < allPlanets.length; i++) {
				xForces[i] = allPlanets[i].calcNetForceExertedByX(allPlanets);
				yForces[i] = allPlanets[i].calcNetForceExertedByY(allPlanets);
			}

			for (int i = 0; i < allPlanets.length; i++) {
				allPlanets[i].update(dt, xForces[i], yForces[i]);
			}

			StdDraw.picture(0, 0, "images/starfield.jpg");

			for (Planet p : allPlanets) {
				p.draw();
			}

			StdDraw.show();
			StdDraw.pause(10);
		}

		StdOut.printf("%d\n", allPlanets.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < allPlanets.length; i++) {
    		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  allPlanets[i].xxPos, allPlanets[i].yyPos, allPlanets[i].xxVel,
                  allPlanets[i].yyVel, allPlanets[i].mass, allPlanets[i].imgFileName);   
		}
	}
}
















