import java.util.Scanner;

public class Cancellation {
    void cancelTicket(Scanner sc){
        System.out.println("Enter PNR number: ");
        int pnr = sc.nextInt();
        System.out.println("Ticket with PNR "+pnr+" is cancelled");
        sc.close();
    }
}
