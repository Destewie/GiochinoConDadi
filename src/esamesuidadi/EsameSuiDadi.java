/*
 * Progetto di Des :)
 */
package esamesuidadi;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Classe principlae del progetto
 * 
 * @param Punteggio Parte da 30 e decresce di 3 ogni nuovo dado aggiunto e descresce di 1 ogni volta che viene cambiato il valore di un dado
 * @param Totale E' la somma dei valori dei dadi presenti sul tavolo
 * 
 * @author Des
 */
public class EsameSuiDadi extends Application 
{
    public static final int MAXDADI = 5;
    
    public Rectangle campo;
    public ManoDadi mano;
    public int Totale = 0;
    public int Punteggio = 30;
    public boolean vinto = false;
    
    Label lblScrittaTot;
    Label lblScrittaPunteggio;
    Label lblPunteggioTot;
    Label lblPunteggioPunteggio;
    
    Button btnNuovaParta;
    Button btnStampa;
    
    @Override
    public void start(Stage primaryStage) 
    {
        AnchorPane root = new AnchorPane();
        
        //il rettangolo verde che fa da campo di gioco
        campo = new Rectangle(530, 300);
        campo.setFill(Color.DARKGREEN);
        campo.setOnMousePressed(new HandlerNuovoDado(this));
        //campo.setFocusTraversable(true);
        //campo.setOnKeyPressed(new HandlerTastiera(this));
        
        //Il gruppo di 5 dadi che possono venire fuori a schermo
        mano = new ManoDadi(this);
        
        //Il punteggio TOTALE = somma di tutti i dadi
        lblScrittaTot = new Label("TOTALE: ");
        lblPunteggioTot = new Label(Integer.toString(Totale));
        
        //Il punteggio parte da 30 e viene decrementato di 3 per ogni nuovo dado aggiunto e di 1 ogni volta che il valore di un dado viene modificato
        lblScrittaPunteggio = new Label("PUNTEGGIO: ");
        lblPunteggioPunteggio = new Label(Integer.toString(Punteggio));
        
        //I bottoni
        btnNuovaParta = new Button ("Nuova partita");
        btnNuovaParta.setOnMouseClicked(new HandlerNuovaParta(this));
        
        btnStampa = new Button ("Stampa");
        btnStampa.setOnMouseClicked(new HandlerStampa(this));

        //Aggiunta dei componenti alla anchorpane
        root.getChildren().addAll(campo, mano, lblScrittaTot, lblPunteggioTot, lblScrittaPunteggio, lblPunteggioPunteggio, btnNuovaParta, btnStampa);
        
        //tweak grafici
        AnchorPane.setTopAnchor(mano, 70.0);
        AnchorPane.setLeftAnchor(mano, 70.0);
        
        AnchorPane.setTopAnchor(lblScrittaTot, 70.0);
        AnchorPane.setLeftAnchor(lblScrittaTot, 550.0);
        
        AnchorPane.setTopAnchor(lblPunteggioTot, 70.0);
        AnchorPane.setLeftAnchor(lblPunteggioTot, 610.0);
        
        AnchorPane.setTopAnchor(lblScrittaPunteggio, 90.0);
        AnchorPane.setLeftAnchor(lblScrittaPunteggio, 550.0);
        
        AnchorPane.setTopAnchor(lblPunteggioPunteggio, 90.0);
        AnchorPane.setLeftAnchor(lblPunteggioPunteggio, 630.0);
        
        AnchorPane.setTopAnchor(btnNuovaParta, 120.0);
        AnchorPane.setLeftAnchor(btnNuovaParta, 550.0);

        AnchorPane.setTopAnchor(btnStampa, 150.0);
        AnchorPane.setLeftAnchor(btnStampa, 550.0);
        
        
        //configurazione generale
        Scene scene = new Scene(root, 730, 300);
        
        primaryStage.setTitle("Gambling World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        launch(args);
    }
    
    /**
     * Aggiorna i punteggi a schermo
     */
    public void AggiornaLabel()
    {
        lblPunteggioTot.setText(Integer.toString(Totale));
        lblPunteggioPunteggio.setText(Integer.toString(Punteggio));
    }

    /**
     * Metodo per celebrare la vittoria <br><br>
     * In pratica è quello che fa comparire una nuova finestra con la scritta: "HAI VINTO!"
     */
    public void Vittoria() 
    {
        vinto = true;
        
        //creazione della nuova finestra
        Stage winningStage = new Stage();
        winningStage.setTitle("WIN!");
        
        //creazione degli elementi della finestra
        Rectangle r = new Rectangle(298, 298);
        r.setFill(Color.LIGHTGREEN);
        r.setStroke(Color.GREEN);
        r.setStrokeWidth(20);
        
        Circle c = new Circle(90);
        c.setFill(Color.LIGHTCYAN);
        c.setStroke(Color.LIGHTBLUE);
        c.setStrokeWidth(3);
        
        Label l = new Label("HAI VINTO!");
        

        StackPane sp = new StackPane(r, c, l);
        
        Scene winningScene = new Scene(sp, 300, 300);
        winningStage.setScene(winningScene);
        winningStage.show();
         
    }
    
}
