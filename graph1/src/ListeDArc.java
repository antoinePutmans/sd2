import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ListeDArc extends Graph{
	
	private ArrayList<Flight> flights;

	public ListeDArc() {
		super();
		flights=new ArrayList<Flight>();
	}

	@Override
	// Complexité: o1
	protected void ajouterSommet(Airport a) {
	}

	@Override
	// Complexité: o1
	protected void ajouterArc(Flight f) {
		flights.add(f);
	}

	@Override
	// Complexité: O(N)
	public Set<Flight> arcsSortants(Airport a) {
		Set<Flight> sortants = new HashSet<>();
		for (Flight flight : flights) {
			if(flight.getSource().equals(a)) sortants.add(flight);
		}
		return sortants;
	}

	@Override
	// Complexité: O(N)
	public boolean sontAdjacents(Airport a1, Airport a2) {
		for (Flight flight : flights) {
			if (flight.getSource().equals(a1) && flight.getDestination().equals(a2) || flight.getSource().equals(a2) && flight.getDestination().equals(a1)) return true;
		}
		return false;
	}

}
