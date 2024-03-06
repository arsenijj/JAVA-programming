package task2;

import java.util.Objects;

public class StandardCapacitor extends AbstractElectronicComponent implements Comparable<StandardCapacitor>, Capacitor {
    public double capacitance;
    public double voltage;
    public String notation;

    public StandardCapacitor(double capacitance, double voltage) {
        this.capacitance = capacitance;
        this.voltage = voltage;
        setNotation(this.capacitance);
    }

    private void setNotation(double capacitance) {
        this.notation = "C" + capacitance;
    }

    public void charge(double voltage) {
        this.voltage = voltage;
    }

    public void discharge() {
        this.voltage = 0.0;
    }

    public double getEnergy() {
        return 0.5 * this.capacitance * Math.pow(this.voltage, 2);
    }

    public void changeCapatiance(double capacitance) {
        this.capacitance = capacitance;
        setNotation(capacitance);
    }

    @Override
    public String toString() {
        return String.format("Capacitor via notation = %s and voltage = %f", this.notation, this.voltage);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        StandardCapacitor other = (StandardCapacitor) obj;
        return Double.compare(other.capacitance, capacitance) == 0 &&
                Double.compare(other.voltage, voltage) == 0;

    }

    @Override
    public String getNameOfComponent() {
        return "Capacitor " + this.notation;
    }

    @Override
    public int compareTo(StandardCapacitor other) {
        if (this.capacitance < other.capacitance) {
            return -1;
        } else if (this.capacitance > other.capacitance) {
            return 1;
        } else if (this.voltage < other.voltage) {
            return -1;
        } else if (this.voltage > other.voltage) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(String.format("%f%f%s", this.capacitance, this.voltage, this.getClass()));
    }

    public StandardCapacitor shallowCopy() {
        try {
            return (StandardCapacitor) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public StandardCapacitor deepCopy() {
        return new StandardCapacitor(this.capacitance, this.voltage);
    }

}
