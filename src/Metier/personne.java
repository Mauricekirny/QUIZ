package Metier;
import frontend.GrafiqueQuiz;
public class personne {
	private String Nom;
	private String Prenom;
    private int Score;
	public personne() {
		super();
	}
	public personne( String nom, String prenom,int Score) {
		super();
		this.Nom = nom;
		this.Prenom = prenom;
        this.Score = Score;
	}
	public int getScore() {
		
		
		return GrafiqueQuiz.redisplayScore();
	}

	public void setScore(int Score) {
	   Score = Score;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String prenom) {
		Prenom = prenom;
	}

	
	/*@Override
	public String toString() {
		return personne [" Nom=" + Nom + ", Prenom= " + Prenom + ", score="+score];
	}*/

}
