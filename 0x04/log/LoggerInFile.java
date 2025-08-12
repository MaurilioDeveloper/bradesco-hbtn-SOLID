import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerInFile {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(LoggerInFile.class.getName());
        FileHandler fileHandler = null;

        try {
            // cria/abre o arquivo de log em modo append
            fileHandler = new FileHandler("logs.txt", true);
            fileHandler.setFormatter(new SimpleFormatter());

            // evita duplicar logs no console
            logger.setUseParentHandlers(false);
            logger.addHandler(fileHandler);

            logger.info("teste de Log");
            logger.info("Olá, eu sou o teste da classe principal");
        } catch (IOException | SecurityException e) {
            logger.log(Level.SEVERE, "Falha ao configurar o logger de arquivo", e);
        } finally {
            if (fileHandler != null) {
                fileHandler.flush();
                fileHandler.close();
            }
        }
    }
}
