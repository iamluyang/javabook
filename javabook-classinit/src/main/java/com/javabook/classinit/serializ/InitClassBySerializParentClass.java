package com.javabook.classinit.serializ;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.javabook.classinit.ParentClass;

/**
 * <ul>以反序列化的方式获取对象
 * 	<li>观察类型的初始化顺序（当前类的静态块执行了，父类的静态块没有执行）
 *  <li>观察类型的初始化次数
 * 	<li>观察对象是否被初始化(当前类和父类的的构造函数没有执行)
 * </ul>
 * @author LuYang
 *
 */
public class InitClassBySerializParentClass {

	/**
	 * @param objects
	 * @param filename
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void writeObjectsToFile(Object[] objects, String filename) 
		throws FileNotFoundException, IOException {
		
		File file = new File(filename);
		ObjectOutputStream oos = new ObjectOutputStream(
		new FileOutputStream(file));
		for (Object object : objects) {
			oos.writeObject(object);
		}
		oos.close();
	}

	/**
	 * @param filename
	 * @return
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static Object[] readObjectsFromFile(String filename)
			throws IOException, ClassNotFoundException {

		File              file = new File(filename);
		FileInputStream   fis  = new FileInputStream(file);
		ObjectInputStream ois  = new ObjectInputStream(fis);

		List<Object> list = new ArrayList<>();
		while (fis.available() > 0) {
			list.add(ois.readObject());
		}
		ois.close();
		return list.toArray();
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		//ParentClass[] classInits = { new ParentClass(), new ParentClass() };
		//InitClassBySerializDemo1.writeObjectsToFile(classInits, "data1.dat");
		try {
			
			System.out.println("第1次加载反序列化ParentClass");
			ParentClass classInit1 = (ParentClass) InitClassBySerializParentClass.readObjectsFromFile("data1.dat")[0];
			
			System.out.println("第2次加载反序列化ParentClass");
			ParentClass classInit2 = (ParentClass) InitClassBySerializParentClass.readObjectsFromFile("data1.dat")[0];
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}