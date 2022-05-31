public class Planet {
    public double xxPos; // Its current x position
    public double yyPos; // Its current y position
    public double xxVel; // Its current velocity in the x direction
    public double yyVel; // Its current velocity in the y direction
    public double mass; // Its mass
    public String imgFileName; // the name of the file tha corresponds to the image that depicts the body.

    public static final double G = 6.67e-11;

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
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
        return Math.sqrt(Math.pow((p.xxPos - this.xxPos), 2) + Math.pow((p.yyPos - this.yyPos), 2));
    }

    public double calcForceExertedBy(Planet p) {
        if (this.equals(p)) {
            return 0;
        }
        return G * this.mass * p.mass / Math.pow(this.calcDistance(p), 2);
    }

    public double calcForceExertedByX(Planet p) {
        if (this.equals(p)) {
            return 0;
        }
        return this.calcForceExertedBy(p) * (p.xxPos - this.xxPos) / this.calcDistance(p);
    }

    public double calcForceExertedByY(Planet p) {
        if (this.equals(p)) {
            return 0;
        }
        return this.calcForceExertedBy(p) * (p.yyPos - this.yyPos) / this.calcDistance(p);
    }

    public double calcNetForceExertedByX(Planet[] planets) {
        double sumNetForceExertedByX = 0;
        for (Planet p : planets) {
            sumNetForceExertedByX += this.calcForceExertedByX(p);
        }
        return sumNetForceExertedByX;
    }

    public double calcNetForceExertedByY(Planet[] planets) {
        double sumNetForceExertedByY = 0;
        for (Planet p : planets) {
            sumNetForceExertedByY += this.calcForceExertedByY(p);
        }
        return sumNetForceExertedByY;
    }

    public void update(double dt, double fx, double fy){
        double ax = fx/this.mass;
        double ay = fy/this.mass;

        // better calculation for position
        // this.xxPos += this.xxVel*dt+0.5*ax*dt*dt;
        // this.yyPos += this.yyVel*dt+0.5*ay*dt*dt;

        this.xxVel += ax * dt;
        this.yyVel += ay * dt;

        this.xxPos += this.xxVel * dt;
        this.yyPos += this.yyVel * dt;
    }

    public void draw(){
        StdDraw.picture(this.xxPos, this.yyPos, "./images/"+this.imgFileName);
    }
}
