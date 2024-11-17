/**
 * permet de cree la class Case
 */
public class Case{
    private boolean contientUneBombe;
    private boolean estDecouverte;
    private boolean estMarquee;

    /**
     * est le constructeur de la class Case
     */
    public Case(){
        this.contientUneBombe=false;
        this.estDecouverte=false;
        this.estMarquee=false;
    }
    /**
     * cette methode permet de mettre tout les valeurs de la 
     * case a false pour le reset
     */
    public void reset(){
        this.estMarquee=false;
        this.estDecouverte=false;
        this.contientUneBombe=false;
    }
    /** 
     * cette methode permet de poser une bombe sur cette case
     */
    public void poseBombe(){
        this.contientUneBombe=true;
    }
    /**
     * Cette methode permet de savoir si la case 
     * contient une bombe
     * @return un boolean
     */
    public boolean contientUneBombe(){
        return this.contientUneBombe;
    }
    /**
     * cette methode permet de savoir si une case
     * à été decouverte ou non
     * @return un boolean
     */
    public boolean estDecouverte(){
        return this.estDecouverte;
    }
    /**
     * cette methode permet de savoir si la case
     * est marque 
     * @return un boolean
     */
    public boolean estMarquee(){
        return this.estMarquee;
    }
    /** 
     * cett methode permet de reveler la case
     * @return un boolean
     */
    public boolean reveler(){
        if (this.estDecouverte != true && !this.estMarquee ){
            this.estDecouverte=true;
            return true;
        }
        if (this.estDecouverte != true && this.estMarquee ){
            this.estMarquee=true;
            this.estDecouverte=true;
            return true;
        }
        return false;
    }
    /**
     * cette fonction permet de marque la case
     */
    public void marque(){
        if (! this.estMarquee()){
            this.estMarquee=true;
        }
        else{
            this.estMarquee=false;
        }
    }
}