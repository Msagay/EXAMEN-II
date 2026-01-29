package BusinessLogic.Entities;

public class smExoMedico extends smExobot {
    public smExoMedico() {
        super("ExoMedico");
        this.smArmaNombre = "BioSensor/BioEscaner";
    }

    @Override
    public String smRealizarAccion() {
        return "Asistir (Energía)";
    }
}
