package adt;

public class Monkey {
	private final int ID;
	private final int v;
	private final String direction;
	private int position;
	private int ladderi;
	
	/**
	 * 构造函数
	 * @param 猴子的id
	 * @param 猴子的速度v
	 * @param 猴子的方向dir
	 */
	public Monkey(int id,int v,String dir) {
		this.ID = id;
		this.v = v;
		this.direction = dir;
		this.position = 0;
	}
	
	/**
	 * 返回猴子的id值
	 * @return 猴子的id值
	 */
	public int getid() {
		return this.ID;
	}
	
	/**
	 * 返回猴子的速度
	 * @return 猴子的速度v
	 */
	public int getv() {
		return this.v;
	}
	
	/**
	 * 返回猴子的方向
	 * @return 猴子的方向dir
	 */
	public String getdirection() {
		return this.direction;
	}
	
	/**
	 * 设置猴子在桥上的位置
	 * @param 桥上的位置i  1=<i<=20
	 */
	public void setposition(int i) {
		position = i;
	}
	
	/**
	 * 返回猴子在桥上的位置
	 * @return 猴子的位置position
	 */
	public int getposition() {
		return this.position;
	}
	
	/**
	 * 设置猴子在哪一个桥上
	 * @param 桥的标号i 1=<i<=5
	 */
	public void setladderi(int i) {
		this.ladderi = i;
	}
	
	/**
	 * 返回猴子所在桥的标号
	 * @return 桥的标号ladderi
	 */
	public int getladderi() {
		return this.ladderi;
	}
	
}
