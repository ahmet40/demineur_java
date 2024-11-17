import java.util.List;
import java.util.ArrayList;
import java.util.Random;

import org.w3c.dom.ls.LSParser;

public class Plateau{
    private int nbLignes;
    private int nbColonnes;
    private int pourcentageDeBombes;
    private int nbBombes;
    private List<List<CaseIntelligente>> lePlateau;

    /**
     * cette methode permet de cree le plateau
     * @param nbLignes le nombre de ligne
     * @param nbColonnes le nombre de colonnes
     * @param pourcentage le poucentage de bombe
     */
    public Plateau(int nbLignes,int nbColonnes,int pourcentage){
        this.nbLignes=nbLignes;
        this.nbColonnes=nbColonnes;
        this.pourcentageDeBombes=pourcentage;
        this.nbBombes=(nbColonnes*nbLignes)/(pourcentage*100);
        this.lePlateau=new ArrayList<>();
        creerLesCasesVides();
        rendLesCaseIntelligentes();
        poseDesBombesAleatoirement();
    }

    /**
     * permet de cree des intelligente dans le plateau
     */
    private void creerLesCasesVides(){
        for (int i=0;i<this.nbLignes;i++){
            List <CaseIntelligente> temp=new ArrayList<>();
            for (int j=0;j<this.nbColonnes;j++){
                CaseIntelligente x= new CaseIntelligente();
                temp.add(x);
            }
            lePlateau.add(temp);
        }
    }
    /**
     * permet d'ajouter les voisin a la liste de chaque case
     */
    private void rendLesCaseIntelligentes(){
        for (int i=0;i<this.lePlateau.size();i++){
            int taille=this.lePlateau.get(i).size();
            for (int j=0;j<taille;j++){
                // à gauche et à droite
                if (j-1>=0){lePlateau.get(i).get(j).ajouteVoisine(lePlateau.get(i).get(j-1));}
                if (j+1<this.nbColonnes){lePlateau.get(i).get(j).ajouteVoisine(lePlateau.get(i).get(j+1));}
                
                // en haut et en bas
                if (i-1>=0){lePlateau.get(i).get(j).ajouteVoisine(lePlateau.get(i-1).get(j));}
                if (i+1<this.nbLignes){lePlateau.get(i).get(j).ajouteVoisine(lePlateau.get(i+1).get(j));}

                //les diagonales en haut
                if (i-1>=0 && j+1<this.nbColonnes){lePlateau.get(i).get(j).ajouteVoisine(lePlateau.get(i-1).get(j+1));}
                if (i-1>=0 && j-1>=0){lePlateau.get(i).get(j).ajouteVoisine(lePlateau.get(i-1).get(j-1));}
                
                // les diagonale en bas
                if (i+1<this.nbLignes && j+1<this.nbColonnes){lePlateau.get(i).get(j).ajouteVoisine(lePlateau.get(i+1).get(j+1));}
                if (i+1<this.nbLignes && j-1>=0){lePlateau.get(i).get(j).ajouteVoisine(lePlateau.get(i+1).get(j-1));}

            }
        }
    }

    /**
     * permet de savoir combien de bombes contient le plateau
     * @return int
     */
    public int getNbTotalBombes(){
        return nbBombes;
    }
    /**
     * permet de savoir combien de colonnes à le plateau
     * @return int
     */
    public int getNbColonnes() {
        return nbColonnes;
    }
    /**
     * permet de savoir combien de ligne à le plateau
     * @return int
     */
    public int getNbLignes() {
        return nbLignes;
    }
    /**
     * permet d'avoir la case intelligente à la ligne,colonne
     * @param numLigne  ligne
     * @param numcol colonne
     * @return  la case intelligente
     */
    public CaseIntelligente getCase(int numLigne,int numcol){
        return lePlateau.get(numLigne).get(numcol);
    }
    /**
     * permet de savoir combien de case sont marquee dans le plateau
     * @return un entier
     */
    public int getNbCasesMarquees(){
        int cpt=0;
        for (int i=0;i<this.lePlateau.size();i++){
            int taille=this.lePlateau.get(i).size();
            for (int j=0;j<taille;j++){
                if (lePlateau.get(i).get(j).estMarquee()){cpt+=1;}
            }
        }
        return cpt;
    }
    /**
     * permet de savoir combien de case est decouverte
     * @return int
     */
    public int getNbCaseDecouverte(){
        int cpt=0;
        for (int i=0;i<this.lePlateau.size();i++){
            int taille=this.lePlateau.get(i).size();
            for (int j=0;j<taille;j++){
                if (lePlateau.get(i).get(j).estDecouverte()){cpt+=1;}
            }
        }
        return cpt;
    }
    /**
     * permet de poser des bombe dans le plateau de maniere aleatoire
     */
    protected void poseDesBombesAleatoirement(){
        Random generateur = new Random();
        for (int x = 0; x < this.getNbLignes(); x++){
            for (int y = 0; y < this.getNbColonnes(); y++){
                if (generateur.nextInt(100)+1 < this.pourcentageDeBombes){
                    this.poseBombe(x, y);
                    this.nbBombes = this.nbBombes + 1;
                }
            }
        }
    }
    /**
     * permet de poser des bombe à la ligne x et colonne y
     * @param x int
     * @param y int
     */
    public void poseBombe(int x, int y){
        lePlateau.get(x).get(y).poseBombe();
    }
    /**
     * permet de reset les case du plateau 
    */
    public void reset(){
        for (List<CaseIntelligente> l: this.lePlateau){
            for(Case c:l){
                c.reset();
            } 
        }
        this.nbBombes=0;
    }
}
