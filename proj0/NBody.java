public class NBody {
	public static double readRadius(String filename) {
		In in = new In(filename);
		in.readLine(); // skip the first line
		double radiusUniverse = in.readDouble();
		return radiusUniverse;
	}

	public static Planet[] readPlanets(String filename) {
		In in = new In(filename);
		Planet[] allPlanets = new Planet[5];

		/* skip first two lines */
		in.readLine();
		in.readLine();

		for (int i = 0; i < 5; i++) {
			double xP = in.readDouble();
			double yP = in.readDouble();
			double xV = in.readDouble();
			double yV = in.readDouble();
			double mass = in.readDouble();
			String image = in.readString();
			allPlanets[i] = new Planet(xP, yP, xV, yV, mass, image);
		}
		return allPlanets;
	}
}