package IteratorPattern;

public class Demo {
    public static void main(String[] args) {
        PatientNameRepo pNamesRepository = new PatientNameRepo();

        for(Iterator iterator = pNamesRepository.getIterator(); iterator.hasNext();){
            String name = (String)iterator.next();
            System.out.println("Name : " + name);
        }
    }
}
