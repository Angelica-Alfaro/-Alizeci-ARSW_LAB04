package edu.eci.arsw.blueprints.test.persistence.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import edu.eci.arsw.blueprints.filter.impl.RedundancyBlueprintFilter;
import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;

public class RedundancyBlueprintFilterTest {
	
	  @Test
      public void filterRepeated() {
          List<Point> pointsp = new ArrayList<>();
          pointsp.add(new Point(3, 3));
          pointsp.add(new Point(50, 50));
          pointsp.add(new Point(-6, -6));
          
          RedundancyBlueprintFilter reduceFilter = new RedundancyBlueprintFilter();
          Point points[] = {new Point(3, 3), new Point(3, 3), new Point(50, 50), new Point(50, 50), new Point(-6, -6), new Point(-6, -6)};
          Blueprint bp = new Blueprint("Gaby", "Theeat", points);
          bp = reduceFilter.reduceSize(bp);
          
          List<Point> rt = bp.getPoints();
          for (int i = 0; i < rt.size(); i++){
              assertEquals(pointsp.get(i).getX(),rt.get(i).getX());
              assertEquals(pointsp.get(i).getY(),rt.get(i).getY());
          }
      }
}
