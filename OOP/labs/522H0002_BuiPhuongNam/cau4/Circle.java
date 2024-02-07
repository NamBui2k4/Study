class Circle extends Shape{
    private double radius;
    public Circle(){
        super();
        this.radius = 1.0;
    }
    public Circle(String color, boolean filled,double radius) {
        super(color,filled);
        this.radius = radius;

    }
    
    public double getRadius() {
        return this.radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getArea() {
        return Math.PI*Math.pow(radius,2);

    }
    public double getPerimeter() {
        return 2*Math.PI*radius;
    }
    @Override
    public String toString() {
        return "Circle["+ this.color + ", " + this.filled + ", " + "radius=" + radius + ']';
    }
}
