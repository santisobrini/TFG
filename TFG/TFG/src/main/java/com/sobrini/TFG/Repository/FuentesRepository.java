package com.sobrini.TFG.Repository;




import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sobrini.TFG.Entity.Source;

@Repository
public interface FuentesRepository extends MongoRepository<Source,String> {
	//FILTRADO POR FECHA 
	//FILTRADO POR NOMBRE 
	//FILTRADO POR CRITICIDAD
}
