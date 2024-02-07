public class RegularPolygon {
    private String name;
    private int edgeAmount;
    private double edgeLength;

    public RegularPolygon() {
        this("", 3, 1);
    }

    public RegularPolygon(String name, int edgeAmount, double edgeLength) {
        this.name = name;
        this.edgeAmount = edgeAmount;
        this.edgeLength = edgeLength;
    }

    public RegularPolygon(String name, int edgeAmount) {
        this(name, edgeAmount, 1);
    }

    public RegularPolygon(RegularPolygon polygon) {
        this.name = polygon.name;
        this.edgeAmount = polygon.edgeAmount;
        this.edgeLength = polygon.edgeLength;
    }

    public String getName() {
        return name;
    }

    public int getEdgeAmount() {
        return edgeAmount;
    }

    public double getEdgeLength() {
        return edgeLength;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEdgeAmount(int num) {
        this.edgeAmount = num;
    }

    public void setEdgeLength(double length) {
        this.edgeLength = length;
    }

    public String getPolygon() {
        switch (edgeAmount) {
            case 3:
                return "Triangle";
            case 4:
                return "Quadrangle";
            case 5:
                return "Pentagon";
            case 6:
                return "Hexagon";
            default:
                return "Polygon has the number of edges greater than 6";
        }
    }

    public double getPerimeter() {
        return edgeLength * edgeAmount;
    }

    public double getArea() {
        if (edgeAmount < 3 || edgeAmount > 6) {
            return -1;
        }
        double apothem = 0.5 * edgeLength / Math.tan(Math.PI / edgeAmount);
        return 0.5 * edgeAmount * edgeLength * apothem;
    }

    @Override
    public String toString() {
        return name + " - " + getPolygon() + " - " + getArea();
    }
}