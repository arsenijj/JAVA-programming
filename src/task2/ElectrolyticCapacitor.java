package task2;

import java.util.Objects;

public class ElectrolyticCapacitor extends StandardCapacitor implements Capacitor{

    public double maximumVoltage;

    public ElectrolyticCapacitor(double capacitance, double voltage, double maximumVoltage) {
        super(capacitance, voltage);
        this.maximumVoltage = maximumVoltage;
    }

    @Override
    public void charge(double voltage) {
        if (voltage > this.maximumVoltage) {
            System.out.println(String.format(
                    "Warning! ElectrolyticCapacitor via maxVoltage = %f couldn't be charged for %f volts.",
                    this.maximumVoltage, voltage));
        }
        this.voltage = voltage;
    }

    @Override
    public String toString() {
        return String.format("Capacitor via notation = %s, voltage = %f and maximumVoltage = %f", this.notation,
                this.voltage, this.maximumVoltage);
    }

    public double getEnergy() {
        return 0.32 * this.capacitance * Math.pow(this.voltage, 2);
    }

    @Override
    public int compareTo(StandardCapacitor obj) {

        int comparedByFirstTwoValues = super.compareTo(obj);

        if (comparedByFirstTwoValues != 0) {
            return comparedByFirstTwoValues;
        }

        ElectrolyticCapacitor other = (ElectrolyticCapacitor) obj;
        if (this.maximumVoltage < other.maximumVoltage) {
            return -1;
        } else if (this.maximumVoltage > other.maximumVoltage) {
            return 1;
        } else {
            return 0;
        }

    }

    @Override
    public int hashCode() {
        return Objects.hashCode(String.format("%f%f%f%s",
                this.capacitance,
                this.voltage,
                this.maximumVoltage,
                this.getClass()));
    }

    public ElectrolyticCapacitor shallowCopy() {
        try {
            return (ElectrolyticCapacitor) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public ElectrolyticCapacitor deepCopy() {
        return new ElectrolyticCapacitor(this.capacitance, this.voltage, this.maximumVoltage);
    }

}
