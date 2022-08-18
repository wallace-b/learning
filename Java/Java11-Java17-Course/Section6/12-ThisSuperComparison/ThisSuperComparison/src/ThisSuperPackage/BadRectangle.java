package ThisSuperPackage;

// poor use of this.X
// duplicated code

public class BadRectangle {
    private int x;
    private int y;
    private int width;
    private int height;

    public BadRectangle() {
        this.x = 0;
        this.y = 0;
        this.width = 0;
        this.height = 0;
    }

    public BadRectangle(int width, int height) {
        this.x = 0;
        this.y = 0;
        this.width = width;
        this.height = height;
    }

    public BadRectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y  = y;
        this.width = width;
        this.height = height;
    }
}
