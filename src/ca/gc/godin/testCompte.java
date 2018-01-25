package ca.gc.godin;
import javax.swing.JOptionPane;



public class testCompte {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Compte c1=new Compte ("123-001","cheque",3000,"cad");
		Compte c2=new Compte ("123-002","epargne",500,"usd");
JOptionPane.showMessageDialog(null, c1);
c1.CredierCompte(100);
c1.getSolde();
System.out.println(c1.getSolde());
c1.DebiterCompte(4000);
c1.toCSV();
System.out.println(c1.toCSV());
//c1.setDevise("fr");
 //System.out.println(c1.getDevise());
	}

}
