package adt;

public class Stage {
	private boolean existmonkey;
	
	public Stage() {
		existmonkey =false;
	}
	
	/**
	 * ����̤�����Ƿ����޺���
	 * @param ����к��ӣ�aΪtrue������aΪfalse
	 */
	public void setmonkey(boolean a) {
		this.existmonkey = a;
	}
	
	/**
	 * ��ȡ̤���ϵ�״̬
	 * @return �Ƿ���ں��ӣ������ڣ�����true�����򣬷���false
	 */
	public boolean getexistmonkey() {
		return this.existmonkey;
	}
	
	/**
	 * ��̤���״̬���ó��޺��ӵ�״̬
	 */
	public void clearmonkey() {
		this.existmonkey=false;
	}
}
