// Core Java Program - OOPS
public class HelloWorld{

     public static void main(String []args){
        System.out.println("Hello, World!");
        Car c = new Car();
        //Bike b = new Bike();
        //System.out.println(c.getEngine()+" "+c.getColor());
        //System.out.println(c.getColor("blue"));
        String str = c.getColor();
        vehicle v = new vehicle();
        str = v.getColor();
        vehicle vv = new Car();
        str = vv.getColor();
     }
}

class vehicle{
    String engine;
    protected String getEngine(){
         return "Engine..";
     }
     
     protected String getColor(){
         System.out.println("Vehicle color: ");
         return "Vehicle";
     }
    
}

class Car extends vehicle{
    String color;
     public String getColor(){
         System.out.println("Car color: ");
         this.color = "red";
         return color;
     }
     
     public String getColor(String color){
         System.out.println("here: "+color);
         return color;
     }
     
     public int getColor(String color, int num){
         System.out.println("here1: "+color+" "+num);
         return 2;
     }
     
     public String setColor(){
        this.color = "blue";
        return this.getColor();
     }
}

class Bike{
    int numOfWheels;
    public int numOfWheels(){
        return 2;
    }
}