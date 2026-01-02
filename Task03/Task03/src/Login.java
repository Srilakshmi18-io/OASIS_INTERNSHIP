import java.util.Scanner;

public class Login{
    public boolean authenticate(Useraccount user) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter user id: ");
        String uid = sc.next();

        System.out.println("Enter PIN:");
        String pin = sc.next();

        if(uid.equals(user.getuserid()) && pin.equals(user.getpin())){
            System.out.println("Login successful");
            return true;
        }
        else{
            System.out.println("Invalid userid or pin");
            return false;
        }
    }
}