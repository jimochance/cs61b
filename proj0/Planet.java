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
}