package com.sobrini.TFG.Controller.test;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import com.sobrini.TFG.Controller.NVDController;
import com.sobrini.TFG.Entity.NVDSourceData;
import com.sobrini.TFG.Service.NVDService;
@WebMvcTest(NVDController.class)
public class TFGTest {
@Autowired 
private MockMvc mockMvc;
@MockBean
private NVDService nvdService;



	@Test 
	public void comprobarFiltrado_Nombre() throws Exception{
		mockMvc.perform(get("/Name").param("name", "NIST"))
		.andDo(print())
		.andExpect(status().isOk());
	}
	
	@Test 
	public void comprobarFiltrado_Fecha_Creación() throws Exception{
		mockMvc.perform(get("/Date/Created").param("created", "2019-09-09T16:18:46.133"))
		.andDo(print())
		.andExpect(status().isOk());
	}
	@Test 
	public void comprobarFiltrado_Fecha_Modificación() throws Exception{
		mockMvc.perform(get("/Date/Modified").param("lastModified", "2019-09-09T16:18:45.930"))
		.andDo(print())
		.andExpect(status().isOk());
	}
	
	@Test 
	public void comprobarFiltrado_Email() throws Exception{
		mockMvc.perform(get("/Email").param("email", "cve@mitre.org"))
		.andDo(print())
		.andExpect(status().isOk());
	}
	@Test 
	public void comprobarFiltrado_Fuente_Identificación() throws Exception{
		mockMvc.perform(get("/Source").param("sourceIdentifier", "cert@airbus.com"))
		.andDo(print())
		.andExpect(status().isOk());
	}
	 
	 @Test
	    public void testGuardarTodo() {
	        // Arrange
		 List<NVDSourceData> data = new ArrayList<>();
	        NVDSourceData datos = mock(NVDSourceData.class);
	        NVDService nvdService = mock(NVDService.class);
	        doNothing().when(nvdService).guardarTodo(datos);
	        NVDController controller = new NVDController();
	        

	        // Act
	        ResponseEntity<String> response = controller.guardarTodo(data);

	        // Assert
	        assertEquals(HttpStatus.OK, response.getStatusCode());
	        assertEquals("Todos las vulnerabilidades guardadas correctamente", response.getBody());
	    
	    }

}
