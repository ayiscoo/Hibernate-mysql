package com.javashark.hibernate.cars_main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.javashark.hibernate.cars.Cars;
import com.javashark.hibernate.cars.Color;

public class ReadCarColors {

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
		    int car_id=6;
			Cars cars = session.get(Cars.class, car_id );
		    System.out.println(""+ cars);
		    System.out.println("**********car colors************");
		    System.out.println(""+cars.getColorList());
		    
			session.getTransaction().commit();
			
			}catch (Exception exc){
			exc.printStackTrace();
			}finally{
			session.close();
			factory.close();
			}
				}

}
