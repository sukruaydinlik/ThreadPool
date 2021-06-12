
import java.util.ArrayList;
import java.util.Scanner;

interface Threadpool {
    public void MakeIDLE();
    public void MakeBusy();
}

//"ConcreteCommand"
//
class TPConverter implements Threadpool {
    // Constructor
    public TPConverter(Converter converter, char PriorityLevel, int Alloc) {
        _converter = converter;
        _PriorityLevel = PriorityLevel;
        _Alloc = Alloc;

    }

    public void MakeIDLE() {
        _converter.IDLE(_PriorityLevel, _Alloc);
    }

    public void MakeBusy() {
        _converter.BUSY(_PriorityLevel, _Alloc);
    }


    //aloow priority


    private Converter _converter;
    private char _PriorityLevel;
    private int _Alloc;

}
// "Receiver"
//
class Converter {
    public Converter() {
        current_value = 0;
        Alloc = 0;
        PriorityLevel = 0;

    }

    public void IDLE(char _PriorityLevel, int _Alloc) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6 ; j++) {
                if (j == i) {
                    System.out.println("Assign Complete ");
                        BUSY('✓',i);
                }
            }
            System.out.println("Current Alloc " + Alloc + " (Assign to  "
                    + _PriorityLevel + " Level of  " + PriorityLevel +i+ ")");
        }
    }


    public void BUSY(char _PriorityLevel, int _Alloc) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                if (j == i) {
                    System.out.println("Assign Denied");
                  //  IDLE('x',j);
                }
            }

            System.out.println("Current Alloc " + Alloc + " (Assign to  "
                    + _PriorityLevel + " Level of  " + PriorityLevel +i+ ")");
        }
    }
    private char PriorityLevel;
    private int Alloc;
    private int current_value;
}

// "Invoker"
class User {
    public User() {	Status = 0; }





    public void IDLE(int levels) {


            System.out.println("Create IDLE");

            for (int i = 0; i < levels; i++) {

                int priority = 0;
                int Alloc = _EntryTable.size();

                if (priority < 1 && Alloc < 4) {
                    Threadpool TP = null;
                    System.out.println("512 - Heavy Loads");
                    Compute(TP);
                }
                if (priority < 2 && Alloc < 3) {
                    Threadpool TP = null;
                    Compute(TP);
                }
                if (priority < 3 && Alloc < 2) {
                    Threadpool TP = null;
                    Compute(TP);
                }
                if (priority < 4 && Alloc < 1) {
                    Threadpool TP = null;
                    Compute(TP);
                }
                if (priority < 5 && Alloc < 0) {
                    Threadpool TP = null;
                    System.out.println("512 - Light Loads");
                    Compute(TP);
                }


                if (Status < _EntryTable.size()) {
                    Threadpool TP1 = _EntryTable.get(Status++);
                    TP1.MakeIDLE();
                }
            }
        }


    public void BUSY(int levels) {
    for (int i = 0; i < levels; i++) {

        int PriorityLEvel = 0;
        int Alloc = _EntryTable.size();

        System.out.println( "Create Busy");


        if (PriorityLEvel < 1 && Alloc < 4 ) {
            Threadpool TP = null;
            System.out.println("512 - Heavy Loads ");
            Compute(TP);
        }
        if (PriorityLEvel < 2 && Alloc < 3 ) {
            Threadpool TP = null;
            Compute(TP);
        }
        if (PriorityLEvel < 3 && Alloc < 2 ) {
            Threadpool TP = null;
            Compute(TP);
        }
        if (PriorityLEvel < 4 && Alloc < 1) {
            Threadpool TP = null;
            Compute(TP);
        }
        if (PriorityLEvel < 5 && Alloc < 0 ) {
            Threadpool TP = null;
            System.out.println("512 - Light Loads ");
            Compute(TP);
        }

            if (Status > 0) {
                Threadpool TP = _EntryTable.get(--Status);
                TP.MakeBusy();
            }
        if (Status > 0) {
            Threadpool TP = _EntryTable.get(Status++);
            TP.MakeIDLE();
        }
        }
    }
    void Compute(Threadpool TP) {
        TP.MakeIDLE();
        // Add command to undo list
        _EntryTable.add(TP);
        Status++;
    }

    // Initializers.
    private int Status;
    private ArrayList<Threadpool> _EntryTable = new ArrayList<Threadpool>();

};

public class CommandPattern {
    public static void main(String[] args) {

        // Create user and let her compute
        Threadpool command = null;
        User user = new User();
        Converter converter = new Converter();

        command = new TPConverter(converter, '1', 5 );
        user.Compute(command);
        command = new TPConverter(converter, '2', 4 );
        user.Compute(command);
        command = new TPConverter(converter, '3', 3 );
        user.Compute(command);
        command = new TPConverter(converter, '4', 2 );
        user.Compute(command);
        command = new TPConverter(converter, '5', 1 );
        user.Compute(command);

        // Undo 4 commands
        user.BUSY(4);
        // Redo 2 commands
        user.IDLE(2);
    }
}