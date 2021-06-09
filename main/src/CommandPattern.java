
import java.util.*;


interface  ThreadPool {
    public void IDLE();
        public void  BUSY();
}

class  TPConvert implements ThreadPool {

    public  TPConvert (Converter Converter , int  PL , int ALLoc ,String ET)
    {
        _Converter = Converter;
        _PriorityLEvel = PL;
        _Alloc = ALLoc;
        _EntryTable = ET;

    }


    public void IDLE() {
        _Converter.Convert(_PriorityLEvel,_Alloc,_EntryTable);


    }


    public void BUSY() {
        _Converter.Convert(_PriorityLEvel,_Alloc,_EntryTable);
    }

    private  int _PriorityLEvel;
    private int  _Alloc;
    private String  _EntryTable ;
    private  Converter _Converter;






}
class Converter {
    public Converter() {
        current_Status = "Empty ";
}
    public  void Convert(int  _priorityLEvel , int _Alloc,String _EntryTable){

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        String ET  = _EntryTable;
        for (int i = 0; i < N; i++) {

            int  priortyLEvel = _priorityLEvel;
            int Alloc = _Alloc;


            int HighLevelThread = 512;
            int LowLEvelThread = 256 ;
            String  HLS = Integer.toString(HighLevelThread);
            String  LLS = Integer.toString(LowLEvelThread);




            while (N >1 )
            {
                if (_Attributes.size()<Alloc) {
                    if (priortyLEvel < 1) {
                        _Attributes.add(1, "Priority Level  = 1 " + HLS);
                    } else if (priortyLEvel < 2) {
                        _Attributes.add(2, "Priority Level  = 2");
                    } else if (priortyLEvel < 3) {
                        _Attributes.add(3, "Priority Level  = 3");
                    } else if (priortyLEvel < 4) {

                        _Attributes.add(4, "Priority Level  = 4");
                    } else {
                        _Attributes.add(5, "Priority Level  = 5" + LLS);
                    }
                }
            }
        }

        System.out.println( "Entry LEvel of " + ET + " ' s  Attributes are  Convert to "+current_Status);




    }
    
    

    //private   ArrayList<ThreadPool> ThreadPoll = new ArrayList<ThreadPool>();

    private ArrayList<String> _Attributes = new ArrayList<String>();




private String current_Status;

}
//Invoker
class ThreadPoolMAker{
    public  ThreadPoolMAker() { Flag = 0;}
    public void  MakeIDLE(int Status)
    {
        for (int i = 0; i < Status; i++) {
            //DEðiþceke
            if ( i < 3){
            }

        }
        
        System.out.println( "Making the Thread IDLE ...");
    }

    public void MakeBusy(int Status)
    {
        System.out.println( "Making the Thread BUSY ...");
    }


    private ArrayList<String> _Attributes = new ArrayList<String>();
    private int Flag;
}



public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}

//ARRAY LISTE BAKILCAK 
//INVOKER YAPILCAk
