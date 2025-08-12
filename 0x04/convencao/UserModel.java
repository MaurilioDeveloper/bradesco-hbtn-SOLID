import java.util.ArrayList;
import java.util.List;

/**
 * Modelo de Usuário seguindo convenções de nomenclatura.
 */
public class UserModel {

    private int idUser;
    private String descricao;

    public static final int IDADE_MINIMA = 18;

    // coleta usuários
    public List<User> fetchUsers() {
        return new ArrayList<>();
    }

    // coleta todos os usuários
    public List<User> getAllUsers() {
        return new ArrayList<>();
    }

    // coleta usuários
    public List<User> getUsers() {
        return new ArrayList<>();
    }

    // Getters/Setters (opcional)
    public int getIdUser() { return idUser; }
    public void setIdUser(int idUser) { this.idUser = idUser; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    // Stub mínimo para compilar, se necessário
    public static class User { }
}
