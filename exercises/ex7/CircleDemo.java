public class CircleDemo {

    public static void main(String[] args){
        Circle circle = new Circle(4.0);
        System.out.println("Radius    = " +circle.getRadius());
        System.out.println("Perimeter    = " +circle.perimeter());
        System.out.println("Area    = " +circle.area());

        System.out.println(circle.toString());
        System.out.println(circle.equals(1.0, 1.00003));
    }
}