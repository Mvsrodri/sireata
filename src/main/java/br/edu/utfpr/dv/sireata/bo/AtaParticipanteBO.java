package br.edu.utfpr.dv.sireata.bo;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.edu.utfpr.dv.sireata.dao.AtaParticipanteDAO;
import br.edu.utfpr.dv.sireata.model.AtaParticipante;
import br.edu.utfpr.dv.sireata.factory.FactoryDAO;
import br.edu.utfpr.dv.sireata.factory.DAO;

public class AtaParticipanteBO {
	
	public AtaParticipante buscarPorId(int id) throws Exception{
		try{
			FactoryDAO FctDAO = new FactoryDAO();

			DAO dao = FctDAO.getDAO("AtaParticipante");
			
			return (AtaParticipante) dao.buscarPorId(id);
		}catch(Exception e){
			Logger.getGlobal().log(Level.SEVERE, e.getMessage(), e);
			
			throw new Exception(e.getMessage());
		}
	}
	
	public List<AtaParticipante> listarPorAta(int idAta) throws Exception{
		try{
			FactoryDAO FctDAO = new FactoryDAO();

			DAO dao = FctDAO.getDAO("AtaParticipante");
			
			return dao.listarPor(idAta);
		}catch(Exception e){
			Logger.getGlobal().log(Level.SEVERE, e.getMessage(), e);
			
			throw new Exception(e.getMessage());
		}
	}
	
	public void validarDados(AtaParticipante participante) throws Exception{
		if((participante.getParticipante() == null) || (participante.getParticipante().getIdUsuario() == 0)){
			throw new Exception("Informe o usuário.");
		}
		if((!participante.isPresente()) && (participante.getMotivo().trim().isEmpty())){
			throw new Exception("Informe o motivo da ausência.");
		}
		if(participante.isPresente()){
			participante.setMotivo("");
		}
	}
	
	public int salvar(AtaParticipante participante) throws Exception{
		try{
			if((participante.getAta() == null) || (participante.getAta().getIdAta() == 0)){
				throw new Exception("Informe a ata.");
			}
			
			this.validarDados(participante);
			
			FactoryDAO FctDAO = new FactoryDAO();

			DAO dao = FctDAO.getDAO("AtaParticipante");
			
			return dao.salvar(participante);
		}catch(Exception e){
			Logger.getGlobal().log(Level.SEVERE, e.getMessage(), e);
			
			throw new Exception(e.getMessage());
		}
	}
	
	public void excluir(AtaParticipante participante) throws Exception{
		try{
			FactoryDAO FctDAO = new FactoryDAO();

			DAO dao = FctDAO.getDAO("AtaParticipante");
			
			dao.excluir(participante.getIdAtaParticipante());
		}catch(Exception e){
			Logger.getGlobal().log(Level.SEVERE, e.getMessage(), e);
			
			throw new Exception(e.getMessage());
		}
	}
}
