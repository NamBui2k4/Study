class Point {
    protected double x;
    protected double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void distance(){

    }
    public double Distance(){
        return Math.sqrt(Math.pow(this.x,2) + Math.pow(this.y,2));
    }
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

}
