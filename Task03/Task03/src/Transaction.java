import java.util.ArrayList;
public class Transaction {
    private ArrayList<String> history = new ArrayList<>();

    public void addtransaction(String transaction){
        history.add(transaction);
    }

    public void showhistory(){
        if(history.isEmpty()){
            System.out.println("No transaction yet");
        }
        else{
            System.out.println("---Transaction History---");
            for(String t: history){
                System.out.println(t);
            }
        }
    }
}
