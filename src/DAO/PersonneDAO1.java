package DAO;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

import Metier.personne;
import jdbc.DbConnection;

public class PersonneDAO1 implements DAO<PersonneDAO1> {
	private Connection conn;
   
	

	public PersonneDAO1() {
		
		try {
			conn = DbConnection.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*public PersonneDAO1 get(String nom) {
		PersonneDAO1 personne = null;
		String requet = "select * from personne where nom = " +  nom;
		System.out.println(requet);
		try {
			Statement pstm = conn.createStatement();
			ResultSet rs = pstm.executeQuery(requet);
			while (rs.next()) {
				String Nom = rs.getString(1);
				String prenom = rs.getString(2);
                int score = rs.getInt(3);
				System.out.println("nom: " + Nom + " prenom:" + prenom + " score:" + score);
				personne = new PersonneDAO1();
				System.out.println(personne.toString());

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return personne;
	}*/

	/*
	  @param t
	*/
	public void save(personne t) {
		 String requet = "insert into utilisateurs values('" +  t.getNom() + "','" +t.getPrenom() + "'," +t.getScore()+");";
         System.out.println(requet);
         try {
             Statement stm = conn.createStatement();
             if (stm.executeUpdate(requet)!=0) {
                 System.out.println("Insertion validé");
             }
             else {
                 System.out.println("Erreur d'insertion");
             }
 
         

			
		
    
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
		
		
	

	}

	public void update(personne  t) {
		String requet1 ="UPDATE utilisateurs SET score = '"+t.getScore()+"' WHERE  nom =' "+t.getNom()+"';";
		System.out.println(requet1);
		try {
			Statement stm = conn.createStatement();
			if (stm.executeUpdate(requet1)!=0) {
				System.out.println("Update validé");
			}
			else {
				System.out.println("Erreur d'update");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
		

	}

	public void delete(PersonneDAO1 t) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		PersonneDAO1 pdao = new PersonneDAO1();

		pdao.getAll();

	}

	/*@Override
	public void save(PersonneDAO1 t) {
		// TODO Auto-generated method stub
		
	}*/

	/*@Override
	public void update(PersonneDAO1 t) {
		// TODO Auto-generated method stub
		update(t);
		
	}*/

	
	 
	
	    
	

	


	public PersonneDAO1 get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(PersonneDAO1 t) {
		// TODO Auto-generated method stub
		
	}

	public void update(PersonneDAO1 t) {
		
		
	}

	@Override
	public List<PersonneDAO1> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	

	

	

}


