package niccolosorrenti.u5d10_progetto.controller;

import niccolosorrenti.u5d10_progetto.services.PrenotazioneService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioniController {

    private final PrenotazioneService prenotazioneService;

    public PrenotazioniController(PrenotazioneService prenotazioneService) {
        this.prenotazioneService = prenotazioneService;
    }


}
