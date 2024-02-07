class SharedObject {
    private static final int SIZE = 5;
    private static int  count;

    public SharedObject() {
        this.count = 0;
    }

    public void increase(){
        count++;
    }

    public void decrease(){
        count--;
    }

    public int getCount(){
        return count;
    }
    public int getSize(){
        return SIZE;
    }
}
