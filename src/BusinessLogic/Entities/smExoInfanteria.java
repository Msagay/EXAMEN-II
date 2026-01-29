package BusinessLogic.Entities;

public class smExoInfanteria extends smExobot {
    public smExoInfanteria() {
        super("ExoInfanteria");
        this.smArmaNombre = "Misil/Mortero";
    }

    @Override
    public String smRealizarAccion() {
        return "Explotar (Munición)";
    }
}
