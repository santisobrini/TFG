package com.sobrini.TFG.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sobrini.TFG.Entity.NVDSourceData;
import com.sobrini.TFG.Entity.Source;
import com.sobrini.TFG.Repository.FuentesRepository;
import com.sobrini.TFG.Repository.VulnerabilidadRepository;

@Service
public class NVDService {



	@Autowired
	private VulnerabilidadRepository VulnerabilidadRepository;

	public void guardarTodo(NVDSourceData todo) {
		System.out.println("Guardando todos los datos: " + todo);
		VulnerabilidadRepository.save(todo);
	}

	public List<NVDSourceData> BusquedaPorNombre(String name) {

		return VulnerabilidadRepository.findBySources_Name(name);
	}

	@Autowired
	private FuentesRepository fuentesRepository;

	public void guardarFuentes(Source fuentes) {
		System.out.println("Guardando todas las fuentes de las vulnerabilidades: " + fuentes);
		fuentesRepository.save(fuentes);

	}
	
	private final ObjectMapper objectMapper = new ObjectMapper();

	public NVDSourceData mapJSONToNVDSourceData(String json) throws Exception {
		return objectMapper.readValue(json, NVDSourceData.class);
	}

	//FILTRADO POR FECHA CREACIÓN
	public List<Source> findByCreated(String created) {
		return fuentesRepository.findByCreated(created);
	}

	//FILTRADO POR NOMBRE
	public List<Source> findByName(String Name) {
		return fuentesRepository.findByName(Name);
	}

	// FILTRADO POR ULTIMA FECHA MODIFICADA
	public List<Source> findByLastModified(String lastModified) {
		return fuentesRepository.findByLastModified(lastModified);
	}

	// FILTRADO POR EL EMAIL DE CONTACTO
	public List<Source> findByContactEmail(String email) {
		return fuentesRepository.findByContactEmail(email);
	}

	// FILTRADO POR FUENTES DE IDENTIFICACIÓN
	public List<Source> findBySourceIdentifiers(List<String> sourceIdentifier) {
		return fuentesRepository.findBySourceIdentifiers(sourceIdentifier);
	}

}
