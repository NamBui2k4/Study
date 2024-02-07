class Square extends Rectangle{
    public Square(){
        super();
    }
    public Square(String color, boolean filled,double width, double length ,double side){
        super(color, filled, width, length);
        this.length = side;
        this.width = side;
    }
    public double getSide(){
        return this.length;
    }
    public void setSide(double side){
        this.length = side;
    }
    public void setWidth(double width){
        this.width = width;
    }
    public void setLength(double length){
        this.length = length;
    }
    public String toString() {
        return "Square[" + this.color+ ", " + this.filled + ", " + getSide() +"]" ;
    }
}
