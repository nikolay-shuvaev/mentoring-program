package bean;

/**
 * Created by Nikolay Shuvaev on 11.06.2017.
 */
public class CarRunnerThread extends Thread {
    private Car car;

    public CarRunnerThread(Car car) {
        super(car);
        this.car = car;
    }

    public Car getCar() {
        return car;
    }
}
