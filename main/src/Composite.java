import java.util.ArrayList;
import java.util.List;


// A common interface for all employee
interface HospitalStaff
{
    void showEmployeeDetails();
}

class Doctor implements HospitalStaff
{
    private String name;
    private long empId;
    private String StudyField;

    public Doctor(long empId, String name, String position)
    {
        this.empId = empId;
        this.name = name;
        this.StudyField = position;
    }

    @Override
    public void showEmployeeDetails()
    {
        System.out.println(empId+" " +name+ " " + StudyField);
    }
}

class Nurse implements HospitalStaff
{
    private String name;
    private long empId;
    private String Department;

    public Nurse(long empId, String name, String position)
    {
        this.empId = empId;
        this.name = name;
        this.Department = position;
    }

    @Override
    public void showEmployeeDetails()
    {
        System.out.println(empId+" " +name+ " " + Department);
    }
}

class Cleaner implements HospitalStaff
{
    private String name;
    private long empId;
    private String Department;

    public Cleaner(long empId, String name, String position)
    {
        this.empId = empId;
        this.name = name;
        this.Department = position;
    }

    @Override
    public void showEmployeeDetails()
    {
        System.out.println(empId+" " +name+ " " + Department);
    }
}

class HospitalDirectory implements HospitalStaff
{
    private List<HospitalStaff> employeeList = new ArrayList<HospitalStaff>();

    @Override
    public void showEmployeeDetails()
    {
        for(HospitalStaff emp:employeeList)
        {
            emp.showEmployeeDetails();
        }
    }

    public void addEmployee(HospitalStaff emp)
    {
        employeeList.add(emp);
    }

    public void removeEmployee(HospitalStaff emp)
    {
        employeeList.remove(emp);
    }
}

class Hospital
{
    public static void main (String[] args)
    {
        Doctor doc1 = new Doctor(100, "Lokesh Sharma", "Cardiology");
        Doctor doc2 = new Doctor(101, "Vinay Sharma", "Neurology");
        HospitalDirectory engDirectory = new HospitalDirectory();
        engDirectory.addEmployee(doc1);
        engDirectory.addEmployee(doc2);

        Nurse nurse1 = new Nurse(200, "Kushagra Garg", "Neurology");
        Nurse nurse2 = new Nurse(201, "Vikram Sharma ", "Cardiology");

        HospitalDirectory accDirectory = new HospitalDirectory();
        accDirectory.addEmployee(nurse1);
        accDirectory.addEmployee(nurse2);

        Cleaner clean1 = new Cleaner(300,"Hakan Emre","MR Clean");
        Cleaner clean2 = new Cleaner(301,"Şükrü", "Cleaner");

        HospitalDirectory clDirectory = new HospitalDirectory();
        clDirectory.addEmployee(clean1);
        clDirectory.addEmployee(clean2);

        HospitalDirectory directory = new HospitalDirectory();
        directory.addEmployee(engDirectory);
        directory.addEmployee(accDirectory);
        directory.addEmployee(clDirectory);
        directory.showEmployeeDetails();
    }
}
