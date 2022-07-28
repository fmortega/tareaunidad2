
package alquilerVehiculos;


public class Camion extends Furgoneta{
   private double preciocamion;

    public Camion( String matricula, String tipoVehiculo, int dias) {
        super(matricula, tipoVehiculo, dias);
        this.preciocamion = 40;
    }

    public double getPreciocamio() {
        return preciocamion;
    }

    public void setPreciocamio(double preciocamio) {
        this.preciocamion = preciocamio;
    }
   @Override
     public double calculaPrecio( int dias) {

        return precioBase + (preciofurgoneta*pma)+(preciocamion) * (dias);

    }
}
