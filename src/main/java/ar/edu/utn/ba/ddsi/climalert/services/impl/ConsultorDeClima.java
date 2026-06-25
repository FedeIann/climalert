package ar.edu.utn.ba.ddsi.climalert.services.impl;

import ar.edu.utn.ba.ddsi.climalert.config.RestWeatherProperties;
import ar.edu.utn.ba.ddsi.climalert.repositories.inmemory.ConsultasClimaRepository;
import ar.edu.utn.ba.ddsi.climalert.services.dto.Clima;
import java.net.URI;
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

  public Clima ConsultarClimaActual(){
    URI uri = UriComponentsBuilder
        .fromUriString(properties.getBaseUrl())
        .path("/current.json")
        .queryParam("key", properties.getKey())
        .queryParam("q",properties.getLocation())
        .build()
        .toUri();
    return restTemplate.getForObject(uri, Clima.class);
  }

}
