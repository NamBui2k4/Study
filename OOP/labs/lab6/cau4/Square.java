class Square extends Rectangle{
    public Square(){
        super();
    }
    public Square(String color, boolean filled,double width, double length,double side){
        super( color, filled, width, length);
        this.length = side;
        this.width = side;
    }
    public double getSide(){
        return this.length;
    }
    public void setSide(double side){
        this.length = this.width =  side;
    }
    public void setWidth(double width){
        setSide(width);
    }
    public void setLength(double length){
        setSide(length);
    }
    public String toString() {
        return "Square[" + getSide()+ ", " + getSide() +"]" ;
    }
}
