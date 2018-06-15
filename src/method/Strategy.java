package method;

import java.util.ArrayList;

import adt.Ladder;
import adt.Monkey;

public interface Strategy {
	public int chooseLadder(Monkey m,ArrayList<Ladder> li);
}
