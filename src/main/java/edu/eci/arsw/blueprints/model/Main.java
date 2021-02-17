package edu.eci.arsw.blueprints.model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.services.BlueprintsServices;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		BlueprintsServices gc = ac.getBean(BlueprintsServices.class);
		Point[] pts=new Point[]{new Point(0, 0),new Point(10, 10),new Point(10, 10)};
		//Get Blueprint by Author and name
		try {
			gc.addNewBlueprint(new Blueprint("Laura", "thepizza",pts));
			System.out.println("----------Get Blueprint by Author and name---------");
			System.out.println(gc.getBlueprint("Laura","thepizza"));
			System.out.println("Filtered: "+ gc.getBlueprint("Laura","thepizza").getPoints().size());
		} catch (BlueprintNotFoundException | BlueprintPersistenceException | NullPointerException e ) {
			e.printStackTrace();
		}
		//Get Blueprints by Author
		try {
			gc.addNewBlueprint(new Blueprint("Angelica", "thecine",pts));
			gc.addNewBlueprint(new Blueprint("Angelica", "thetower",pts));
			System.out.println("----------Get Blueprints by Author----------------");
			System.out.println(gc.getBlueprintsByAuthor("Angelica"));
		} catch (BlueprintNotFoundException | BlueprintPersistenceException | NullPointerException e ) {
			e.printStackTrace();
		}
	}

}
