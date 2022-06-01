package br.edu.utfpr.dv.sireata.factory;

import br.edu.utfpr.dv.sireata.dao.AnexoDAO;
import br.edu.utfpr.dv.sireata.dao.AtaDAO;
import br.edu.utfpr.dv.sireata.dao.AtaParticipanteDAO;
import br.edu.utfpr.dv.sireata.dao.CampusDAO;
import br.edu.utfpr.dv.sireata.dao.ComentarioDAO;
import br.edu.utfpr.dv.sireata.dao.DepartamentoDAO;
import br.edu.utfpr.dv.sireata.dao.OrgaoDAO;
import br.edu.utfpr.dv.sireata.dao.PautaDAO;
import br.edu.utfpr.dv.sireata.dao.UsuarioDAO;

public class FactoryDAO {
    public DAO getDAO (String op) {
        if (op == null || op.isEmpty())
            return null;
        
        if(op == "Anexo"){
            return (DAO) new AnexoDAO();
        }else if(op == "Pauta"){
            return (DAO) new PautaDAO();
        }else if(op == "Ata"){
            return (DAO) new AtaDAO();
        }else if(op == "AtaParticipante"){
            return (DAO) new AtaParticipanteDAO();
        }else if(op == "Campus"){
            return (DAO) new CampusDAO();
        }else if(op == "Comentario"){
            return (DAO) new ComentarioDAO();
        }else if(op == "Departamento"){
            return (DAO) new DepartamentoDAO();
        }else if(op == "Orgao"){
            return (DAO) new OrgaoDAO();
        }else if(op == "Usuario"){
            return (DAO) new UsuarioDAO();
        }else{
            throw new IllegalArgumentException("ERRO "+op);
        }
        
    }
}