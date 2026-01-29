package BusinessLogic.Entities;

public class smExoAsalto extends smExobot {
    public smExoAsalto() {
        super("ExoAsalto");
        this.smArmaNombre = "Fusil/Revolver";
    }

    @Override
    public String smRealizarAccion() {
        return "Disparar (Munición)";
    }
}
