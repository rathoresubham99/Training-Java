package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.springframework.context.annotation.Configuration;
import org.hibernate.cfg.Configuration;



public class HibernateUtil {
	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;
	
	//factory method
	public static SessionFactory getSessionFactory(){
		if(sessionFactory==null){
			Configuration conf=new Configuration();
			conf.configure("hibernate.cfg.xml");
			StandardServiceRegistryBuilder registryBuilder=new 	StandardServiceRegistryBuilder();
			registry = registryBuilder.applySettings(conf.getProperties()).build();
			
			MetadataSources sources=new MetadataSources();
			
			Metadata metadata=sources.getMetadataBuilder().build();
			
			sessionFactory=(SessionFactory) metadata.getSessionFactoryBuilder().build();
		}
		
		return sessionFactory;
	}

}
