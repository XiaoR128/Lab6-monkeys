package method;


import java.util.ArrayList;

import adt.Ladder;
import adt.Monkey;
import app.CrossRiver;

public class strategy1 implements Strategy{

	@Override
	public int chooseLadder(Monkey m, ArrayList<Ladder> li) {
		synchronized(this) {
			for(int i=0;i<CrossRiver.list.size();i++) {
				if(!CrossRiver.list.get(i).existmonkey()) {
					m.setladderi(i + 1);
					CrossRiver.list.get(i).firstlocation(m);
					return i;
				}
			}
			for(int i=0;i<CrossRiver.list.size();i++) {
				boolean b=CrossRiver.list.get(i).getdirection().equals(m.getdirection());
				boolean c=CrossRiver.list.get(i).getexistmonkey(1);
				if(b && !c) {
					m.setladderi(i + 1);
					m.setposition(1);
					CrossRiver.list.get(i).setmonkeyi(1);
					return i;
				}
			}
		}
		return -1;
	}
	
}
