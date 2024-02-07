class Circle extends Shape{
    private double radius;

    public Circle(){
        super();
    }
    public Circle(boolean filled,String color,double radius){
        super(filled,color);
        this.radius = radius;
    }
    public double getRadius(){
        return this.radius;
    }
    public void setRadius(double radius){
        this.radius = radius;
    }
    //@override
    public double getArea(){
        return Math.pow(this.radius,2)*Math.PI;
    }
    public double getPerimeters(){
        return this.radius*2*Math.PI;
    }
    public String toString(){
        return "Circle["+ this.radius + ","+ this.color + "]";
    }

}