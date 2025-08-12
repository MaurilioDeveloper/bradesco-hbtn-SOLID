public class Error {

    // Dependências simuladas (stubs)
    private UserRepository userRepository;
    private OwnerRepo ownerRepo;

    /**
     * createUser correto:
     * - Usa exceções (nada de códigos/flags)
     * - Não retorna null para sinalizar erro
     */
    public User createUser(User user){
        try {
            // Se usuário existir, lança exceção específica
            loadUser(user.getId());
            throw new UserExistsException(user.getId());
        } catch (UserNotFoundException notFound) {
            // Usuário não existe -> seguir com criação
        }

        resolveGroup(user);
        return userRepository.save(user);
    }

    /**
     * Exceções com contexto: mensagem com dados relevantes.
     */
    public void validate(String id){
        if (ownerRepo.count(id) == 0){
            throw new ValidationException("id: " + id + " não foi informado; deveria ser informado.");
        }
    }

    // --------- Helpers e stubs (mínimos para completar o arquivo) ---------

    /** Carrega usuário; lança se não encontrar. */
    private User loadUser(String id) throws UserNotFoundException {
        // Stub: sempre "não encontrado"
        throw new UserNotFoundException(id);
    }

    private void resolveGroup(User user){
        // lógica de agrupamento (stub)
    }

    // Repositórios/Modelos/Exceções (stubs)
    public interface UserRepository { User save(User user); }
    public interface OwnerRepo { int count(String id); }

    public static class User {
        private final String id;
        public User(String id){ this.id = id; }
        public String getId(){ return id; }
    }

    public static class UserExistsException extends RuntimeException {
        public UserExistsException(String id){
            super("Usuário já existe: " + id);
        }
    }

    public static class UserNotFoundException extends Exception {
        public UserNotFoundException(String id){
            super("Usuário não encontrado: " + id);
        }
    }

    public static class ValidationException extends RuntimeException {
        public ValidationException(String message){
            super(message);
        }
    }
}
