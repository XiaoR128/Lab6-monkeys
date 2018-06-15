package adt;

import java.util.ArrayList;

public class Ladder {
	private boolean[] b=new boolean[21];
	private String dire;
	private ArrayList<Stage> stage = new ArrayList<>();
	
	/**
	 * 构造函数
	 */
	public Ladder() {
		for(int i=1;i<21;i++) {
			b[i] = false;
		}
		for(int i=0;i<21;i++) {
			Stage e = new Stage();
			stage.add(e);
		}
	}
	
	/**
	 * 某个猴子第一次踏上梯子的第一个踏板
	 * @param 某个猴子m
	 */
	public void firstlocation(Monkey m) {
		dire=m.getdirection();
		b[1]=true;
		stage.get(1).setmonkey(true);
		m.setposition(1);
	}
	
	/**
	 * 设置梯子的阶梯i上有猴子
	 * @param 阶梯号i
	 */
	
	public void setmonkeyi(int i) {
		b[i] = true;
		stage.get(i).setmonkey(true);
	}
	
	/**
	 * 清除阶梯i上面的猴子
	 * @param 阶梯号i
	 */
	public void clearmonkeyi(int i) {
		b[i] = false;
		stage.get(i).setmonkey(false);
	}
	
	/**
	 * 返回阶梯号为i的阶梯对象
	 * @param 阶梯号i
	 * @return 阶梯号为i的对象
	 */
	public Stage getstagei(int i) {
		return stage.get(i);
	}
	
	
	/**
	 * 判断梯子上的第i个阶梯是否有猴子
	 * @param 当前梯子的阶梯号i
	 * @return 阶梯号i上是否存在猴子
	 */
	public boolean getexistmonkey(int i) {
		return b[i];
	}
	
	/**
	 * 获取梯子上猴子的方向
	 * @return 梯子上猴子的方向
	 */
	public String getdirection() {
		return dire;
	}
	
	/**
	 * 判断梯子上是否存在猴子
	 * @return 存在的话返回true，否则返回false
	 */
	public boolean existmonkey() {
		for(int i=1;i<=20;i++) {
			if(b[i]==true) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 判断桥上猴子m的速度以内的范围是否存在猴子
	 * @param 猴子的速度范围x
	 * @param 猴子对象m
	 * @return 如果猴子m前面的速度x范围内有另外的猴子对象，返回true，否则返回false
	 */
	public boolean overx(int x,Monkey m) {
		if(m.getposition()+x>20) {
			for(int i=m.getposition()+1;i<=20;i++) {
				if(b[i]==true) {
					return true;
				}
			}
		}else {
			for(int i=m.getposition()+1;i<=m.getposition()+x;i++) {
				if(b[i]==true) {
					return true;
				}
			}
		}
		return false;
	}
}
