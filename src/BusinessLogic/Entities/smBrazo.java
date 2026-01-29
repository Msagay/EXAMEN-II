package BusinessLogic.Entities;

public class smBrazo {
    private boolean aaFuncional;

    public smBrazo() {
        this.aaFuncional = true;
    }

    public boolean smIsFuncional() {
        return aaFuncional;
    }

    public void smSetFuncional(boolean aaFuncional) {
        this.aaFuncional = aaFuncional;
    }
}
