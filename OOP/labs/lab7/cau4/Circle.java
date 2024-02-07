class Circle implements GeometricObject {
    protected double radius;
    public Circle() {
        this.radius = 1;
    }
    public double getArea(){
        return Math.pow(this.radius,2) * Math.PI;
    }
    public double getPerimeter(){
        return this.radius * 2 * Math.PI;
    }
    

}
