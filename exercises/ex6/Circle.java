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
        String ret = "Circle(radius=)";
        return ret;
    }

    public boolean equals(double in1, double in2) {
        if (in1 >= in2 + 0.00005 && in1 <= in2 - 0.00005) {
            return true;
        }
        else{
            return false;
        }
    }
}