package method;

import java.util.ArrayList;

import adt.Ladder;
import adt.Monkey;

public class strategy2 implements Strategy{

	@Override
	public int chooseLadder(Monkey m, ArrayList<Ladder> li) {
		synchronized(this) {
			for (int i = 0; i < li.size(); i++) {
				if (!li.get(i).existmonkey()) {
					m.setladderi(i + 1);
					li.get(i).firstlocation(m);
					return i;
				}
			}
			return -1;
		}
	}
	
}
