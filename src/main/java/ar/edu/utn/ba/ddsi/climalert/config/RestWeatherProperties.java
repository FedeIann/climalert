package ar.edu.utn.ba.ddsi.climalert.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "rest-weather")
@Data
public class RestWeatherProperties {
  private String baseUrl;
}
