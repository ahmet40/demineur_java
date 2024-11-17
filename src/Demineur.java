import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.crypto.Mac;

public class Demineur extends Plateau{
    private boolean gameOver=false;
    private int score =0;
    /**
     * permet de cree le jeu du demineur
     * @param l int nbligne
     * @param c int nbcolonne
     * @param p int pourcentage bombe
     */
    public Demineur(int l, int c,int p){
        super(l,c,p);
    }
    /**
     * permet de connaitre le score du joueur
     * @return int 
     */
    public int getScore() {
        return score;
    }
    /**
     * permet de reveler une case
     * @param x int ligne
     * @param y int colonne 
     */
    public void reveler(int x,int y){
        CaseIntelligente maCase=getCase(x, y);
        
        if (!maCase.estMarquee()){
            maCase.reveler();
            if (!maCase.contientUneBombe() && maCase.nombreBombesVoisines()==0) {
                innondation(x,y);
                
            }   
        }

        if (maCase.contientUneBombe()){
            for (int i=0;i<getNbLignes();i++){
                for (int j=0;j<getNbColonnes();j++){
                    getCase(i, j).reveler();
                
                }
            gameOver=true;
            }
        } 

        score +=1;
    } 
    /**
     * permet de reveler toutes les case qui ne contient pas de bombes et qui sont voisines avec la case qui à comme numero 0
     * @param x int position x
     * @param y int position y
     */
    private void innondation(int x, int y) {
        for (int i = x - 1; i <= x + 1; i++){
            for (int j = y - 1; j <= y + 1; j++){
                if (i >= 0 && i < this.getNbLignes() && j >= 0 && j < this.getNbColonnes() && (i != x || j != y)) {
                    CaseIntelligente c = getCase(i, j);
                    if (!c.contientUneBombe() && !c.estDecouverte()) {
                        reveler(i, j);
                    }
                }
            }
        }
        
    }
    /**
     * permet de marquer une case
     * @param x int ligne
     * @param y int colonne
     */
    public void marquer(int x,int y){
        getCase(x, y).marque();
    }
    /**
     * permet de savoir si on a gagne
     * @return boolean
     */
    public boolean estGagnee(){
        int i=(getNbColonnes()*getNbLignes())-getNbTotalBombes();
        return i==getNbCaseDecouverte();
    }
    /**
     * permet de savoir si on a perdu
     * @return
     */
    public boolean estPerdue(){
        for (int i=0;i<this.getNbLignes();i++){
            for(int j=0;j<this.getNbColonnes();j++){
                if (getCase(i, j).estDecouverte() && getCase(i, j).contientUneBombe()){
                    gameOver=true;
                }
            }
        }
        return gameOver;
    }
    /**
     * permet de reset le demineur
     */
    public void reset(){
        gameOver=false;
        score=0;
        super.reset();
    }
    


    public void affiche(){
        System.out.println("JEU DU DEMINEUR");
        // affichage de la bordure supérieure
        System.out.print("  ");
        for (int j=0; j<this.getNbColonnes(); j++){
            System.out.print("  "+j+" ");
        }
        System.out.print(" \n");
        
        // affichage des numéros de ligne + cases
        System.out.print("  ┌");
        for (int j=0; j<this.getNbColonnes()-1; j++){
                System.out.print("───┬");
        }
        System.out.println("───┐");
        
        // affichage des numéros de ligne + cases
        for (int i = 0; i<this.getNbLignes(); i++){
            System.out.print(i+" ");
            for (int j=0; j<this.getNbColonnes(); j++){
                System.out.print("│ "+this.getCase(i, j).toString() + " ");
            }
            System.out.print("│\n");
            
            if (i!=this.getNbLignes()-1){
                // ligne milieu
                System.out.print("  ├");
                for (int j=0; j<this.getNbColonnes()-1; j++){
                        System.out.print("───┼");
                }
                System.out.println("───┤");
            }
        }

        // affichage de la bordure inférieure
        System.out.print("  └");
        for (int j=0; j<this.getNbColonnes()-1; j++){
                System.out.print("───┴");
        }
        System.out.println("───┘");
        
        // affichage des infos 
        System.out.println("Nombres de bombes à trouver : " + this.getNbTotalBombes());
        System.out.println("Nombres de cases marquées : " + this.getNbCasesMarquees());
        System.out.println("Score : " + this.getScore());
    }

    
    public void nouvellePartie(){
        this.reset();
        this.poseDesBombesAleatoirement();
        this.affiche();
        Scanner scan = new Scanner(System.in).useDelimiter("\n");

        while (!this.estPerdue() || this.estGagnee()){
            System.out.println("Entrer une instruction de la forme R 3 2 ou M 3 2\npour Révéler/Marquer la case à la ligne 3 et à la colonne 2");
            String [] s = scan.nextLine().split(" ");
            String action = s[0];
            int x = Integer.valueOf(s[1]);
            int y = Integer.valueOf(s[2]);
            if (action.equals("M") || action.equals("m"))
                this.marquer(x, y);
            else if (action.equals("R") || action.equals("r"))
                this.reveler(x, y);
            this.affiche();
        }
        if (this.gameOver){
            System.out.println("Oh !!! Vous avez perdu !");
        }
        else{
            System.out.println("Bravo !! Vous avez gagné !");
        }
    }
}
