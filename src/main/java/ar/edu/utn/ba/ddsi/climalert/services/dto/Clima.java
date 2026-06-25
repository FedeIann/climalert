package ar.edu.utn.ba.ddsi.climalert.services.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clima {
  @JsonProperty("location")
  private Localizacion localizacion;
  @JsonProperty("current")
  private InfoActualClima infoActualClima;

}
