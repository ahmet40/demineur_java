import java.util.List;
import java.util.ArrayList;


public class CaseIntelligente extends Case{ 

    private List<Case> lesVoisines;
    /**
     * permet de cree un caseIntelligente intelligente
     */
    public CaseIntelligente(){
        super();
        this.lesVoisines=new ArrayList<>();
    }
    /**
     * permet d'ajouter une caseIntelligente dans la liste des voisins
     * @param unecase une caseIntelligente
     */
    public void ajouteVoisine(Case uneCase){
        this.lesVoisines.add(uneCase);
    }
    public List<Case> getLesVoisines() {
        return lesVoisines;
    }
    /**
     * cette methode permet de renvoyer le nombre de bombes autour de lui
     * @return un entier
     */
    public int nombreBombesVoisines(){
        int cpt=0;
        for(Case c:this.lesVoisines){
            if (c.contientUneBombe()){cpt+=1;}
        }
    
        return cpt;
    }


   
    /**
     * cette methode permet de renvoyer le texte correspondant à la caseIntelligente
     * @return une chaine de caractere
     */
    @Override
    public String toString(){
        if (estDecouverte()==false && estMarquee()==false){
            return " ";
        }
        else if (estMarquee() && estDecouverte()==false) {
            return "?";
        } 
        if ( contientUneBombe()) {
            return "@";
        }

        return " "+String.valueOf(nombreBombesVoisines());
    }
}
