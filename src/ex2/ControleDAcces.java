package ex2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ControleDAcces {

	Map<Badge,Employe> badgeEmployeMap;
	Set<Employe> presences;
	public ControleDAcces(){
		badgeEmployeMap = new HashMap<>();
		presences = new HashSet<>();
	}
	
	// associe le badge à un employé
	public void donnerBadge (Badge b, Employe e){
		badgeEmployeMap.put(b,e);
	}
	
	// met à jour les employés présents dans le batiment
	public void entrerBatiment (Badge b){
		presences.add(badgeEmployeMap.get(b));
	}

	// met à jour les employés présents dans le batiment
	public void sortirBatiment (Badge b){
		presences.remove(badgeEmployeMap.get(b));
	}
	
	// renvoie vrai si l'employé est dans le batiment, faux sinon
	public boolean estDansBatiment (Employe e){
		return presences.contains(e);
	}

}
