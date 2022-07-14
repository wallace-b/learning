package PersonPackage;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getAge() {
        return this.age;
    }

    public void setFirstName(String nameFirst) {
        this.firstName = nameFirst;
    }

    public void setLastName(String nameLast) {
        this.lastName = nameLast;
    }

    public void setAge(int ageIn) {
        if (ageIn < 0 || ageIn > 100) {
            this.age = 0;
        } else {
            this.age = ageIn;
        }
    }

    public boolean isTeen() {
        if (age > 12 && age < 20) {
            return true;
        } else {
            return false;
        }
    }

    public String getFullName() {
        if (firstName.isEmpty() && lastName.isEmpty()) {
            return "";
        } else if (firstName.isEmpty()) {
            return lastName;
        } else if (lastName.isEmpty()) {
            return firstName;
        } else {
            return firstName + " " + lastName;
        }

    }

}
