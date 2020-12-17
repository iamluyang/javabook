package com.javabook.reference.finalize;/** * @author Summer Lu * @email gmluyang@gmail.com * @date 2014-9-25 * */public class Alien {	/**	  *  被GC消亡的次数(最多1次)	 */	private int finalizeCount;		/**	  * 异形复活的次数(最多1次)	 */	private int reviveCount;		/**	  * 异形获得了宿主的引用	 */	Host host;	// finalize方法从不被任何给定对象的Java虚拟机调用多次	@Override	protected void finalize() {		/**		   *  通过垃圾收集执行对象的finalize方法时恢复的对象		 */		this.host.copy = this;		System.out.println("异形被GC第"+(++finalizeCount)+"次击中，"+		"第"+(++reviveCount)+"次借助宿主复活了.");	}}