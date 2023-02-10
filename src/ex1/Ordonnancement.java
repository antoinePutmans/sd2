package ex1;

import java.lang.reflect.Array;
import java.util.*;

public class Ordonnancement {
	public static final int NIVEAU_PRIORITE_MAX=5;

	Map<Integer, ArrayDeque<Tache>> listeTaches;

	public Ordonnancement(){
		listeTaches = new HashMap<>();
	}
	public void ajouterTache (String descriptif, int priorite){
		Tache tache = new Tache(descriptif,priorite);
		ArrayDeque<Tache> list;
		list = listeTaches.get(priorite);
		if (list == null){
		 	list = new ArrayDeque<>();
			list.add(tache);
			listeTaches.put(priorite,list);
			return;
		}
		list.addLast(tache);
	}
	
	//renvoie la tache prioritaire
	//renvoie null si plus de tache presente
	public Tache attribuerTache(){
		if(listeTaches.isEmpty()) return null;
		for (int i = NIVEAU_PRIORITE_MAX; i >= 1 ; i--) {
			ArrayDeque<Tache> arrayDeque = listeTaches.get(i);
			if (arrayDeque!=null){
				Tache tache = arrayDeque.pollFirst();
				if (arrayDeque.isEmpty()) listeTaches.remove(tache.getPriorite());
				return tache;
			}
		}
		return null;
	}
}
