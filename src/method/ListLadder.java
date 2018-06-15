package method;

import java.util.ArrayList;

import adt.Ladder;

public class ListLadder {
	private final ArrayList<Ladder> li = new ArrayList<>();
	
	public ListLadder(int n) {
		for(int i=1;i<n+1;i++) {
			Ladder la = new Ladder();
			li.add(la);
		}
	}
	
	public ArrayList<Ladder> getlistladder(){
		return li;
	}
}
