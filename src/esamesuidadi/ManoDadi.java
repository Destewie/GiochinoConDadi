/*
 * Progetto di Des :)
 */
package esamesuidadi;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.scene.layout.HBox;

/**
 * E' la classe che rappressenta il gruppo di dadi che va a formarsi a schermo
 * @author Des
 */
public class ManoDadi extends HBox
{
    public List<Dado> dadi; //non sono sicuro che sia fondamentale ma per ora la tengo
    private final Random rand;
    
    EsameSuiDadi esd;
    
    public ManoDadi(EsameSuiDadi esd)
    {
        this.dadi = new ArrayList<>();
        rand = new Random();
        this.esd = esd;
        
        this.setSpacing(35);
    }
    
    /**
     * Aggiunge un dado alla giocata
     * @return 
     */
    public boolean AggiungiDado()
    {
        boolean aBuonFine = true;
        
        if(dadi.size()==5)
            aBuonFine = false;
        else
        {
            dadi.add(new Dado(Dado.NuovoValore(), esd));
            this.getChildren().add(dadi.get(dadi.size()-1)); //aggiunge all'hbox l'ultimo dado inserito nella lista
        }
            
        return aBuonFine;
    }
    
    /**
     * Calcola la somma dei dadi sul tavolo
     * @return 
     */
    public int CalcolaTot()
    {
        int tot = 0;
        
        for(Dado d : dadi)
        {
            tot += d.valore;
        }
        
        return tot;
    }

    //azzera la mano da capo
    void reset()
    {
        this.dadi.clear();
        this.getChildren().clear();
    }
}
