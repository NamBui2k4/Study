class Rectangle extends Shape{
    private double length;
    private double width;
    public Rectangle(){
        this.length = 0.0;
        this.width = 0.0;
    }
   
    public Rectangle(double length, double width){
        this.length = length;
        this.width = width;
    }
    public double getWidth(){
        return this.width;
    }
    public double getLength(){
        return this.length;
    }
    public double getArea(){
        return this.length*this.width;
    }
    public double getPerimeters(){
        return (this.width + this.length)*2;
    }
    public String toString(){
        return "Rectangle[" + this.length + "," + this.width  + "]";

    }

}
