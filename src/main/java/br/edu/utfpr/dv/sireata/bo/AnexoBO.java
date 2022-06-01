package br.edu.utfpr.dv.sireata.bo;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.edu.utfpr.dv.sireata.dao.AnexoDAO;
import br.edu.utfpr.dv.sireata.model.Anexo;
import br.edu.utfpr.dv.sireata.factory.FactoryDAO;
import br.edu.utfpr.dv.sireata.factory.DAO;

public class AnexoBO {

	public Anexo buscarPorId(int id) throws Exception{
		try{
			FactoryDAO FctDAO = new FactoryDAO();

			DAO dao = FctDAO.getDAO("Anexo");

			return (Anexo) dao.buscarPorId(id);
		}catch(Exception e){
			Logger.getGlobal().log(Level.SEVERE, e.getMessage(), e);
			
			throw new Exception(e.getMessage());
		}
	}
	
	public List listarPorAta(int idAta) throws Exception{
		try{
			FactoryDAO FctDAO = new FactoryDAO();

			DAO dao = FctDAO.getDAO("Anexo");
			
			return dao.listarPor(idAta);
		}catch(Exception e){
			Logger.getGlobal().log(Level.SEVERE, e.getMessage(), e);
			
			throw new Exception(e.getMessage());
		}
	}
	
	public void validarDados(Anexo anexo) throws Exception{
		if(anexo.getArquivo() == null){
			throw new Exception("Efetue o envio do arquivo.");
		}
		if(anexo.getDescricao().isEmpty()){
			throw new Exception("Informe a descrição do anexo.");
		}
	}
	
	public int salvar(Anexo anexo) throws Exception{
		try{
			if((anexo.getAta() == null) || (anexo.getAta().getIdAta() == 0)){
				throw new Exception("Informe a ata.");
			}
			
			this.validarDados(anexo);
			
			FactoryDAO FctDAO = new FactoryDAO();

			DAO dao = FctDAO.getDAO("Anexo");
			
			return dao.salvar(anexo);
		}catch(Exception e){
			Logger.getGlobal().log(Level.SEVERE, e.getMessage(), e);
			
			throw new Exception(e.getMessage());
		}
	}
	
	public void excluir(Anexo anexo) throws Exception{
		this.excluir(anexo.getIdAnexo());
	}
	
	public void excluir(int id) throws Exception{
		try{
			FactoryDAO FctDAO = new FactoryDAO();

			DAO dao = FctDAO.getDAO("Anexo");
			
			dao.excluir(id);
		}catch(Exception e){
			Logger.getGlobal().log(Level.SEVERE, e.getMessage(), e);
			
			throw new Exception(e.getMessage());
		}
	}
	
}
