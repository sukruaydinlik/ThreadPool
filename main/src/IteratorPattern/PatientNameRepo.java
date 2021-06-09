package IteratorPattern;

public class PatientNameRepo implements Container {
    public String pnames[] = {"Patient1:Zeynep" , "Patient2:Hakan" ,"Patient3:Berk" , "Patient4:Şükrü"};

    @Override
    public Iterator getIterator() {

        return new NameIterator();
    }

    private class NameIterator implements Iterator {

        int index;

        @Override
        public boolean hasNext() {

            if(index < pnames.length){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {

            if(this.hasNext()){
                return pnames[index++];
            }
            return null;
        }
    }
}
