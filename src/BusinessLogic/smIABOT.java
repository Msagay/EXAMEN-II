package BusinessLogic;

import BusinessLogic.Entities.smExobot;
import BusinessLogic.Entities.smSoldadoExperto;

public class smIABOT {
    
    // //Refactorización: Changed signature to include SoldadoExperto as per diagram implication
    public void smEntrenar(smExobot smExobot, smSoldadoExperto smSoldado) {
        if (smExobot != null) {
            smExobot.smSetEntrenado(true);
        }
    }
}