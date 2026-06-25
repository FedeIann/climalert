package ar.edu.utn.ba.ddsi.climalert.repositories.inmemory;

import ar.edu.utn.ba.ddsi.climalert.services.dto.Clima;
import ar.edu.utn.ba.ddsi.climalert.utils.GeneradorIdSecuencial;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class ConsultasClimaRepository {
  private final GeneradorIdSecuencial generadorId = new GeneradorIdSecuencial();
  private final List<Clima> infoClima = new ArrayList<>();

  public List<Clima> findAll(){
    return new ArrayList<>(infoClima);
  }

  public Optional<Clima> findById(Long idConsultaClima){
    return infoClima.stream().filter(subcategoria -> subcategoria.getId().equals(idConsultaClima)).findFirst();
  }

  public Optional<Clima> findLastElement(){
    long idUltimoElemento = infoClima.size();
    return this.findById(idUltimoElemento);
  }

  public Clima save(Clima nuevaConsulta) {
    if (nuevaConsulta.getId() == null)
      nuevaConsulta.setId(generadorId.siguiente());
    infoClima.add(nuevaConsulta);
    return nuevaConsulta;
  }
}
