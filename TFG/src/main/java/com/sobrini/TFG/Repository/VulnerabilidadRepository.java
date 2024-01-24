package com.sobrini.TFG.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sobrini.TFG.Entity.NVDSourceData;


@Repository
public interface VulnerabilidadRepository extends MongoRepository<NVDSourceData,Integer> {
	 List<NVDSourceData> findBySources_Name(String name);
    
}


