package ThisSuperPackage;

public class Triangle extends Shape{
    private int width;
    private int height;

    // 1st constructor
    public Triangle(int x, int y) {
        this(x, y, 1, 1); // default width, height = 1, calls 2nd constructor
    }

    // 2nd constructor
    public Triangle(int x, int y, int width, int height) {
        super(x, y); // calls constructor form parent (Shape), initializes x,y
        this.width = width; // initializes width, height
        this.height = height;
    }

}
