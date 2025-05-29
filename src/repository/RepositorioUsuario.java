package repository;

import model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class RepositorioUsuario implements RepositorioBase<Usuario>{
    private List<Usuario> users = new ArrayList<>();

    @Override
    public void salvar(Usuario usuario) {
        users.add(usuario);
    }

    @Override
    public List<Usuario> listarTodos() {
        return users;
    }
}
