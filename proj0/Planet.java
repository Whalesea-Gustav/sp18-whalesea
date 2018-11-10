public class Planet {
	public double xxPos;
	public double yyPos;

	public double xxVel;
	public double yyVel;

	public double mass;

	public String imgFileName;

	private static double G = 6.67e-11;

	public Planet(double xP, double yP, double xV, 
				  double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;

		xxVel = xV;
		yyVel = yV;

		mass = m;
		imgFileName = img;
	}

	public Planet(Planet p) {
		this.xxPos = p.xxPos;
		this.yyPos = p.yyPos;
		this.xxVel = p.xxVel;
		this.yyVel = p.yyVel;
		this.mass = p.mass; 
		this.imgFileName = p.imgFileName;

	}
	public double calcDistance(Planet p) {

		double dx = this.xxPos - p.xxPos;
		double dy = this.yyPos - p.yyPos;

		double result = Math.sqrt(dx*dx + dy*dy);

		return result;

	}

	public double calcForceExertedBy(Planet p) {
		return (G * this.mass * p.mass
				/ Math.pow((this.calcDistance(p)), 2)); 
	} 

	public double calcForceExertedByX(Planet p) {
		return (this.calcForceExertedBy(p) * (p.xxPos - this.xxPos) 
			    / this.calcDistance(p));
	}
	public double calcForceExertedByY(Planet p) {
		return (this.calcForceExertedBy(p) * (p.yyPos - this.yyPos) 
			    / this.calcDistance(p));
	}

	public double calcNetForceExertedByX(Planet[] allPlanets) {
		double netForce = 0;

		for (Planet p : allPlanets) {

			if (this.equals(p)){

				continue;

			} else {
				netForce += this.calcForceExertedByX(p);
			}
		}

		return netForce;
	}


	public double calcNetForceExertedByY(Planet[] allPlanets) {
		double netForce = 0;

		for (Planet p : allPlanets) {

			if (this.equals(p)) {

				continue;

			} else {
				netForce += this.calcForceExertedByY(p);
			}
		}

		return netForce;
	}

	public void update(double dt, double xxForce, double yyForce) {
		double xxAccel = xxForce / this.mass;
		double yyAccel = yyForce / this.mass;

		this.xxVel += dt * xxAccel;
		this.yyVel += dt * yyAccel;
		
		this.xxPos += dt * this.xxVel;
		this.yyPos += dt * this.yyVel;

	}

	public void draw() {
		StdDraw.picture(this.xxPos, this.yyPos, "images/"+this.imgFileName);
	}
}