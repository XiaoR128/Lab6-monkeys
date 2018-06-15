package adt;

public class Stage {
	private boolean existmonkey;
	
	public Stage() {
		existmonkey =false;
	}
	
	/**
	 * 设置踏板上是否有无猴子
	 * @param 如果有猴子，a为true，否则，a为false
	 */
	public void setmonkey(boolean a) {
		this.existmonkey = a;
	}
	
	/**
	 * 获取踏板上的状态
	 * @return 是否存在猴子，若存在，返回true，否则，返回false
	 */
	public boolean getexistmonkey() {
		return this.existmonkey;
	}
	
	/**
	 * 将踏板的状态设置成无猴子的状态
	 */
	public void clearmonkey() {
		this.existmonkey=false;
	}
}
