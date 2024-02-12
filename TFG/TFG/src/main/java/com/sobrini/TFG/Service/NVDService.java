package com.sobrini.TFG.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sobrini.TFG.Entity.NVDSourceData;
import com.sobrini.TFG.Entity.Source;
import com.sobrini.TFG.Repository.FuentesRepository;
import com.sobrini.TFG.Repository.VulnerabilidadRepository;


@Service
public class NVDService {
	
    private final ObjectMapper objectMapper = new ObjectMapper();

    public NVDSourceData mapJSONToNVDSourceData(String json) throws Exception {
        return objectMapper.readValue(json, NVDSourceData.class);
    }
    
    
    @Autowired
    private VulnerabilidadRepository VulnerabilidadRepository;
    public void guardarTodo(NVDSourceData todo) {
    	 System.out.println("Guardando todos los datos: " + todo);
    	VulnerabilidadRepository.save(todo);
    }
    
    public List<NVDSourceData> BusquedaPorNombre(String name){
    	
    	return VulnerabilidadRepository.findBySources_Name(name);
    }
  @Autowired
  private FuentesRepository fuentesRepository;
  public void guardarFuentes(Source fuentes) {
	  System.out.println("Guardando todas las fuentes de las vulnerabilidades: " + fuentes);
	  fuentesRepository.save(fuentes);
	  
  }
  

   
}

