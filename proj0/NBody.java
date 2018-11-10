public class NBody {
	public static double readRadius(String path) {
		In in = new In(path);
		int N = in.readInt();
		double R = in.readDouble();
		return R;
	}
	/** read the number of planets in file */
	public static int readNumber(String path) {
		In in = new In(path);

		return in.readInt();
	}

	public static Planet[] readPlanets(String path) {
		In in = new In(path);
		int N = in.readInt();
		double R = in.readDouble();

		Planet[] result = new Planet[N];

		int counter = 0;

		while (counter < N) {
			double xP = in.readDouble();
			double yP = in.readDouble();
			double xV = in.readDouble();
			double yV = in.readDouble();
			double m = in.readDouble();
			String img = in.readString();

			result[counter] = new Planet(xP, yP, xV, yV, m, img);
			counter++;
		}
		return result;

	}



	public static void main(String args[]) {
		StdDraw.enableDoubleBuffering();

		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];

		Planet[] allPlanets = NBody.readPlanets(filename);
		double universRadius = NBody.readRadius(filename);

		StdDraw.setXscale(-universRadius, universRadius);
		StdDraw.setYscale(-universRadius, universRadius);

		StdDraw.picture(0, 0, "images/starfield.jpg");


		for (Planet p : allPlanets) {
			p.draw();
		}


		/** animation */
		double currentT = 0;
		int N = NBody.readNumber(filename);



		for (;currentT <= T; currentT += dt) {

			double[] xForce = new double[N];
			double[] yForce = new double[N];

			for (int index=0; index < N; index++) {
				xForce[index] = allPlanets[index].calcNetForceExertedByX(allPlanets);
				yForce[index] = allPlanets[index].calcNetForceExertedByY(allPlanets);
			}

			StdDraw.picture(0, 0, "images/starfield.jpg");


			for (int index=0; index < N; index++) {
				allPlanets[index].update(dt, xForce[index], yForce[index]);
				allPlanets[index].draw();
			}

			StdDraw.show();
			StdDraw.pause(10);
				
		}

		StdOut.printf("%d\n", N);
		StdOut.printf("%.2e\n", universRadius);

		for (int i = 0; i < N; i++) {
    		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  			allPlanets[i].xxPos, allPlanets[i].yyPos, allPlanets[i].xxVel,
                            allPlanets[i].yyVel, allPlanets[i].mass, allPlanets[i].imgFileName);   
		}
	}
}