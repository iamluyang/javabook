package online.javabook.concurrent.cas.ref;

import online.javabook.concurrent.cas.unsafe.MyUnsafe;

import java.lang.reflect.Field;


public class ReflectionUtils {

	/**
	 * @param object
	 * @param fieldName
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 */
	@SuppressWarnings("restriction")
	public static void setUnsafeValue(Object object, String fieldName, Object fieldValue) throws NoSuchFieldException {
		
		// field
		Field field = object.getClass().getDeclaredField(fieldName);		
		
		// fieldOffset
		long fieldOffset = MyUnsafe.getUnsafe().objectFieldOffset (field);
		
		// putValue
		if(fieldValue.getClass()==boolean.class){
			MyUnsafe.getUnsafe().putBoolean(object, fieldOffset, (Boolean) fieldValue);
			
		}else if(fieldValue.getClass()==byte.class){
			MyUnsafe.getUnsafe().putByte(object, fieldOffset, (Byte) fieldValue);
			
		}else if(fieldValue.getClass()==short.class){
			MyUnsafe.getUnsafe().putShort(object, fieldOffset, (Short) fieldValue);
			
		}else if(fieldValue.getClass()==int.class){			
			MyUnsafe.getUnsafe().putInt(object, fieldOffset, (Integer) fieldValue);
			
		}else if(fieldValue.getClass()==long.class){
			MyUnsafe.getUnsafe().putLong(object, fieldOffset, (Long) fieldValue);
			
		}else if(fieldValue.getClass()==float.class){
			MyUnsafe.getUnsafe().putFloat(object, fieldOffset, (Float) fieldValue);
			
		}else if(fieldValue.getClass()==double.class){
			MyUnsafe.getUnsafe().putDouble(object, fieldOffset, (Double) fieldValue);
			
		}else {
			Object value = MyUnsafe.getUnsafe().getObject(object, fieldOffset);
			MyUnsafe.getUnsafe().putObject(object, fieldOffset, value);
			
		}
	}

	/**
	 * @param object
	 * @param fieldName
	 * @return
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 */
	@SuppressWarnings("restriction")
	public static Object getUnsafeValue(Object object, String fieldName) throws NoSuchFieldException {
		
		// field
		Field field = object.getClass().getDeclaredField(fieldName);		
		
		// fieldType
		Class<?> fieldType = field.getType();
		
		// fieldOffset
		long fieldOffset = MyUnsafe.getUnsafe().objectFieldOffset (field);
		
		// returnValue
		Object returnValue = null;
		
		// putValue
		if(fieldType==boolean.class){
			returnValue = MyUnsafe.getUnsafe().getBoolean(object, fieldOffset);
			
		}else if(fieldType==byte.class){
			returnValue = MyUnsafe.getUnsafe().getByte(object, fieldOffset);
			
		}else if(fieldType==short.class){
			returnValue = MyUnsafe.getUnsafe().getShort(object, fieldOffset);
			
		}else if(fieldType==int.class){			
			returnValue = MyUnsafe.getUnsafe().getInt(object, fieldOffset);
			
		}else if(fieldType==long.class){
			returnValue = MyUnsafe.getUnsafe().getLong(object, fieldOffset);
			
		}else if(fieldType==float.class){
			returnValue = MyUnsafe.getUnsafe().getFloat(object, fieldOffset);
			
		}else if(fieldType==double.class){
			returnValue = MyUnsafe.getUnsafe().getDouble(object, fieldOffset);
			
		}
		
		return returnValue;
	}
	
	/**
	 * @param object
	 * @param fieldName
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public static void setValue(Object object, String fieldName, Object fieldValue) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		
		// field
		Field field = object.getClass().getDeclaredField(fieldName);	
		field.setAccessible(true);

		// putValue
		if(fieldValue.getClass()==boolean.class){
			field.setBoolean(object, (Boolean) fieldValue);
			
		}else if(fieldValue.getClass()==byte.class){
			field.setByte(object, (Byte) fieldValue);
			
		}else if(fieldValue.getClass()==short.class){
			field.setShort(object, (Short) fieldValue);
			
		}else if(fieldValue.getClass()==int.class){			
			field.setInt(object, (Integer) fieldValue);
			
		}else if(fieldValue.getClass()==long.class){
			field.setLong(object, (Long) fieldValue);
			
		}else if(fieldValue.getClass()==float.class){
			field.setFloat(object, (Float) fieldValue);
			
		}else if(fieldValue.getClass()==double.class){
			field.setDouble(object, (Double) fieldValue);
			
		}else {
			field.set(object, fieldValue);
			
		}			
	}

	/**
	 * @param object
	 * @param fieldName
	 * @return
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public static Object getValue(Object object, String fieldName) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		
		// field
		Field field = object.getClass().getDeclaredField(fieldName);		
		field.setAccessible(true);
		
		// get
		return field.get(object);
	}	
	
	public static void main(String[] args) {
		
	}
}
