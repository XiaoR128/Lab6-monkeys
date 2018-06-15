package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


import adt.Ladder;
import adt.Monkey;
import adt.MonkeyGenerator;
import method.ListLadder;
import method.MonkeyRunnable;
import method.Strategy;
import method.strategy1;
import method.strategy2;

public class CrossRiver {
	public static ArrayList<Ladder> list=new ArrayList<>();
	
	public static void main(String[] args) {
		System.out.println("请输入数据n,t,N,k：(按照列出的顺序以空格分开)");
		Scanner scan = new Scanner(System.in);
		String[] str = scan.nextLine().split("\\s+");
		scan.close();
		int n = Integer.parseInt(str[0]);
		int t = Integer.parseInt(str[1]);
		int N = Integer.parseInt(str[2]);
		int k = Integer.parseInt(str[3]);
		int MV = 5;
		int p,flag=0;
		list = new ListLadder(n).getlistladder();
		if(N % k==0) {
			p = N/k;
		}else {
			p = N/k+1;
			flag=1;
		}
		
		Strategy stra1 = new strategy1();
		Strategy stra2 = new strategy2();
		Strategy[] st = {stra1,stra2};
		
		for(int i=1;i<=p;i++) {
			int s;
			if(flag==1&&i==p) {
				s=N%k;
			}else {
				s=k;
			}
			//创建猴子
			List<Monkey> li = new MonkeyGenerator().createMonkey(i, s, MV);
			
			for(int j=0;j<li.size();j++) {
				int index = new Random().nextInt(2);
				new Thread(new MonkeyRunnable(li.get(j),st[index])).start();
			}
			if(i<p) {
				try {
					Thread.sleep(t*1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
