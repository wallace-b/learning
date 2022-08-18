package PackageBradley;

public class BigDogFarm extends DogFarm {

    @Override
    public BigDog createDog() {
        return new BigDog();
    }
}
