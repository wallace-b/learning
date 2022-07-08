package bradleywallace;

// object <=> class
// public = other classes that we create have got access to this class without...
// ... being restricted.
// ***
// fields = class or member variables. Can only access within the class.
// private will hide the fields and methods from public access across classes.

public class Car {
    private int doors;
    private int wheels;
    private String model;
    private String engine;
    private String color;

    // setter
    public void setModel(String model) {
        String validModel = model.toLowerCase();
        if(validModel.equals("enzo") || validModel.equals("carrera")) {
            this.model = model;
        } else {
            this.model = "Unknown";
        }
    }
    // we can assign rules. places constraints on inputs.


    // getter
    public String getModel(){
        return this.model;
    }
}