package method;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import adt.Monkey;
import app.CrossRiver;

public class MonkeyRunnable implements Runnable{
	//��־����
	private static String name = MonkeyRunnable.class.getName();      
	private static Logger log = Logger.getLogger(name);
	
	private final Monkey m;
	private final Strategy stra;
	private CountDownLatch latch;
	public MonkeyRunnable(Monkey mm,Strategy stra,CountDownLatch latch) {
		this.m = mm;
		this.stra = stra;
		this.latch = latch;
	}
	
	public void run() {
		//java��־
		File file1 = new File("src/logger/logger1.txt");
		try {
			file1.delete();
			FileHandler fileHandler = new FileHandler("src/logger/logger1.txt"); 
	        fileHandler.setLevel(Level.INFO); 
	        fileHandler.setFormatter(new MyLogHander());
	        log.addHandler(fileHandler); 
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		int k=0;
		int p;
		p = stra.chooseLadder(m, CrossRiver.list);
		while (p == -1) {
			log.info("mokey:" + m.getid() + "���ڰ��ߵȴ�,������" + m.getdirection() + ",�����" + k + "��");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			p = stra.chooseLadder(m, CrossRiver.list);
			k++;
		}
		log.info("mokey:" + m.getid() + "���ڵ�" + m.getladderi() + "�����ӵĵ�" + m.getposition() + "��̤����," + "������"
				+ m.getdirection() + ",�����" + k + "��");
		int v = m.getv();
		int y = 0;
		while (m.getposition() <= 20) {
			int a = 0, b = 0;
			if (m.getposition() + v > 20 && !CrossRiver.list.get(p).overx(v, m)) {
				b = 1;
			}
			synchronized (CrossRiver.list.get(p).getstagei(m.getposition())) {
				for (int x = v; x >= 1; x--) {
					if(x+m.getposition()>20) {
						continue;
					}
					if (CrossRiver.list.get(p).getstagei(m.getposition() + x).getexistmonkey() == false && !CrossRiver.list.get(p).overx(x, m)) {
						a = m.getposition() + x;
						break;
					}
				}
				if (b == 1) {
					y++;
					CrossRiver.list.get(p).clearmonkeyi(m.getposition());
					log.info("mokey:" + m.getid() + "������" + m.getdirection() + ",�Ѿ��ִﰶ��,����ʱ" + (1 + y + k) + "��");
					m.setspendtime(1+y+k);
					break;
				}
				if (a != 0) {
					y++;
					CrossRiver.list.get(p).clearmonkeyi(m.getposition());
					CrossRiver.list.get(p).setmonkeyi(a);
					m.setposition(a);
					log.info("mokey:" + m.getid() + "���ڵ�" + m.getladderi() + "�����ӵĵ�" + m.getposition() + "��̤����" + "������"
							+ m.getdirection() + ",�����" + (k + y) + "��");
				} else if (a == 0) {
					log.info("mokey:" + m.getid() + "�������ϵȴ�,������" + m.getdirection() + ",�����" + (k + y) + "��");
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
//		CrossRiver.list.get(p).cleardata();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		latch.countDown();
	}
}
