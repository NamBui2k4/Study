class MovableCircle implements Movable {
    private int radius;
    private MovablePoint center;

    public MovableCircle(int radius, int x, int y, int xSpeed, int ySpeed){
        this.center = new MovablePoint(x,y,xSpeed,ySpeed);
        this.radius = radius;
    }
    public String toString(){
        return "MovableCircle[" + center.x + "," + center.y + ", " + this.radius 
        + ", " + this.center.xSpeed + "," + this.center.ySpeed + "]" ;
    }
    
    @Override
    public void moveUp(){
       this.center.moveUp();
    }
    public void moveDown(){
        this.center.moveDown();
    }
    public void moveLeft(){
        this.center.moveLeft();
    }
    public void moveRight(){
        this.center.moveRight();
    }

}
