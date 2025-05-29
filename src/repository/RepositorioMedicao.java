package repository;

import model.MonitorQualidadeAr;

import java.util.ArrayList;
import java.util.List;

public class RepositorioMedicao implements RepositorioBase<MonitorQualidadeAr>{
    private List<MonitorQualidadeAr> medicoes = new ArrayList<>();

    @Override
    public void salvar(MonitorQualidadeAr medicao) {
        medicoes.add(medicao);
    }

    @Override
    public List<MonitorQualidadeAr> listarTodos() {
        return medicoes;
    }
}
