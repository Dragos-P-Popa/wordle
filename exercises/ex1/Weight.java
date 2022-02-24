import java.util.Scanner;

class Weight{

    public void Weight(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter weight in kilograms: ");
        double kgWeight = scanner.nextDouble();

        double poundsDouble = kgWeight * 2.20462;
        int pounds = (int) poundsDouble;
        double ounces = (poundsDouble-pounds)*16;
        System.out.printf("Equivalent imperial weight is "+ pounds +" lb %0.1f oz", ounces);
    }

}