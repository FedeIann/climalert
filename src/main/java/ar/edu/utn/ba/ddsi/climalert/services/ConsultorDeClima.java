package ar.edu.utn.ba.ddsi.climalert.services;

import ar.edu.utn.ba.ddsi.climalert.config.RestWeatherProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ConsultorDeClima {
  private RestTemplate restTemplate;
  private RestWeatherProperties properties;

  public ConsultorDeClima(RestTemplate restTemplate, RestWeatherProperties properties) {
    this.restTemplate = restTemplate;
    this.properties = properties;
  }

}
