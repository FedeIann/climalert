package ar.edu.utn.ba.ddsi.climalert.services.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Localizacion {
  @JsonProperty("name")
  private String nombre;
  @JsonProperty("region") //no hace falta
  private String region;
  @JsonProperty("country")
  private String pais;
}
