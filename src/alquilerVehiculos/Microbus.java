package alquilerVehiculos;

public class Microbus extends Vehiculo {

    private double precioMicrobus;

    public Microbus(double precioMicrobus, String matricula, String tipoVehiculo, int dias) {
        super(matricula, tipoVehiculo, dias);
        this.precioMicrobus = precioMicrobus;
    }

    public double getPrecioMicrobus() {
        return precioMicrobus;
    }

    public void setPrecioMicrobus(double precioMicrobus) {
        this.precioMicrobus = precioMicrobus;
    }

    @Override
    public double calculaPrecio(double precio,int dias) {
        return precioBase + (precio * dias);
    }
}
