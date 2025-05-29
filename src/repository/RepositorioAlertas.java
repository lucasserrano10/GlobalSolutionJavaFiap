package repository;

import model.Alerta;

import java.util.ArrayList;
import java.util.List;

public class RepositorioAlertas implements RepositorioBase<Alerta>{
    private List<Alerta> alertas = new ArrayList<>();

    @Override
    public void salvar(Alerta alerta) {
        alertas.add(alerta);
    }

    @Override
    public List<Alerta> listarTodos() {
        return alertas;
    }
}
