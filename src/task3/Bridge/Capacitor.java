package Bridge;

interface Capacitor {
    public void charge(double voltage);

    public void discharge();

    public void changeCapatiance(double capacitance);

    public double getEnergy();
}
