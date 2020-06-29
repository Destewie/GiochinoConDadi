/*
 * Progetto di Des :)
 */
package esamesuidadi;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Des
 */
public class Dado extends AnchorPane
{
    public static int LATO = 50;
    
    public int valore;
    
    EsameSuiDadi esd;
    
    public Dado(int v, EsameSuiDadi esd)
    {
        super();
        this.valore = v;
        this.esd = esd;
        this.addEventFilter(MouseEvent.MOUSE_CLICKED, new HandlerCambiaDado(esd));
        
        DisegnaDadoBase();
        DisegnaPuntini();
    }
    
    public void Cambia()
    {
        valore = NuovoValore();
        DisegnaPuntini();
    }
    
    public static int NuovoValore()
    {
        Random rand = new Random();
        return rand.nextInt(6) + 1;
    }

    private void DisegnaPuntini() 
    {
        TogliPuntini();
        
        switch(valore)
        {
            case 1:
                Disegna1();
                break;
                
            case 2:
                Disegna2();
                break;
                
            case 3: 
                Disegna1();
                Disegna2();
                break;
                
            case 4:
                Disegna4();
                break;
            
            case 5:
                Disegna1();
                Disegna4();
                break;
            
            case 6:
                Disegna6();
                break;
        }
                
                    
    }
    
    /**
     * Disegna il puntino centrale
     */
    private void Disegna1() 
    {
        Circle c = new Circle(LATO/2, LATO/2, 5);
        c.setFill(Color.BLACK);
        this.getChildren().add(c);
    }
    
    /**
     * Disegna un puntino in alto a destra e uno in basso a sinistra
     */
    private void Disegna2() 
    {
        Circle c1 = new Circle(LATO/5, (LATO/5) * 4, 5);
        c1.setFill(Color.BLACK);
        
        Circle c2 = new Circle((LATO/5)*4, LATO/5, 5);
        c2.setFill(Color.BLACK);
        
        this.getChildren().addAll(c1, c2);
    }
    
    /**
     * disegna un puntino per ogni angolo
     */
    private void Disegna4() 
    {
        Circle c1 = new Circle(LATO/5, (LATO/5), 5);
        c1.setFill(Color.BLACK);
        
        Circle c2 = new Circle((LATO/5) * 4, LATO/5, 5);
        c2.setFill(Color.BLACK);
        
        Circle c3 = new Circle(LATO/5, (LATO/5) * 4, 5);
        c3.setFill(Color.BLACK);
        
        Circle c4 = new Circle((LATO/5) * 4, (LATO/5) * 4, 5);
        c4.setFill(Color.BLACK);
        
        this.getChildren().addAll(c1, c2, c3, c4);
    }

    /**
     * Disegna due colonne con tre puntini ognuna
     */
    private void Disegna6() 
    {
        Disegna4();
        Circle c5 = new Circle(LATO/5, LATO/2, 5);
        Circle c6 = new Circle((LATO/5)*4, LATO/2, 5);
        this.getChildren().addAll(c5, c6);
    }
    
    /**
     * Rimuove tutti i puntini da questo dado
     */
    private void TogliPuntini() 
    {
        this.getChildren().clear();
        DisegnaDadoBase();
    }

    /**
     * Disegna il quadrato bianco di base senza puntini
     */
    private void DisegnaDadoBase() 
    {
        Rectangle rect = new Rectangle(LATO, LATO);
        rect.setFill(Color.WHITE);
        rect.setStroke(Color.BLACK);
        this.getChildren().add(rect);
    }
    
}
