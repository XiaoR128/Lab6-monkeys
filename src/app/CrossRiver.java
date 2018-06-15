package app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import adt.Ladder;
import adt.Monkey;
import adt.MonkeyGenerator;
import method.ListLadder;
import method.MonkeyRunnable;
import method.MyLogHander;
import method.Strategy;
import method.strategy1;
import method.strategy2;

public class CrossRiver {
	//日志参数
	private static String name = MonkeyRunnable.class.getName();      
	private static Logger log = Logger.getLogger(name);
	public static ArrayList<Ladder> list=new ArrayList<>();
	
	public static synchronized void main(String[] args) throws InterruptedException, BrokenBarrierException {
		System.out.println("请输入数据n(桥的个数),t(两次产生猴子之间的时间差),N(猴子总数),k(每次产生的猴子数)：(按照列出的顺序以空格分开)");
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
		
		FileHandler fileHandler;
		try {
			fileHandler = new FileHandler("src/logger/logger1.txt");
	        fileHandler.setLevel(Level.INFO); 
	        fileHandler.setFormatter(new MyLogHander());
	        log.addHandler(fileHandler); 
		} catch (SecurityException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} 
		
		Strategy stra1 = new strategy1();
		Strategy stra2 = new strategy2();
		Strategy[] st = {stra1,stra2};
		List<Monkey> lili = new ArrayList<>();
		
		final CountDownLatch latch = new CountDownLatch(N);
		
		for(int i=1;i<=p;i++) {
			int s;
			if(flag==1&&i==p) {
				s=N%k;
			}else {
				s=k;
			}
			//创建猴子
			List<Monkey> li = new MonkeyGenerator().createMonkey(i, s, MV);
			lili.addAll(li);
			
			for(int j=0;j<li.size();j++) {
				int index = new Random().nextInt(2);
				new Thread(new MonkeyRunnable(li.get(j),st[index],latch)).start();
			}
			if(i<p) {
				try {
					Thread.sleep(t*1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		latch.await();
		int max=0,m=0;
		for(int i=0;i<lili.size();i++) {
				if(lili.get(i).getspendtime()>max) {
					max=lili.get(i).getspendtime();
					m=i;
				}
		}
		int size = lili.size();
		int sum=0;
		int ss=N*(N-1)/2;
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(i!=j) {
					if((lili.get(i).getid()-lili.get(j).getid())*(lili.get(i).getspendtime()-lili.get(j).getspendtime())>=0) {
						sum+=1;
					}else {
						sum+=-1;
					}
				}
			}
		}
		int t1=lili.get(m).getid()/10;
		float time=(float)(max+t1);
		float nn = (float) N;
		float th = (float)nn/time;
		float f = (float)sum/ss;
		log.info("吞吐率Th="+th);
		log.info("公平性:"+f);
		log.info("参数信息:"+"n="+n+" t="+t+" N="+N+" k="+k);
	}
}
