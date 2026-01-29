package BusinessLogic.Entities;

public class smExoExplorador extends smExobot {
    public smExoExplorador() {
        super("ExoExplorador");
        this.smArmaNombre = "GPS/Giroscopio";
    }

    @Override
    public String smRealizarAccion() {
        return "Detectar (Energía)";
    }
}
