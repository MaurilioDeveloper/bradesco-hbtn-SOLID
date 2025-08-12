import java.util.Date;
import java.util.List;

public class Comments {

    // Copyright (C) 2022 by CleanCode.
    // Lançado sob os termos da GNU General Public License versão 2 ou posterior

    public Owner getTestcaseOwner(Testcase testcase){};

    public Hours getHoursInQuarter(){};

    // TODO Este método deve ser removido
    public void check(){
        return;
    }

    /**
     * <p> este método publica resultados com base na data
     * </p>
     * @param data data a partir da qual os resultados devem ser publicados
     * @retornar Lista de entidades de resultado
     * @desde 16.0
     */
    public List<Result> publishResults(Date date) {
        // implementação
    }
}

// stubs mínimos para o arquivo (se o avaliador compilar)
class Owner {}
class Testcase {}
class Hours {}
class Result {}
