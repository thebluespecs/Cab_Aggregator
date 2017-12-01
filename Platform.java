import java.util.ArrayList;
import iiitb.ess201a7.a7base.*;

public class Platform {
	private ArrayList<Fleet> listoffleet=new ArrayList<Fleet>();
// all the methods in this class need to be implemented

	public Platform() {

	}

	public void addFleet(Fleet f) {
		// Fleet fleetob=new Fleet16123();
		listoffleet.add(f);

	}

	// for a request defined as a Trip, find the best car by checking each of its fleets
	// and assigns the car to this trip
	public Car assignCar(Trip trip) {
		int i;double closedist=Double.POSITIVE_INFINITY;Car closest =null;
		for(i=0;i<listoffleet.size();i++){
			if(Math.sqrt(listoffleet.get(i).findNearestCar(trip.getStart()).distSqrd(trip.getStart()))<closedist){
				closedist=Math.sqrt(listoffleet.get(i).findNearestCar(trip.getStart()).distSqrd(trip.getStart()));
				closest=listoffleet.get(i).findNearestCar(trip.getStart());
			}
		}
		if(closest!=null)
			closest.assignTrip(trip);
		return closest;
	}

	// returns list of all cars (in all the fleets) managed by this platform
	public ArrayList<Car> findCars() {
		ArrayList<Car> allcars=new ArrayList<Car>();
		int i;ArrayList<? extends Car> carlist=new ArrayList<>();
		for(i=0;i<listoffleet.size();i++){
			carlist=listoffleet.get(i).getCars();
			int j;
			for(j=0;j<carlist.size();j++){
				allcars.add(carlist.get(j));
			}
		}
		return allcars;
	}
}
