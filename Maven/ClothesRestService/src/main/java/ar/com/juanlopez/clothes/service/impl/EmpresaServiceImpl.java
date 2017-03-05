package ar.com.juanlopez.clothes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.juanlopez.clothes.model.Empresa;
import ar.com.juanlopez.clothes.repository.EmpresaRepository;
import ar.com.juanlopez.clothes.service.EmpresaService;

@Service
public class EmpresaServiceImpl implements EmpresaService {
	@Autowired
	EmpresaRepository empresaRepository;
	@Override
	public List<Empresa> findAll() {
		return empresaRepository.findAll();
	}

	@Override
	public Empresa create(Empresa empresa) {
		return empresaRepository.save(empresa);
	}

	@Override
	public Empresa find(Integer id) {
		return empresaRepository.findOne(id);
	}

	@Override
	public Empresa update(Empresa empresa) {
		// TODO Auto-generated method stub
		return empresaRepository.save(empresa);
	}

	@Override
	public void delete(Integer id) {
		empresaRepository.delete(id);
	}

}
