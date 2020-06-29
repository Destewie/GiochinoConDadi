/*
 * Progetto di Des :)
 */
package esamesuidadi;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Des
 */
public class HandlerNuovaParta implements EventHandler<MouseEvent>
{
    EsameSuiDadi esd;
    
    public HandlerNuovaParta(EsameSuiDadi esd)
    {
        this.esd = esd;
    }

    @Override
    public void handle(MouseEvent event) 
    {
        esd.Punteggio = 30;
        esd.Totale = 0;
        esd.mano.reset();
        esd.vinto = false;
        
        esd.AggiornaLabel();
    }
    
    
    
}
