/*
 * Progetto di Des :)
 */
package esamesuidadi;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Des
 */
public class HandlerNuovoDado implements EventHandler<MouseEvent>
{
    EsameSuiDadi esd;
    
    public HandlerNuovoDado (EsameSuiDadi esd)
    {
        this.esd = esd;
    }
    
    @Override
    public void handle(MouseEvent event) 
    {
        if(!esd.vinto)
        {
            boolean esito;
            esito = esd.mano.AggiungiDado();
            System.out.println("Esito aggiunta dado: " + esito);
        
            if(esito == true)
            {
                esd.Punteggio -= 3;
                esd.Totale = esd.mano.CalcolaTot();

                esd.AggiornaLabel();

                if(esd.Totale == 15)
                {
                    esd.Vittoria();
                }
                
            }
        }
        else
        {
            System.out.println("Mi dispiace ma hai già vinto, non puoi più aggiungere dadi");
        }
        
    }

}
