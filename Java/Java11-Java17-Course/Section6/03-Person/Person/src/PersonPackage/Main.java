package PersonPackage;

public class Main {
    public static void main(String args[]){
        Person newHuman = new Person();
        newHuman.setAge(15);
        newHuman.setFirstName("Allan");
        newHuman.setLastName("Wake");

        System.out.println(newHuman.isTeen());
        System.out.println(newHuman.getFullName() + " is " +
                newHuman.getAge() + " years old.");



    }
}
