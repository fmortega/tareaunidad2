package alquilerVehiculos;

public class Furgoneta extends Vehiculo {

    double preciofurgoneta;
    int pma;

    public Furgoneta( String matricula, String tipoVehiculo, int dias) {
        super(matricula, tipoVehiculo, dias);
        this.preciofurgoneta = 20;
        pma = 17;
    }

    public double getPreciofurgoneta() {
        return preciofurgoneta;
    }

    public void setPreciofurgoneta(double preciofurgoneta) {
        this.preciofurgoneta = preciofurgoneta;
    }

    
    @Override
    public double calculaPrecio( int dias) {

        return precioBase + (preciofurgoneta*pma) * (dias);

    }
}
