package ar.edu.utn.ba.ddsi.climalert.services.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoActualClima {
  @JsonProperty("temp_c")
  private Double temperaturaCelsius;
  @JsonProperty("wind_kph")
  private Double vientoEnKm;
  @JsonProperty("wind_dir")
  private String direccionViento;
  @JsonProperty("humidity")
  private Integer humedad;
  @JsonProperty("chance_of_rain")
  private Integer chancesDeLluvia;
}
