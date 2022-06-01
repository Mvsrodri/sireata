package br.edu.utfpr.dv.sireata.factory;

import br.edu.utfpr.dv.sireata.model.AtaParticipante;
import java.sql.SQLException;
import java.util.List;

public interface DAO<E> {
    E buscarPorId(int id) throws SQLException;
    List<E> listarPor(int id) throws SQLException;
    int salvar(E element) throws SQLException;
    void excluir (int id) throws SQLException;
}