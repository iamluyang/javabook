package online.javabook.design.rpc.core.api.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Visits the annotated elements of an object
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-11-21
 *
 */
public interface AnnotationVisitor {

	/**
	 * set the target object being visited. Invoked before any of the visit
	 * methods.
	 * 
	 * @see AnnotationProcessor
	 * 
	 * @param target
	 *            the target object
	 */
	void setTarget(Object target);

	/**
	 * return the list of annotations this visitor wants to be informed about.
	 * 
	 * @return list of annotation types to be informed about
	 * 
	 */
	List<Class<? extends Annotation>> getTargetAnnotations();

	/**
	 * visit an annotated class. Invoked when the class of an object is
	 * annotated by one of the specified annotations. <code>visitClass</code> is
	 * called for each of the annotations that matches and for each class.
	 * 
	 * @param clz
	 *            the class with the annotation
	 * @param annotation
	 *            the annotation
	 * 
	 */
	void visitClass(Class<?> clz, Annotation annotation);

	/**
	 * visit an annotated field. Invoked when the field of an object is
	 * annotated by one of the specified annotations. <code>visitField</code> is
	 * called for each of the annotations that matches and for each field.
	 * 
	 * @param field
	 *            the annotated field
	 * @param annotation
	 *            the annotation
	 * 
	 */
	void visitField(Field field, Annotation annotation);

	/**
	 * visit an annotated method. Invoked when the method of an object is
	 * annotated by one of the specified annotations. <code>visitMethod</code>
	 * is called for each of the annotations that matches and for each method.
	 * 
	 * @param method
	 *            the annotated fieldx
	 * @param annotation
	 *            the annotation
	 * 
	 */
	void visitMethod(Method method, Annotation annotation);
}
