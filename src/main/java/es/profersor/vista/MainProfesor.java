package es.profersor.vista;

import org.hibernate.Session;

import es.profersor.modelo.Direccion;
import es.profersor.modelo.Profesor;
import es.profesor.utiles.Utilidades;

public class MainProfesor {

	public static void main(String[] args) {
		
		Direccion direccion = new Direccion ("Peña Cervera", 12, "Madrid", "Madrid");
		Profesor prof = new Profesor ("Gabriel", "García", direccion);
		
		Session sesion = Utilidades.getSessionFactory().openSession();
		
		sesion.beginTransaction();
		sesion.save(prof);
		sesion.getTransaction().commit();
		
		System.out.println(prof);
		
	}

}
