import java.text.DecimalFormat;

public class Circle{
    private double radius;

    public Circle(){
        this.radius = 1.0;
    }

    public Circle(double r){
        if(r <= 0){
            throw new IllegalArgumentException("Invalid radius");
        }
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

    //"Circle(radius=1.0000)"
    public String toString(){
        DecimalFormat decimalFormat = new DecimalFormat("##.0000");
        String ret = "Circle(radius="+decimalFormat.format(getRadius())+")";
        return ret;
    }

    public boolean equals(double in1, double in2) {
        if (in1 >= in2){
            if (in1 - in2 <= 0.0005) {
                return true;
            }
            else{ return false; }
        }
        if (in1 <= in2){
            if (in2 - in1 <= 0.0005) {
                return true;
            }
            else{ return false; }
        }
        return false;
    }
}