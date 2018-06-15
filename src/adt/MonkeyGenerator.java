package adt;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MonkeyGenerator {
	public List<Monkey> createMonkey(int count,int k,int mv) {
		List<Monkey> li = new ArrayList<>();
		String[] str = {"L->R","R->L"};
		for(int j=1;j<=k;j++) {
			int id = count*10+j;
			int v = (int)(Math.random()*mv+1);
			int index = new Random().nextInt(2);
			String dir = str[index];
			Monkey m = new Monkey(id, v, dir);
			li.add(m);
		}
		return li;
	}
}
