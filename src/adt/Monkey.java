package adt;

public class Monkey {
	private final int ID;
	private final int v;
	private final String direction;
	private int position;
	private int ladderi;
	private int time;
	
	/**
	 * ���캯��
	 * @param ���ӵ�id
	 * @param ���ӵ��ٶ�v
	 * @param ���ӵķ���dir
	 */
	public Monkey(int id,int v,String dir) {
		this.ID = id;
		this.v = v;
		this.direction = dir;
		this.position = 0;
	}
	
	/**
	 * ���غ��ӵ�idֵ
	 * @return ���ӵ�idֵ
	 */
	public int getid() {
		return this.ID;
	}
	
	/**
	 * ���غ��ӵ��ٶ�
	 * @return ���ӵ��ٶ�v
	 */
	public int getv() {
		return this.v;
	}
	
	/**
	 * ���غ��ӵķ���
	 * @return ���ӵķ���dir
	 */
	public String getdirection() {
		return this.direction;
	}
	
	/**
	 * ���ú��������ϵ�λ��
	 * @param ���ϵ�λ��i  1=<i<=20
	 */
	public void setposition(int i) {
		position = i;
	}
	
	/**
	 * ���غ��������ϵ�λ��
	 * @return ���ӵ�λ��position
	 */
	public int getposition() {
		return this.position;
	}
	
	/**
	 * ���ú�������һ������
	 * @param �ŵı��i 1=<i<=5
	 */
	public void setladderi(int i) {
		this.ladderi = i;
	}
	
	/**
	 * ���غ��������ŵı��
	 * @return �ŵı��ladderi
	 */
	public int getladderi() {
		return this.ladderi;
	}
	
	/**
	 * ���ù��ӻ��ѵ�ʱ��
	 * @param ���ӵ�time
	 */
	public void setspendtime(int time) {
		this.time=time;
	}
	
	/**
	 * ��ȡ���ӵ�ʱ��
	 * @return ���ӵ�ʱ��time
	 */
	public int getspendtime() {
		return time;
	}
}
