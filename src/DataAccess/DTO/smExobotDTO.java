package DataAccess.DTO;

public class smExobotDTO {
    private int smIdExobot;
    private int smIdTipoExobot;
    private int smIdUsuario;
    private boolean smEntrenado;
    private int smNumeroAccion;
    private int smIdArma;

    public smExobotDTO() {}

    public smExobotDTO(int smIdExobot, int smIdTipoExobot, int smIdUsuario, boolean smEntrenado, int smNumeroAccion, int smIdArma) {
        this.smIdExobot = smIdExobot;
        this.smIdTipoExobot = smIdTipoExobot;
        this.smIdUsuario = smIdUsuario;
        this.smEntrenado = smEntrenado;
        this.smNumeroAccion = smNumeroAccion;
        this.smIdArma = smIdArma;
    }

    public int smGetIdExobot() { return smIdExobot; }
    public void smSetIdExobot(int smIdExobot) { this.smIdExobot = smIdExobot; }

    public int smGetIdTipoExobot() { return smIdTipoExobot; }
    public void smSetIdTipoExobot(int smIdTipoExobot) { this.smIdTipoExobot = smIdTipoExobot; }

    public int smGetIdUsuario() { return smIdUsuario; }
    public void smSetIdUsuario(int smIdUsuario) { this.smIdUsuario = smIdUsuario; }

    public boolean smIsEntrenado() { return smEntrenado; }
    public void smSetEntrenado(boolean smEntrenado) { this.smEntrenado = smEntrenado; }

    public int smGetNumeroAccion() { return smNumeroAccion; }
    public void smSetNumeroAccion(int smNumeroAccion) { this.smNumeroAccion = smNumeroAccion; }

    public int smGetIdArma() { return smIdArma; }
    public void smSetIdArma(int smIdArma) { this.smIdArma = smIdArma; }
}
