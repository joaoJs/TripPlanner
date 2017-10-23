import java.util.Scanner;
public class TripPlanner {
    public static void main(String[] args) {
        Greeting();
        TimeAndMoney();
        TimeDifference();
        Distance();
        HackerProblem();
    }

    public static void Greeting() {
        System.out.println("Welcome to Trip Planner!");
        System.out.print("May I have your name? ");
        Scanner input = new Scanner(System.in);
        String name = input.next();
        System.out.print("Hi " + name + "! What is your destination? ");
        Scanner dest = new Scanner(System.in);
        String destination = dest.next();
        System.out.println(destination + " sounds great!");
    }

    public static void TimeAndMoney() {
        System.out.print("How many days are you going to spend there? ");
        Scanner dur = new Scanner(System.in);
        int time = dur.nextInt();
        System.out.print("What is the total budget for the trip? ");
        Scanner budg = new Scanner(System.in);
        int money = budg.nextInt();
        System.out.print("What is the currency used there? ");
        Scanner curr = new Scanner(System.in);
        String currency = curr.next();
        System.out.print("How many " + currency + " are there in 1 USD? ");
        Scanner rateInp = new Scanner(System.in);
        double rate = rateInp.nextDouble();

        System.out.println("You are going to spend "+ time + " days (or " + time * 24 + " hours) at your destination.");
        double usdPerDay = money / time;
        System.out.println("Your total budget for the trip in USD is " + money + " USD. And you can spend " + usdPerDay + " USD per day.");
        double perDay = money * rate / time;
        System.out.println("Your total budget for the trip in " + currency + " is " + money * rate + ". And you can spend " + perDay + " " +currency+" per day.");
    }

    public static void TimeDifference() {
        System.out.print("What is the time difference between here and your destination? ");
        Scanner diff = new Scanner(System.in);
        int difference = diff.nextInt();
        System.out.println("When is 0:00 here, it will be " + (0 + difference) + ":00 at your destination. And when is 12:00 here it will be " + (12 + difference) + ":00 at your destination.");
    }

    public static void Distance() {
        System.out.print("What the area of the country of your destination in km2? ");
        Scanner areaInp = new Scanner(System.in);
        double area = areaInp.nextDouble();
        double areaInM = area * 0.386102;
        double one = areaInM * 100;
        int answerFromOne = (int)one;
        double answerFromTwo = (answerFromOne / 100.0);
        System.out.println("Total area in km2 is " + area + ", and " + answerFromTwo + "in squared miles");
    }

    public static void HackerProblem() {
        int EARTH_RADIUS = 6371;

        System.out.print("startLat: ");
        Scanner latInp = new Scanner(System.in);
        double startLat = latInp.nextDouble();

        System.out.print("startLong: ");
        Scanner longInp = new Scanner(System.in);
        double startLong = longInp.nextDouble();

        System.out.print("endLat: ");
        Scanner latDestInp = new Scanner(System.in);
        double endLat = latDestInp.nextDouble();

        System.out.print("endLong: ");
        Scanner longDestInp = new Scanner(System.in);
        double endLong = longDestInp.nextDouble();

        double dLat  = Math.toRadians((endLat - startLat));
        double dLong = Math.toRadians((endLong - startLong));

        startLat = Math.toRadians(startLat);
        endLat   = Math.toRadians(endLat);

        double a = haversin(dLat) + Math.cos(startLat) * Math.cos(endLat) * haversin(dLong);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        double distance =  EARTH_RADIUS * c; // <-- d
        double distanceM = distance * 0.621371;

        int finDist = (int)(distance * 100);
        double finDistD = finDist / 100.0;

        int finDistM = (int)(distanceM * 100);
        double finDistMD = finDistM / 100.0;

        System.out.println("The distance from your house to your destination is " +finDistD + " km or " + finDistMD + " miles");
    }

    public static double haversin(double val) {
        return Math.pow(Math.sin(val / 2), 2);
    }
}
