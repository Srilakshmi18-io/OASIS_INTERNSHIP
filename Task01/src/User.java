import java.util.Scanner;
public class User {
    String un = "admin";
    String pw = "1234";
    void login(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username :");
        String u = sc.next();
        System.out.println("Enter password :");
        String p = sc.next();
        if(u.equals(un)&& p.equals(pw)){
            System.out.println("Login successful");
        }
        else{
            System.out.println("Invalid Login");
        }
        sc.close();
    }
}
