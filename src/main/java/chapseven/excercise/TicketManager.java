package chapseven.excercise;

/**
 * Created by SushmithaShamanth on 9/30/17.
 */
public class TicketManager {
    private TicketManager(){
        super();
    }

    private static TicketManager instance;

   public static synchronized  TicketManager getInstance(){ //k1
       if(instance == null)    instance = new TicketManager(); //K2
       return instance;
   }

    private int tickets;
    public int getTicketCount(){ return tickets;}
    public void makeTicketsAvailable(int value){ tickets +=value;}

    public void sellTickets(int value){
        synchronized (this) { //k4
            tickets -=value;
        }
    }

}
