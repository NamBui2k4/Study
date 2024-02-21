import java.util.Objects;

class Domino {
    private int left;
    private int right;
    Domino(int left, int right) {
        this.left = left;
        this.right = right;
    }
    // Donmino a = new Domino(1,2);
    int getLeft() {
        return this.left;
    }

    int getRight() {
        return this.right;
    }


    @Override
    public boolean equals(Object o) {
        Domino otherDomino = (Domino) o;
        return (this.getLeft() == otherDomino.getLeft() && this.getRight() == otherDomino.getRight()) ||
                (this.getLeft() == otherDomino.getRight() && this.getRight() == otherDomino.getLeft());
        // ab == ab  || ab == ba
    }
    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
    @Override
    public String toString(){
        return "domino:" +(left + "," + right);
    }
}