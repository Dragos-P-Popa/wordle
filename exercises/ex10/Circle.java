public class Circle{
    private double radius;

    public Circle(double r){
        this.radius = r;
    }

    public double getRadius() {
        return radius;
    }

    public double area(){
        double area = Math.PI*(this.radius*this.radius);
        return area;
    }

    public double perimeter(){
        double perimeter = 2*(Math.PI*this.radius);
        return perimeter;
    }
}