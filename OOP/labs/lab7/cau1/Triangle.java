class Triangle implements Shape{
    double base;
    double height;

    public Triangle(){
        super();
    }
    public Triangle(double base, double height){
        this.height = height;
        this.base = base;
    }
   // @override 
    public double getArea(){
        return (this.height*this.base)/2;

    }
    public boolean equals(Object obj){
        if ( obj instanceof Triangle){
            Triangle temp = (Triangle) obj;
            if (temp.getArea() == this.getArea())
                return true;       
        }
        return false;
     }
    public String toString(){
        return "Triangle[" + this.base + ", " + this.height + "]";
    }

}
