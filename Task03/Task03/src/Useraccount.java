public class Useraccount{
    private String pin;
    private String userid;
    private double balance;

    public Useraccount(String userid,String pin,double balance){
        this.userid = userid;
        this.pin = pin;
        this.balance = balance;
    }

    public String getuserid(){
        return userid;
    }

    public String getpin(){
        retrun pin;
    }

    public double getbalance(){
        retrun balance;
    }

    public void setbalance(double balance){
        this.balance = balance;
    }
}
