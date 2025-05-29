package controller;

import model.Alerta;
import model.MonitorQualidadeAr;
import model.Usuario;
import repository.RepositorioAlertas;
import repository.RepositorioMedicao;
import repository.RepositorioUsuario;
import service.QualidadeDoArService;

public class QualidadeArController {
    private RepositorioAlertas alertaRepo = new RepositorioAlertas();
    private RepositorioMedicao medicaoRepo = new RepositorioMedicao();
    private RepositorioUsuario usuarioRepo = new RepositorioUsuario();
    private QualidadeDoArService service = new QualidadeDoArService();

    /**
     * Cadastra um novo usuário no sistema.
     *
     * @param nome         Nome do usuário.
     * @param idade        Idade do usuário.
     * @param grupoDeRisco Indica se o usuário pertence ao grupo de risco.
     */
    public void cadastrarUsuario(String nome, int idade, boolean grupoDeRisco){
        Usuario usuario = new Usuario(nome,idade,grupoDeRisco);
        usuarioRepo.salvar(usuario);
    }

    /**
     * Registra uma medição da qualidade do ar para um usuário.
     * Gera um alerta caso a medição indique condição perigosa.
     *
     * @param usuario Usuário relacionado à medição.
     * @param local   Localização onde a medição foi realizada.
     * @param pm25    Valor da concentração de PM2.5.
     */
    public void registrarMedicao(Usuario usuario, String local, double pm25) {
        MonitorQualidadeAr medicao = new MonitorQualidadeAr(local, pm25);
        medicaoRepo.salvar(medicao);
        Alerta alerta = service.gerarAlerta(usuario, medicao);
        if (alerta != null) {
            alertaRepo.salvar(alerta);
        }
    }

    /**
     * Registra uma medição a partir do nome do usuário.
     *
     * @param nomeUsuario Nome do usuário já cadastrado.
     * @param local       Local da medição.
     * @param pm25        Valor da concentração de PM2.5.
     */
    public void registrarMedicao(String nomeUsuario, String local, double pm25) {
        for (Usuario u : usuarioRepo.listarTodos()) {
            if (u.getNome().equalsIgnoreCase(nomeUsuario)) {
                registrarMedicao(u, local, pm25);
                return;
            }
        }
        System.out.println("Usuário não encontrado.");
    }

    /**
     * Lista todos os usuários cadastrados, exibindo seus dados no terminal.
     */
    public void listarUsuarios() {
        for (Usuario u : usuarioRepo.listarTodos()) {
            System.out.println("Usuário: " + u.getNome() + " | Idade: " + u.getIdade() + " | Grupo de Risco: " + u.isGrupoDeRisco());
        }
    }

    /**
     * Lista todas as medições registradas de qualidade do ar, exibindo local e valor PM2.5.
     */
    public void listarMedicoes() {
        for (MonitorQualidadeAr m : medicaoRepo.listarTodos()) {
            System.out.println("Local: " + m.getLocalizacao() + " | PM2.5: " + m.getPm25());
        }
    }

    /**
     * Lista todos os alertas gerados e exibidos no terminal.
     */
    public void listarAlertas() {
        for (Alerta a : alertaRepo.listarTodos()) {
            System.out.println("ALERTA: " + a.getMensagem() + " | Local: " + a.getLocalizacao());
        }
    }
}
