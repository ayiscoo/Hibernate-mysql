package com.javashark.hibernate.cars_main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.javashark.hibernate.cars.Cars;
import com.javashark.hibernate.cars.Color;




public class hibernate_add_cars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  SessionFactory factory = new Configuration()
		                          .configure("hibernate.cfg.xml")
		                          .addAnnotatedClass(Cars.class)
		                           .addAnnotatedClass(Color.class)
		                          .buildSessionFactory();
         Session session = factory.getCurrentSession();
         try{
        	 session.beginTransaction();
        	 
        	 Cars cars = new Cars("TOYATA","2011");
        	 
        	 Color color1 = new Color("Voilet");
        	 Color color2 = new Color("Indigo");
        	 Color color3 = new Color("Brown");
        	 Color color4 = new Color("Blue");
        	 
        	cars.addColors(color1);
        	cars.addColors(color2);
        	cars.addColors(color3);
        	cars.addColors(color4);
        	
        	 session.save(cars);
        	 session.save(color1);
        	 session.save(color2);
        	 session.save(color3);
        	 session.save(color4);
        	 
        	 session.getTransaction().commit();
        	 
         }catch (Exception exc){
        	  exc.printStackTrace();
         }finally{
        	 session.close();
        	 factory.close();
         }


}
	
}
