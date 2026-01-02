import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User user = new User();
        Reservation res = new Reservation();
        Cancellation can = new Cancellation();
        int choice;
        do{
            System.out.println("\n----ONLINE RESERVATION SYSTEM----");
            System.out.println("\n1.Login");
            System.out.println("\n2.Reserve Ticket");
            System.out.println("\n3.Cancel Ticket");
            System.out.println("\n4.Exit");
            System.out.println("\nEnter your choice : ");
            choice = sc.nextInt();

            switch(choice){
                case 1:
                    System.out.println("Login Module");
                    user.login();
                    break;
                case 2:
                    System.out.println("Reservation Module");
                    res.reserveTicket(sc);
                    break;
                case 3:
                    System.out.println("Cancellation Module");
                    can.cancelTicket(sc);
                    break;
                case 4:
                    System.out.println("Thank you");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }while(choice!=4);
        sc.close();
    }
}
