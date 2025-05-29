package repository;

import java.util.List;

/**
 * Interface genérica que define as operações básicas de um repositório.
 *
 * @param <T> Tipo da entidade que o repositório irá armazenar.
 */
public interface RepositorioBase<T> {

    /**
     * Salva uma entidade no repositório.
     */
    void salvar(T entidade);

    /**
     * Retorna uma lista com todas as entidades armazenadas no repositório.
     */
    List<T> listarTodos();
}
