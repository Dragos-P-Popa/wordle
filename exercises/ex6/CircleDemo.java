public class CircleDemo {

    public static void main(String[] args){
        Circle circle = new Circle(4.5);
        System.out.println("Radius    = " +circle.getRadius());
        System.out.println("Perimeter    = " +circle.perimeter());
        System.out.println("Area    = " +circle.area());
    }
}