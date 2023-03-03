import java.util.*;

public class MatriceDAdjacence extends Graph{
	
	private Map<Integer, Airport>  correspondanceIndiceAirport;
	private Map<Airport, Integer>  correspondanceAirportIndice;
	private Flight[][] matrice= new Flight[0][0];
	private int nbAirport=0;

	public MatriceDAdjacence() {
		super();
		correspondanceAirportIndice= new HashMap<Airport,Integer>();
		correspondanceIndiceAirport= new HashMap<Integer,Airport>();
	}

	@Override
	// Complexité: O(n)²
	protected void ajouterSommet(Airport a) {
		correspondanceIndiceAirport.put(nbAirport,a);
		correspondanceAirportIndice.put(a,nbAirport);
		nbAirport++;
		Flight[][] nouvelleMatrice = new Flight[nbAirport][nbAirport];
		for (int i = 0; i < nbAirport-1 ; i++) {
			for (int j = 0; j < nbAirport-1 ; j++) {
				nouvelleMatrice[i][j] = matrice[i][j];
			}
		}
		matrice = nouvelleMatrice;
	}

	@Override
	// Complexité: O(1)
	protected void ajouterArc(Flight f) {
		int indiceDepart = correspondanceAirportIndice.get(f.getSource()); 
		int indiceArrive = correspondanceAirportIndice.get(f.getDestination());
		matrice[indiceDepart][indiceArrive] = f;
	}

	@Override
	// Complexité: ?
	public Set<Flight> arcsSortants(Airport a) {
		int indiceAirport = correspondanceAirportIndice.get(a);
		Set<Flight> flights = new HashSet<>();
		Collections.addAll(flights, matrice[indiceAirport]);
		return flights;
	}

	@Override
	// Complexité: ?
	public boolean sontAdjacents(Airport a1, Airport a2) {
		int indiceA1 = correspondanceAirportIndice.get(a1);
		int indiceA2 = correspondanceAirportIndice.get(a2);
		return matrice[indiceA1][indiceA2] != null || matrice[indiceA2][indiceA1] != null;
	}
	
	

}
