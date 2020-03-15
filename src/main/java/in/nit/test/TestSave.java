package in.nit.test;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.nit.model.ModuleInfo;
import in.nit.model.Project;
import in.nit.util.HibernateUtil;

public class TestSave {

	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		try(ses) {
			tx=ses.beginTransaction();

			ModuleInfo m1=new ModuleInfo(21, "MA", 3.2);
			ModuleInfo m2=new ModuleInfo(22, "MA", 3.2);
			ModuleInfo m3=new ModuleInfo(23, "MA", 3.2);
			
			Project p1=new Project(601, "P1", "NIT", 65230.50,null);
			p1.setModules(Arrays.asList(m1,m2,m3));
		
			//only for bi-directional link
			m1.setProject(p1);
			m2.setProject(p1);
			m3.setProject(p1);
			
			ses.save(p1);
			
			tx.commit();
		} catch (Exception e) {
			if(tx!=null && tx.getStatus().canRollback()) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}
}
