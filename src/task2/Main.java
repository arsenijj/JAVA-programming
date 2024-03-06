package task2;

import java.util.ArrayList;

public class Main {

    public void run() {

        // StandardCapacitor
        StandardCapacitor standardCapacitor1 = new StandardCapacitor(12.22, 14.44);
        StandardCapacitor standardCapacitor2 = new StandardCapacitor(12.22, 14.44);

        System.out.println(standardCapacitor1);
        System.out.println(standardCapacitor2);

        System.out.println("SC1 equals SC2: " + standardCapacitor1.equals(standardCapacitor2));

        System.out.println("SC1 hashCode = " + standardCapacitor1.hashCode());
        System.out.println("SC2 hashCode = " + standardCapacitor2.hashCode());

        System.out.println("Compared SC1 & SC2: " + standardCapacitor1.compareTo(standardCapacitor2));

        standardCapacitor2.voltage = 13;
        System.out.println("Compared SC1 & SC2: " + standardCapacitor1.compareTo(standardCapacitor2));
        standardCapacitor2.voltage = 15;
        System.out.println("Compared SC1 & SC2: " + standardCapacitor1.compareTo(standardCapacitor2));

        System.out.println(standardCapacitor1.getNameOfComponent());
        System.out.println(standardCapacitor2.getNameOfComponent());

        StandardCapacitor standardCapacitor1ShallowCopy = standardCapacitor1.shallowCopy();
        StandardCapacitor standardCapacitor1DeepCopy = standardCapacitor1.deepCopy();

        standardCapacitor1.charge(12);
        standardCapacitor1.changeCapatiance(4);
        System.out.println(standardCapacitor1);

        standardCapacitor1.discharge();
        System.out.println(standardCapacitor1);

        // ElectrolyticCapacitor
        ElectrolyticCapacitor electrolyticCapacitor1 = new ElectrolyticCapacitor(12.22, 14.44, 20);
        ElectrolyticCapacitor electrolyticCapacitor2 = new ElectrolyticCapacitor(12.22, 14.44, 20);

        System.out.println(electrolyticCapacitor1);
        System.out.println(electrolyticCapacitor2);

        System.out.println("SC1 equals SC2: " + electrolyticCapacitor1.equals(electrolyticCapacitor2));

        System.out.println("SC1 hashCode = " + electrolyticCapacitor1.hashCode());
        System.out.println("SC2 hashCode = " + electrolyticCapacitor2.hashCode());

        System.out.println("Compared SC1 & SC2: " + standardCapacitor1.compareTo(electrolyticCapacitor2));

        electrolyticCapacitor2.voltage = 13;
        System.out.println("Compared SC1 & SC2: " + electrolyticCapacitor1.compareTo(electrolyticCapacitor2));
        electrolyticCapacitor2.voltage = 15;
        System.out.println("Compared SC1 & SC2: " + electrolyticCapacitor1.compareTo(electrolyticCapacitor2));

        System.out.println(standardCapacitor1.getNameOfComponent());
        System.out.println(standardCapacitor2.getNameOfComponent());

        ElectrolyticCapacitor electrolyticCapacitor1ShallowCopy = electrolyticCapacitor1.shallowCopy();
        ElectrolyticCapacitor electrolyticCapacitor1DeepCopy = electrolyticCapacitor1.deepCopy();

        electrolyticCapacitor1DeepCopy.charge(12);
        electrolyticCapacitor1DeepCopy.changeCapatiance(4);
        System.out.println(standardCapacitor1);

        electrolyticCapacitor1DeepCopy.discharge();
        System.out.println(electrolyticCapacitor1DeepCopy);

        ArrayList<Capacitor> a = new ArrayList<Capacitor>();
        a.add(standardCapacitor1);
        a.add(standardCapacitor2);
        a.add(standardCapacitor1DeepCopy);
        // a.add(standardCapacitor1ShallowCopy);
        a.add(electrolyticCapacitor1);
        a.add(electrolyticCapacitor2);
        a.add(electrolyticCapacitor1DeepCopy);
        // a.add(electrolyticCapacitor1ShallowCopy);
        for (Capacitor cap : a) {
            System.out.println(cap.getEnergy());
        }
    }

    public static void main(String[] args) {
        new Main().run();

    }
}
