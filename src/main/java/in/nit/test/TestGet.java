package in.nit.test;

import org.hibernate.Session;

import in.nit.model.ModuleInfo;
import in.nit.model.Project;
import in.nit.util.HibernateUtil;

public class TestGet {

	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		try(ses) {

			Project proj=ses.get(Project.class, 601);
			//Do not print complete object > may result Stack Overflow Error
			System.out.println(proj.getProjName());
			System.out.println(proj.getModules().get(0).getModuleCode());
			//--result must be same from two sides.. then valid bi-directional
			
			ModuleInfo mnfo=ses.get(ModuleInfo.class, 21);
			System.out.println(mnfo.getModuleCode());
			System.out.println(mnfo.getProject().getProjName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
