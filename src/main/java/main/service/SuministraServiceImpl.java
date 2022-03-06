package main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.ISuministraDao;
import main.dto.Suministra;

@Service
public class SuministraServiceImpl implements ISuministraService {

	@Autowired
	ISuministraDao iSuministraDao;

	@Override
	public List<Suministra> listarSuministra() {
		
		return iSuministraDao.findAll();
	}
	
	@Override
	public Suministra suministraXID(Integer id) {
		
		return iSuministraDao.findById(id).get();
	}

	@Override
	public Suministra guardarSuministra(Suministra suministra) {
		
		return iSuministraDao.save(suministra);
	}

	@Override
	public Suministra actualizarSuministra(Suministra suministra) {
		
		return iSuministraDao.save(suministra);
	}

	@Override
	public void eliminarSuministra(Integer id) {
		
		iSuministraDao.deleteById(id);
	}
}