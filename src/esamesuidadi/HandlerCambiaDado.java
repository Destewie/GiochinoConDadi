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
public class HandlerCambiaDado implements EventHandler<MouseEvent>
{
    EsameSuiDadi esd;
    
    public HandlerCambiaDado(EsameSuiDadi esd)
    {
        this.esd = esd;
    }
    
    
    @Override
    public void handle(MouseEvent event) 
    {
        if(event.getSource() instanceof Dado && !esd.vinto)
        {
            ((Dado)event.getSource()).Cambia();
            System.out.println("Cambio il valore del dado (" + ((Dado)event.getSource()).valore + ")");
            
            esd.Punteggio -= 1;
            esd.Totale = esd.mano.CalcolaTot();
            
            esd.AggiornaLabel();
            
            if(esd.Totale == 15)
            {
                esd.Vittoria();
            }
        }
        else if(esd.vinto)
        {
            System.out.println("Mi dispiace ma hai già vinto, non puoi più cambiare il valore dei dadi");
        }
 
    }
    
}
