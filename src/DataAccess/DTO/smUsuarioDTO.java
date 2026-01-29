package DataAccess.DTO;

public class smUsuarioDTO {
    private int smIdUsuario;
    private String smNombre;
    private String smUsername;
    private String smPassword;

    public smUsuarioDTO() {}

    public smUsuarioDTO(int smIdUsuario, String smNombre, String smUsername, String smPassword) {
        this.smIdUsuario = smIdUsuario;
        this.smNombre = smNombre;
        this.smUsername = smUsername;
        this.smPassword = smPassword;
    }

    public int smGetIdUsuario() {
        return smIdUsuario;
    }

    public void smSetIdUsuario(int smIdUsuario) {
        this.smIdUsuario = smIdUsuario;
    }

    public String smGetNombre() {
        return smNombre;
    }

    public void smSetNombre(String smNombre) {
        this.smNombre = smNombre;
    }

    public String smGetUsername() {
        return smUsername;
    }

    public void smSetUsername(String smUsername) {
        this.smUsername = smUsername;
    }

    public String smGetPassword() {
        return smPassword;
    }

    public void smSetPassword(String smPassword) {
        this.smPassword = smPassword;
    }
}
