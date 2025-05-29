package service;

import model.Alerta;
import model.MonitorQualidadeAr;
import model.Usuario;

public class QualidadeDoArService {

    /**
     * Gera um alerta baseado na medição de PM2.5 e no perfil do usuário.
     *
     * Se a concentração de PM2.5 for maior que 75, um alerta é criado.
     * O alerta é mais grave caso o usuário pertença ao grupo de risco.
     *
     * @param usuario O usuário para o qual o alerta será gerado.
     * @param medicao A medição da qualidade do ar contendo localização e valor de PM2.5.
     * @return Um objeto Alerta contendo a mensagem e localização, ou null se a qualidade do ar estiver dentro dos limites seguros.
     */
    public Alerta gerarAlerta(Usuario usuario, MonitorQualidadeAr medicao) {
        if (medicao.getPm25() > 75) {
            String msg;
            if (usuario.isGrupoDeRisco()) {
                msg = "ALERTA GRAVE: Qualidade do ar perigosa para grupo de risco!";
            } else {
                msg = "Alerta: Qualidade do ar ruim. Evite atividades ao ar livre.";
            }
            return new Alerta(msg, medicao.getLocalizacao());
        }
        return null;
    }
}
