import java.util.ArrayList;

import iiitb.ess201a7.a7base.*;

// import each of the fleets to be considered in the simulation
import iiitb.ess201a7.r16123.*;
// import iiitb.ess201a7.r16006.*;
// import iiitb.ess201a7.r16062.*;
// import iiitb.ess201a7.r16036.*;


public class Demo {

	public static void main(String[] args) {

		Platform pf = new Platform();
		//Display disp = new TextDisplay();
		Display disp = new SwingDisplay();

		App app = new App(pf, disp);

		ArrayList<Fleet> fleets = new ArrayList<Fleet>();

		// repeat the following for each fleet to be added,
		{
			Fleet f1 = new Fleet16123("blue"); // note: colour currently not used by Display
			pf.addFleet(f1);
			fleets.add(f1);

			// Fleet f2 = new Fleet16006("blue"); // note: colour currently not used by Display
			// pf.addFleet(f2);
			// fleets.add(f2);

			// Fleet f3 = new Fleet16062("blue"); // note: colour currently not used by Display
			// pf.addFleet(f3);
			// fleets.add(f3);

			// Fleet f4 = new Fleet16036("blue"); // note: colour currently not used by Display
			// pf.addFleet(f4);
			// fleets.add(f4);

			// f1 = new Fleet16123("blue"); // note: colour currently not used by Display
			// pf.addFleet(f1);
			// fleets.add(f1);
		}

		// instantiate cars for the fleets
		int j = 1;
		for(Fleet fleet: fleets) {
			for (int i = 0; i < 5; i++) {
				fleet.addCar(20 + i); // add cars, assigning max speed to each car
			}

			ArrayList<? extends Car> cars = fleet.getCars();
			for (int i = 0; i < cars.size(); i++) {
				cars.get(i).setLocation(new Location(j * 40, i * 50 + 10*j));
			}
			j++;
		}

		// start the app - populate the display and run the simulation
		app.init();

		// This will be replaced by callbacks from Display once the UI is in place

		//disp.requestTrip(new Location(10, 10), new Location(200,200));
		//disp.requestTrip(new Location(250, 100), new Location(100,300));

	}

}
