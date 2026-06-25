package ar.edu.utn.ba.ddsi.climalert.services.impl;

import ar.edu.utn.ba.ddsi.climalert.config.RestWeatherProperties;
import ar.edu.utn.ba.ddsi.climalert.repositories.inmemory.ConsultasClimaRepository;
import ar.edu.utn.ba.ddsi.climalert.services.dto.Clima;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class ConsultorDeClima {
  private RestTemplate restTemplate;
  private RestWeatherProperties properties;
  private ConsultasClimaRepository repository;
  ///current.json
  public ConsultorDeClima(RestTemplate restTemplate, RestWeatherProperties properties, ConsultasClimaRepository repository) {
    this.restTemplate = restTemplate;
    this.properties = properties;
    this.repository = repository;
  }

  public void realizarConsultaClima() {
    Clima nuevaConsulta = this.consultarClimaActual();
    this.repository.save(nuevaConsulta);
  }

  public void verificarEmergencia() {
    Clima nuevaConsulta = this.obtenerUltimaInfoClimatica();
    if(nuevaConsulta == null) {
      System.out.println("Todavia no hay Info Cargada");
    }else{
      this.evaluarEmergenciaClimatica(nuevaConsulta);
    }
  }

  public Clima consultarClimaActual(){
    URI uri = UriComponentsBuilder
        .fromUriString(properties.getBaseUrl())
        .path("/current.json")
        .queryParam("key", properties.getKey())
        .queryParam("q",properties.getLocation())
        .build()
        .toUri();
    Clima nuevaConsulta = restTemplate.getForObject(uri, Clima.class);
    System.out.println("Respuesta de WeatherAPI: " + nuevaConsulta);
    return nuevaConsulta;
  }

  public Clima obtenerUltimaInfoClimatica(){
    Optional<Clima> ultimaConsulta = this.repository.findLastElement();
    return ultimaConsulta.orElse(null);
  }

  public void evaluarEmergenciaClimatica(Clima infoActual){

  }

  public List<Clima> findAll() {
    return this.repository.findAll();
  }

  public Clima findById(Long id) {
    return this.repository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("No se encontró ninguna consulta con el ID: " + id));
  }


}
