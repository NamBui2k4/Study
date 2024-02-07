class Circle {
    protected double radius;
    protected String color;

    public Circle(double radius, String color){
        this.radius = radius;
        this.color = color;

    }
    public Circle(){
        this.radius = 1.0;
        this.color = "red";
    }
    public double getRadius(){
        return this.radius;
    }
    public String getColor(){
        return this.color;
    }
    public void setRadius(double radius){
        this.radius = radius;
    }
    public void setColor(String color){
        this.color = color;
    }
    public double getArea(){
        return Math.pow(this.radius,2)*Math.PI;
    }
    public String toString(){
        return "Circle(" + this.radius + ", " + this.color + ")";
    }
    
}
