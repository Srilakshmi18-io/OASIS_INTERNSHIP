import java.util.Scanner;
public class Reservation {
    void reserveTicket(Scanner sc){
        System.out.println("Enter Name:");
        String name = sc.nextLine();
        System.out.println("Train number:");
        int train = sc.nextInt();
        System.out.println("From:");
        String from = sc.nextLine();
        System.out.println("To:");
        String to = sc.nextLine();
        System.out.println("Ticket Reserved successfully");
        System.out.println("PNR: "+(int)(Math.random()*10000));
        System.out.println("Name : "+name);
        System.out.println("Train no: "+train);
        System.out.println("Route: "+from+" to"+to);
    }
}
