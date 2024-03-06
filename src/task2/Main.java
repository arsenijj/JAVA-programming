package task2;

public class Main {

    public void run(){
        
        StandardCapacitor cap1 = new StandardCapacitor(12.22, 14.44);
        StandardCapacitor cap2 = new StandardCapacitor(12.22, 14.44); 
        System.out.println(cap1.equals(cap2));    
        System.out.println(cap1.hashCode());
        System.out.println(cap1.compareTo(cap2));
        ElectrolyticCapacitor cap3 = new ElectrolyticCapacitor(0, 0, 0);
        ElectrolyticCapacitor cap4 = new ElectrolyticCapacitor(0, 0, 0);
    
        System.out.println(cap3.compareTo(cap4));
    
        // cap3.charge(12);
        // cap3.maximumVoltage = 13;
        // cap3.charge(12);
        // System.out.println(cap3);

    }
    public static void main(String[] args) {
    new Main().run();
    
    }
}
