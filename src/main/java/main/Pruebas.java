package main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.TbUsuario;

public class Pruebas {

	public static void main(String[] args) {
System.out.println("-->>Listar<<---");
		
		// 1. fabrica el acceso a los datos
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("JPA_Class1x");
		// 2. crea el manejador de entidades
		EntityManager em = fabrica.createEntityManager();
		Query query = em.createNativeQuery("{usp_validaAcceso(?,?)}", TbUsuario.class);
		query.setParameter(1, "");
		query.setParameter(2, "");
		
		TbUsuario u = (TbUsuario)query.getSingleResult();
		if(u==null){
			System.out.println("El Usuario no existe");
		}else {
			System.out.println("Bienvenido: "+ u.getNomUsua());
		}
		 
		List<TbUsuario> lstUsuarios =query.getResultList();
		//List<TbUsuario> lstUsuarios =em.createQuery("Select a From TbUsuario a", TbUsuario.class).getResultList();
		
		
		System.out.println("==================================");
		System.out.println("Nro de usuarios: "+lstUsuarios.size());
		System.out.println("================================");
		
	}//

}
