
package ca.gc.godin;
import javax.swing.JOptionPane;

public class CompteBancaire {

	public static void main(String[] args) {
		GestionCompte  gc= new GestionCompte();
		gc.chargerComptes("resources\\listeComptes.dat");
		String menus = "Selectionner une option svp.\n\n";
		menus += "1) Ouvrir un compte.\n\n";
		menus += "2) Débiter un compte.\n\n";
		menus += "3) Créditer un compte.\n\n";
		menus += "4) Lister un compte.\n\n";
		menus += "5) Rechercher les Comptes.\n\n";
		menus += "6) Trier les comptes en orde croissant des soldes.\n\n";
		menus+=  "7) Sortir du programme.";
		int choix;

		do{
			choix = Integer.parseInt(JOptionPane.showInputDialog(menus));
			switch(choix){
			case 1 : {	//"1) Ouvrir un compte.\n\n";			
				ouvrirCompte(gc);
				gc.enregistrer("resources\\listeComptes.dat");
			}
			break;
			case 2 :{// "2) Débiter un compte.\n\n";

				String numeroCompte = JOptionPane.showInputDialog("Entrer le numero de compte svp.");
				Compte c = gc.rechercherCompte(numeroCompte);
				if(c!= null){	 
					
					Double montant=Double.parseDouble(JOptionPane.showInputDialog("Entrer le montant à débiter svp."));

					c.DebiterCompte(montant);
				}

				else{
					JOptionPane.showMessageDialog(null, "Le compte n'existe pas.");
				}					

			}


			break;
			case 3 :{ //"
				String numeroCompte = JOptionPane.showInputDialog("Entrer le compte ou voulez déposer de argent svp?");
				Compte c = gc.rechercherCompte(numeroCompte);
				if(c!= null){	 
					//Compte  trouvé
					Double montant=Double.parseDouble(JOptionPane.showInputDialog("Entrer le montant à deposer svp. "));

					c.CredierCompte(montant);
				}

				else{
					JOptionPane.showMessageDialog(null, "Le compte n'existe pas.");
				}				 	
			}
			break;
			case 4 :{ //"4) lister les Comptes\n\n";
				gc.afficherComptes();
			}
			break;				
			case 5 : {
				//rechercher un compte.
				String numeroCompte= JOptionPane.showInputDialog("Entrer le numéro de compte à rechercher svp.");
				Compte c = gc.rechercherCompte(numeroCompte);
				if(c!= null){	 
					
					JOptionPane.showMessageDialog(null,c);
				}
				else{
					JOptionPane.showMessageDialog(null, "Le compte n'existe pas.");
				}

			}
			break;

			case 6:
				gc.afficherComptesSoldeCroissant();
				gc.afficherComptes();

				break;
			case 7:{  //Sortir du programme
				JOptionPane.showMessageDialog(null, "Merci, au revoir.");
				
				break;
			}


			default : JOptionPane.showMessageDialog(null, "Choix invalide.");				
			}
		}while(choix != 7);	

      }

	
	//METHODE POUR AJOUTER UN COMPTE 
	public static void ouvrirCompte(GestionCompte gc) {
		String numeroCompte;
		boolean compteExiste;

		do{
			numeroCompte = JOptionPane.showInputDialog("Entrer le numero du Compte svp.");
			compteExiste = gc.rechercherCompte(numeroCompte) != null ? true : false;
			if(compteExiste){
				JOptionPane.showMessageDialog(null, "Le Compte existe déjà");
			}
		}while(compteExiste);
		String type = JOptionPane.showInputDialog("Entrer le type de Compte svp :Epargne ou Cheque.");
		double solde  =Double.parseDouble(JOptionPane.showInputDialog("Entrer le solde svp."));
		String devise =JOptionPane.showInputDialog("Entrer la devise du compte svp.");
		Compte c = new Compte(numeroCompte,type, solde, devise);
		gc.ajouterCompte(c);
	}	





}
