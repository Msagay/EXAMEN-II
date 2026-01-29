package BusinessLogic.Entities;

public abstract class smExobot {
    protected int smIdExobot;
    protected String smTipoExobot;
    protected boolean smEntrenado;
    protected int smNumeroAccion;
    protected String smArmaNombre;
    
    // Composition: Parts of the Exobot
    protected smBrazo smBrazoIzquierdo;
    protected smBrazo smBrazoDerecho;
    protected smPierna smPiernaIzquierda;
    protected smPierna smPiernaDerecha;
    
    public smExobot(String smTipoExobot) {
        this.smTipoExobot = smTipoExobot;
        this.smNumeroAccion = 0;
        this.smEntrenado = false;
        
        // Initialize Core Components (Composition)
        this.smBrazoIzquierdo = new smBrazo();
        this.smBrazoDerecho = new smBrazo();
        this.smPiernaIzquierda = new smPierna();
        this.smPiernaDerecha = new smPierna();
    }

    public abstract String smRealizarAccion();

    public int smGetIdExobot() { return smIdExobot; }
    public void smSetIdExobot(int id) { this.smIdExobot = id; }
    
    public String smGetTipoExobot() { return smTipoExobot; }
    
    public boolean smIsEntrenado() { return smEntrenado; }
    public void smSetEntrenado(boolean entrenado) { this.smEntrenado = entrenado; }
    
    public int smGetNumeroAccion() { return smNumeroAccion; }
    public void smIncrementarAccion() { this.smNumeroAccion++; }
    
    public String smGetArmaNombre() { return smArmaNombre; }
    public void smSetArmaNombre(String arma) { this.smArmaNombre = arma; }
}
