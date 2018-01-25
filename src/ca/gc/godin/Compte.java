package ca.gc.godin;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class Compte {

	public String numero;
	private String type;
	private double solde;
	private  String devise;




	public Compte(String numero, String type,double solde, String devise) {

		this.numero = numero;
		this.type = type;
		this.solde=solde;
		this.devise = devise;
	}
	public String getNumero() {
		return numero;
	}

	public String toString() { 
		return " [Numero\t=" + numero + ", \tType= " + type + ", \tSolde= " + solde + ", \tDevise=" + devise + "].";
	}



	public Compte(String compteCSV){
		StringTokenizer tokens = new StringTokenizer(compteCSV, ";");
		numero = tokens.nextToken();
		type = tokens.nextToken();
		solde = Double.parseDouble(tokens.nextToken());
		devise = tokens.nextToken();

	}

	public String toCSV(){
		return numero+";"+type+";"+solde+";"+devise;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getSolde(){
		return solde;
	}
	public void setSolde(double solde){
		this.solde=solde;
	}
	public String getDevise() {
		return devise;
	}

	public void setDevise(String devise) {
		this.devise = devise;
	}

	public void CredierCompte(double montant) {
		solde+=montant;
	}
	public void DebiterCompte (double montant){
		if (montant<solde){
			solde-=montant;

			JOptionPane.showMessageDialog(null," votre nouveaux solde est :"+solde);
		}

		else 
			JOptionPane.showMessageDialog(null," Retrait impossible solde insuffissant");
	}                 


}

