public class Planet {
	public double xxPos = 1.0;
	public double yyPos = 2.0;
	public double xxVel = 3.0;
	public double yyVel = 4.0;
	public double mass = 5.0;
	public String imgFileName = "jupiter.gif";
	public static double gravitionalConstant = 6.67e-11;

	public Planet(Planet p) {
		
	}

	public Planet(double xP, double yP, double xV, double yV, double m, String img) {
		this.xxPos = xP;
		this.yyPos = yP;
		this.xxVel = xV;
		this.yyVel = yV;
		this.mass = m;
		this.imgFileName = img;
	}

	public double calcDistance(Planet p) {
		return Math.sqrt((this.xxPos - p.xxPos) * (this.xxPos - p.xxPos) + (this.yyPos - p.yyPos) * (this.yyPos - p.yyPos));
	}

	public double calcForceExertedBy(Planet p) {
		double distance = this.calcDistance(p);
		return (gravitionalConstant * this.mass	* p.mass) / (distance * distance);
	}

	public double calcForceExertedByX(Planet p) {
		double netForce = this.calcForceExertedBy(p);
		double xDistance =  p.xxPos - this.xxPos;
		return (netForce * xDistance) / this.calcDistance(p);
	}

	public double calcForceExertedByY(Planet p) {
		double netForce = this.calcForceExertedBy(p);
		double yDistance = p.yyPos - this.yyPos;
		return (netForce * yDistance) / this.calcDistance(p);
	}

	public double calcNetForceExertedByX(Planet[] allPlanets) {
		double netForceX = 0.0;
		for (int i = 0; i < allPlanets.length; i++) {
			if (allPlanets[i].equals(this)) {
				continue;
			} else {
				netForceX += this.calcForceExertedByX(allPlanets[i]);
			}
		}
		return netForceX;
	}

	public double calcNetForceExertedByY(Planet[] allPlanets) {
		double netForceY = 0.0;
		for (int i = 0; i < allPlanets.length; i++) {
			if (allPlanets[i].equals(this)) {
				continue;
			} else {
				netForceY += this.calcForceExertedByY(allPlanets[i]);
			}
		}
		return netForceY;
	}

	public void update(double dt, double fX, double fY) {
		// 1. calculate the acceleration using the provided x and y forces
		double acceX = fX / this.mass;
		double acceY = fY / this.mass;

		// 2. calculate the new velocity by using the acceleration and current velocity
		this.xxVel = this.xxVel + dt * acceX;
		this.yyVel = this.yyVel + dt * acceY;

		// 3. calculate the new position by using the velocity computed in step 2 and the current
	    //    position
	    this.xxPos = this.xxPos + dt * this.xxVel;
	    this.yyPos = this.yyPos + dt * this.yyVel;
	}
}

























