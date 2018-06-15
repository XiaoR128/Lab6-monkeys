package adt;

import java.util.ArrayList;

public class Ladder {
	private boolean[] b=new boolean[21];
	private String dire;
	private ArrayList<Stage> stage = new ArrayList<>();
	
	/**
	 * ���캯��
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
	 * ĳ�����ӵ�һ��̤�����ӵĵ�һ��̤��
	 * @param ĳ������m
	 */
	public void firstlocation(Monkey m) {
		dire=m.getdirection();
		b[1]=true;
		stage.get(1).setmonkey(true);
		m.setposition(1);
	}
	
	/**
	 * �������ӵĽ���i���к���
	 * @param ���ݺ�i
	 */
	
	public void setmonkeyi(int i) {
		b[i] = true;
		stage.get(i).setmonkey(true);
	}
	
	/**
	 * �������i����ĺ���
	 * @param ���ݺ�i
	 */
	public void clearmonkeyi(int i) {
		b[i] = false;
		stage.get(i).setmonkey(false);
	}
	
	/**
	 * ���ؽ��ݺ�Ϊi�Ľ��ݶ���
	 * @param ���ݺ�i
	 * @return ���ݺ�Ϊi�Ķ���
	 */
	public Stage getstagei(int i) {
		return stage.get(i);
	}
	
	
	/**
	 * �ж������ϵĵ�i�������Ƿ��к���
	 * @param ��ǰ���ӵĽ��ݺ�i
	 * @return ���ݺ�i���Ƿ���ں���
	 */
	public boolean getexistmonkey(int i) {
		return b[i];
	}
	
	/**
	 * ��ȡ�����Ϻ��ӵķ���
	 * @return �����Ϻ��ӵķ���
	 */
	public String getdirection() {
		return dire;
	}
	
	/**
	 * �ж��������Ƿ���ں���
	 * @return ���ڵĻ�����true�����򷵻�false
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
	 * �ж����Ϻ���m���ٶ����ڵķ�Χ�Ƿ���ں���
	 * @param ���ӵ��ٶȷ�Χx
	 * @param ���Ӷ���m
	 * @return �������mǰ����ٶ�x��Χ��������ĺ��Ӷ��󣬷���true�����򷵻�false
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
