/*
 * Progetto di Des :)
 */
package esamesuidadi;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Des
 */
public class HandlerTastiera implements EventHandler<KeyEvent>
{
    EsameSuiDadi esd;
    
    public HandlerTastiera(EsameSuiDadi esd)
    {
        this.esd = esd;
    }
    
    @Override
    public void handle(KeyEvent event) 
    {
        if(event.getCode() == KeyCode.P)
        {
            esd.campo.fireEvent(new ActionEvent());
        }
        else if(event.getCode() == KeyCode.N)
        {
            esd.btnNuovaParta.fireEvent(new ActionEvent());
        }
        else if(event.getCode() == KeyCode.S)
        {
            esd.btnStampa.fireEvent(new ActionEvent());
        }
    }
    
}
