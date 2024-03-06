package Bridge;

abstract class AbstractElectronicComponent {
    abstract public String getNameOfComponent();

    protected Manufacturer manufacturer;

    public AbstractElectronicComponent(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
}