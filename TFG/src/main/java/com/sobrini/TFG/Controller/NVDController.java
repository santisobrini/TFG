package com.sobrini.TFG.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sobrini.TFG.Entity.NVDSourceData;
import com.sobrini.TFG.Entity.Source;
import com.sobrini.TFG.Service.NVDService;

@RestController
public class NVDController {

	@Autowired
	private NVDService nvdService;

	@PostMapping("/guardar-todo")
	public ResponseEntity<String> guardarTodo(@RequestBody List<NVDSourceData> todo) {
		try {
			System.out.println("Datos recibidos: " + todo);
			System.out.println("Tamaño: " + todo.size());
			for (NVDSourceData entry : todo) {
				nvdService.guardarTodo(entry);
			}
			return ResponseEntity.ok("Todos las vulnerabilidades guardadas correctamente");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error al guardar todas las vulnerabilidades");
		}
	}

	@GetMapping("/Date/Created")
	List<Source> findByCreated(@RequestParam String created) {

		System.out.println("Filtrado por fecha de creación funciona correctamente");

		return nvdService.findByCreated(created);

	}

	@GetMapping("/Name")
	List<Source> findByName(@RequestParam String name) {
		System.out.println("Filtrado por Nombre funciona correctamente");
		return nvdService.findByName(name);
	}

	@GetMapping("/Date/Modified")
	public List<Source> findByLastModified(@RequestParam String lastModified) {
		System.out.println("Filtrado por ultima fecha modificada funciona correctamente");
		return nvdService.findByLastModified(lastModified);
	}

	@GetMapping("/Email")
	public List<Source> findByContactEmail(@RequestParam String email) {
		System.out.println("Filtrado por email funciona correctamente");
		return nvdService.findByContactEmail(email);
	}
	
	@GetMapping("/Source")
	public List<Source> findBySourceIdentifiers(@RequestParam List<String> sourceIdentifier){
		return nvdService.findBySourceIdentifiers(sourceIdentifier);
	}

	@PostMapping("/guardar-fuentes")
	public ResponseEntity<String> guardarFuentes(@RequestBody List<Source> fuentes) {
		try {
			System.out.println("Fuentes Recibidas Correctamente " + fuentes);
			System.out.println("Tamaño : " + fuentes.size());
			for (Source entry : fuentes) {
				nvdService.guardarFuentes(entry);
			}
			return ResponseEntity.ok("Fuentes guardas correctamente ");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar las fuentes");
		}
	}

	@GetMapping("/map")
	public NVDSourceData mapJSON() throws Exception {
		String json = "	{\r\n" + "	\"resultsPerPage\": 2,\r\n" + "	\"startIndex\": 0,\r\n"
				+ "	\"totalResults\": 215,\r\n" + "	\"format\": \"NVD_SOURCE\",\r\n" + "	\"version\": \"2.0\",\r\n"
				+ "	\"timestamp\": \"2022-08-25T17:48:15.150\",\r\n" + "	\"sources\": [\r\n" + "		{\r\n"
				+ "			\"name\": \"MITRE\",\r\n" + "			\"contactEmail\": \"cve@mitre.org\",\r\n"
				+ "			\"sourceIdentifiers\": [\r\n" + "				\"cve@mitre.org\",\r\n"
				+ "				\"security-info@sgi.com\",\r\n" + "				\"security@netgear.com\"\r\n"
				+ "			],\r\n" + "			\"lastModified\": \"2019-09-09T16:18:45.930\",\r\n"
				+ "			\"created\": \"2019-09-09T16:18:45.930\",\r\n" + "			\"v3AcceptanceLevel\": {\r\n"
				+ "				\"description\": \"Contributor\",\r\n"
				+ "				\"lastModified\": \"2022-08-18T00:00:05.690\"\r\n" + "			},\r\n"
				+ "			\"cweAcceptanceLevel\": {\r\n" + "				\"description\": \"Reference\",\r\n"
				+ "				\"lastModified\": \"2022-08-19T00:00:00.060\"\r\n" + "			}\r\n" + "		},\r\n"
				+ "		{\r\n" + "			\"name\": \"DWF\",\r\n"
				+ "			\"contactEmail\": \"cve-assign@distributedweaknessfiling.org\",\r\n"
				+ "			\"sourceIdentifiers\": [\r\n"
				+ "				\"cve-assign@distributedweaknessfiling.org\",\r\n"
				+ "				\"josh@bress.net\"\r\n" + "			],\r\n"
				+ "			\"lastModified\": \"2019-09-09T16:18:45.930\",\r\n"
				+ "			\"created\": \"2019-09-09T16:18:45.930\",\r\n" + "			\"cweAcceptanceLevel\": {\r\n"
				+ "				\"description\": \"Reference\",\r\n"
				+ "				\"lastModified\": \"2020-10-01T00:00:00.070\"\r\n" + "			}\r\n" + "		}\r\n"
				+ "	]\r\n" + "}"; // Tu JSON del NIST aquí
		return nvdService.mapJSONToNVDSourceData(json);
	}
}
