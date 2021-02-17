package edu.eci.arsw.blueprints.test.persistence.impl;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import edu.eci.arsw.blueprints.filter.impl.SubsamplingBlueprintFilter;
import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;

public class SumsamplingBlueprintFilterTest {

	 @Test
     public void subsamplingFiltering(){
		 List<Point> pointsp = new ArrayList<>();
         pointsp.add(new Point(5,5));
         pointsp.add(new Point(-6,-6));
         pointsp.add(new Point(1,1));
         
         SubsamplingBlueprintFilter sumsamplingFilter = new SubsamplingBlueprintFilter();
         Point puntos[] = {new Point(6,6), new Point(5,5), new Point(3,3), new Point(-6,-6), new Point(80,80), new Point(1,1)};

         Blueprint bp = new Blueprint("Milena","Theanimals",puntos);
         bp = sumsamplingFilter.reduceSize(bp);

         assertTrue(bp.getPoints().size() == pointsp.size());
     }
	 @Test
     public void subsamplingFiltering2(){
		 List<Point> pointsp = new ArrayList<>();
         pointsp.add(new Point(10,10));
         pointsp.add(new Point(14,14));
         
         SubsamplingBlueprintFilter sumsamplingFilter = new SubsamplingBlueprintFilter();
         Point[] puntos=new Point[]{new Point(0, 0),new Point(10, 10), new Point(14, 14)};

         Blueprint bp = new Blueprint("Cesar","Thecellplhone",puntos);
         bp = sumsamplingFilter.reduceSize(bp);
         System.out.println(bp.getPoints().size());
         System.out.println(pointsp.size());

         assertTrue(bp.getPoints().size() == pointsp.size());
     }
}
