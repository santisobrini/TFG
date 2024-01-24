package com.sobrini.TFG.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sobrini.TFG.Entity.Source;

@Repository
public interface FuentesRepository extends MongoRepository<Source, String> {
	
	// FILTRADO POR FECHA CREACIÓN

	List<Source> findByCreated(String created);

	// FILTRADO POR NOMBRE
	List<Source> findByName(String Name);

	// FILTRADO POR FECHA ULTIMA MODIFICACIÓN
	List<Source> findByLastModified(String lastModified);
	
	// FILTRADO POR EL EMAIL DE CONTACTO
	List<Source> findByContactEmail(String email);
	
	//FILTRADO POR FUENTES DE IDENTIFICACIÓN
	List<Source>findBySourceIdentifiers(List<String> sourceIdentifier);
	

}
