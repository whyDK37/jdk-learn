package mapstruct;

public class Car {
 
    private String make;
    private int numberOfSeats;
    private CarType type;
 
    //constructor, getters, setters etc.
    public Car(){
    }

    public Car(String make,int numberOfSeats,CarType type){
        this.make=make;
        this.numberOfSeats = numberOfSeats;
        this.type = type;
    }
}