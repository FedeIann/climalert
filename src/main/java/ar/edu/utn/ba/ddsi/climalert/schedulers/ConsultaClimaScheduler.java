package ar.edu.utn.ba.ddsi.climalert.schedulers;

import ar.edu.utn.ba.ddsi.climalert.services.impl.ConsultorDeClima;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Component
public class ConsultaClimaScheduler {
  private ConsultorDeClima consultorDeClima;

  public ConsultaClimaScheduler(ConsultorDeClima consultorDeClima){
    this.consultorDeClima = consultorDeClima;
  }

  @Scheduled(cron = "0 5 * * * ?", zone = "America/Argentina/Buenos_Aires")
  public void obtenerDatosClimaticos(){

  }
  @Scheduled(cron = "0 1 * * * ?", zone = "America/Argentina/Buenos_Aires")
  public void evaluarEmergencia(){

  }
}
