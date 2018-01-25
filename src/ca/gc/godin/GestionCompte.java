package ca.gc.godin;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/* il me manque la methode pour trier le tableau par solde croissant des soldes,  IL FAUT COPIER UN TABLEAU OBJET 
 
 for(int i = 0; i < nbreCompte i++;j=i+1){
           
		if(listeComptes[i].getSode()>listeComptes[j].getSode() ){
		Compte	cTEmps=listeComptes[i];
		    listeComptes[i]= listeComptes[j];
	        listeComptes[j]=cTemps;
			       
			}
		}
 * */
import javax.swing.JOptionPane;

public class GestionCompte {
	
	private int nbreCompte;
	private Compte listeComptes[];

	public GestionCompte(){
		
		this.nbreCompte=0;
		int maxCompte=20;
		listeComptes= new Compte[maxCompte];
	}
	
	public void ajouterCompte(Compte c) {
		
		if(nbreCompte < listeComptes.length){
			listeComptes[nbreCompte++] = c;
		}
		else{
			JOptionPane.showMessageDialog(null, "nombre de Compte maximum est atteint");
		    }
	      }

	public Compte rechercherCompte(String numeroCompte){
		Compte c1= null;
		for(int i = 0; i < nbreCompte && (c1== null); i++){
			if(listeComptes[i].getNumero().equals(numeroCompte)){
				c1= listeComptes[i];
			}
		}
		return c1;
	    }
	//METHODE POUR AFFICHER LE TABLEAU COMPORTANT LES OBJET COMPTE	
	public void afficherComptes(){
		String affichageListeComptes = " ";
		for(int i = 0; i < nbreCompte; i++){
			affichageListeComptes += listeComptes[i] + "\n\n";
		}
		JOptionPane.showMessageDialog(null, affichageListeComptes);
	}

	//Afficher le solde croissant
	
	public void afficherComptesSoldeCroissant(){
		for (int i=0; i<nbreCompte-1;i++){
			for (int j=i+1;j<nbreCompte;j++){
		
		if (listeComptes[i].getSolde()>listeComptes[j].getSolde()){
			Compte ctemps=listeComptes[i];
			listeComptes[i]=listeComptes[j];
			listeComptes[j]=ctemps;
                }
			        }
			}
		afficherComptes();
		
	}
	
	
	//
	public void chargerComptes(String nomFichier){
	try{
		FileReader fr = new FileReader(nomFichier);
		BufferedReader br = new BufferedReader(fr);/*CHARGER LE FICHIER EN MOURCEAUX*/
		String ligneLue;
		do{
			ligneLue = br.readLine();
			if(ligneLue!= null){
				Compte c = new Compte(ligneLue);
				ajouterCompte(c);
			}
		}while(ligneLue != null);
		br.close();			
	}
	catch(FileNotFoundException ex){
		JOptionPane.showMessageDialog(null, ex.getMessage());
	}
	catch(IOException ex){
		JOptionPane.showMessageDialog(null, ex.getMessage());
	}	

}
	
	
	
	
/*METHODE POUR enrigister  la méthode chargerFichier qui accepte le nom d’un fichier comme
	paramètre et qui charge le contenu du fichier dans le tableau listeComptes.*/
	
	public void enregistrer(String nomFichier){
		try{
			FileWriter fw = new FileWriter(nomFichier);
			PrintWriter pw = new PrintWriter(fw);
			for(int i = 0; i < nbreCompte; i++){
				if(i < nbreCompte - 1){
					pw.println(listeComptes[i].toCSV());
				}
				else{
					pw.print(listeComptes[i].toCSV());
				}
			}
			pw.close();
		}
		catch(IOException ex){
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}		
	}
	
	
	
	
	
	
}
	
