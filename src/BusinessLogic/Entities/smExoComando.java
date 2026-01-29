package BusinessLogic.Entities;

public class smExoComando extends smExobot {
    public smExoComando() {
        super("ExoComando");
        this.smArmaNombre = "Laser/Bayoneta";
    }

    @Override
    public String smRealizarAccion() {
        return "Combatir (Energía)";
    }
}
