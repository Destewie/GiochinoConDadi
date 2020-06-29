/*
 * Progetto di Des :)
 */
package esamesuidadi;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Des
 */
public class HandlerStampa implements EventHandler<MouseEvent>
{
    EsameSuiDadi esd;
    
    public HandlerStampa(EsameSuiDadi esd)
    {
        this.esd = esd;
    }

    @Override
    public void handle(MouseEvent event) 
    {
        //righe iniziali
        Label lbltitoloPunteggi = new Label("Punti: ");
        HBox hBoxTotale = new HBox(new Label(esd.lblScrittaTot.getText()), new Label(esd.lblPunteggioTot.getText()));
        HBox hBoxPunteggio = new HBox(new Label(esd.lblScrittaPunteggio.getText()), new Label(esd.lblPunteggioPunteggio.getText()));
        Label lblTitoloDadi = new Label("Valore dei dadi: ");
        
        VBox lista = new VBox(lbltitoloPunteggi, hBoxTotale, hBoxPunteggio, lblTitoloDadi);
        lista.setSpacing(10);
        
        // righe dei dadi
        int contDadi = 0;
        for(Dado d : esd.mano.dadi)
        {
            contDadi++;
            lista.getChildren().add(new Label(contDadi + ") " + d.valore));
        }
        
        
        Stage stageStampa = new Stage();
        Scene sceneStampa = new Scene(lista, 150, 270);
        stageStampa.setTitle("Dati di gioco");
        stageStampa.setScene(sceneStampa);
        stageStampa.show();
    }
    
}
