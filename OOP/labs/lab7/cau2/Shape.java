abstract class Shape{
    protected String color;
    protected boolean filled;

    public Shape(){
        this.color = "black";
        this.filled = false;
    }
    public Shape(boolean filled,String color){
        this.filled = filled;
        this.color = color;
    }
    public String getColor(){
        return this.color;
    }
    public void setColor(String color){
        this.color = color;
    }
    public boolean isFill(){
        return this.filled;
    }
    public void setFill(boolean filled){
        this.filled = filled;
    }
    public abstract double getArea();
    public abstract double getPerimeters();
    public abstract String toString();
}
