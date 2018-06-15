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
	//日志参数
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
		//java日志
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
			log.info("mokey:" + m.getid() + "正在岸边等待,方向是" + m.getdirection() + ",离出生" + k + "秒");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			p = stra.chooseLadder(m, CrossRiver.list);
			k++;
		}
		log.info("mokey:" + m.getid() + "正在第" + m.getladderi() + "架梯子的第" + m.getposition() + "个踏板上," + "方向是"
				+ m.getdirection() + ",离出生" + k + "秒");
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
					log.info("mokey:" + m.getid() + "方向是" + m.getdirection() + ",已经抵达岸边,共耗时" + (1 + y + k) + "秒");
					m.setspendtime(1+y+k);
					break;
				}
				if (a != 0) {
					y++;
					CrossRiver.list.get(p).clearmonkeyi(m.getposition());
					CrossRiver.list.get(p).setmonkeyi(a);
					m.setposition(a);
					log.info("mokey:" + m.getid() + "正在第" + m.getladderi() + "架梯子的第" + m.getposition() + "个踏板上" + "方向是"
							+ m.getdirection() + ",离出生" + (k + y) + "秒");
				} else if (a == 0) {
					log.info("mokey:" + m.getid() + "正在桥上等待,方向是" + m.getdirection() + ",离出生" + (k + y) + "秒");
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
