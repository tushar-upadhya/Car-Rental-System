import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 

class Car{
    private String CarId;
    private String brand;
    private String model;
    private double basePricePerDay;
    private boolean isAvailable;


    public Car(String CarId, String brand, String model, double basePricePerDay){
        this.CarId = CarId;
        this.brand = brand;
        this.model = model;
        this.basePricePerDay = basePricePerDay;
        this.isAvailable = true;
    }

    public String getCardId(){
        return CarId;
    }

    public String getBrand(){
        return brand;
    }

    public String getModel(){
        return model;
    }

    public double calculatePrice(int rentalDays){
        return basePricePerDay * rentalDays;
    }

    public boolean isAvailable(){
        return isAvailable;
    }

    public void rent(){
        isAvailable = false;
    }

    public void returnCar(){
        isAvailable = true;
    }
}

class Customer{
    private String customerId;
    private String name;

    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }
}

class Rental{
    private Car car;
    private Customer customer;
    private int days;

    public Rental(Car car, Customer customer, int days){
        this.car = car;
        this.customer = customer;
        this.days = days;
    }

    public Car getCar(){
        return car;
    }

    public Customer getCustomer(){
        return customer;
    }

    public int getDays(){
        return days;
    }
}


class CarRentalSystem{
    private List<Car>cars;
    private List<Customer>customers;
    private List<Rental>rental;

    public CarRentalSystem(){
        cars = new ArrayList<>();
        customers = new ArrayList<>();
        rental = new ArrayList<>();

    }

    public void addCar(Car car){
        cars.add(car);
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    public void rentCar(Car car, Customer customer, int days){
        if(car.isAvailable()){
            car.rent();
            rental.add(new Rental(car, customer, days));
        }else{
            System.out.println("Car not available");
        }
    }

    public void returnCar(Car car){
        car.returnCar();
        Rental rentalToRemove = null;

        for(Rental rental : rental){
            if(rental.getCar() == car){
                rentalToRemove = rental;
                break;
            }
        }

        if(rentalToRemove != null){
            rental.remove(rentalToRemove);
        }else{
            System.err.println("Car was not Rented");
        }
    }


    public void menu(){
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("===== Car Rental System =====");
            System.out.println("1. Rent a Car");
            System.out.println("2. Return a Car");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if(choice == 1){
                System.out.println("\n== Rent c Car ==/n");
                System.out.println("Enter your name: ");
                String customerName = sc.nextLine();

                System.out.println("/n Available Cars: ");
                for(Car car : cars){
                    if(car.isAvailable()){
                        System.err.println(car.getCardId() + " - " + car.getBrand() + " " + car.getModel());
                    }
                }
                System.out.print("\nEnter the car ID you want to rent: ");
                String carId = sc.nextLine();

                System.out.print("Enter the number of days for rental: ");
                int rentalDays = sc.nextInt();
                sc.nextLine();
            }
        }

    }

}

public class Main{
    public static void main(String[] args) {
        
    }
}