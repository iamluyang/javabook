package online.javabook.distributed.rpc.core.api.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;


/**
 * Process instance of an annotated class.  This is a visitable
 * object that allows an caller to visit that annotated elements in
 * this class definition.  If a class level annotation is overridden
 * by a member level annotation, only the visit method for the member
 * level annotation
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-11-21
 *
 */
public class AnnotationProcessor {

    /**
     * target
     */
    private final Object target;
    
    /**
     * annotationTypes
     */
    private List<Class<? extends Annotation>> targetAnnotations;     
    
    /**
     * @param target
     */
    public AnnotationProcessor(Object target) {
    	
        if (target == null) {
            throw new IllegalArgumentException("INVALID_CTOR_ARGS"); 
        }
        this.target = target; 
    }
    
    /**
     * @param visitor
     */
    public void accept(AnnotationVisitor visitor) {
        accept(visitor, target.getClass());
    }

    /** 
     * Visits each of the annotated elements of the object.
     * 
     * @param visitor a visitor 
     * @param clazz the Class of the target object
     */
    public void accept(AnnotationVisitor visitor, Class<?> clazz) { 
        
    	// visitor
        if (visitor == null) {
            throw new IllegalArgumentException();
        }
        
        // annotationTypes
        this.targetAnnotations = visitor.getTargetAnnotations();
        
        // visitor
        visitor.setTarget(target);
        
        // processClass
        processClass(visitor, clazz);
        
        // processFields
        processFields(visitor, clazz); 
        
        // processMethods
        processMethods(visitor, clazz);
    } 

    /**
     * @param visitor
     * @param targetClass
     */
    private void processClass(AnnotationVisitor visitor, Class<? extends Object> targetClass) {
    	
        if (targetClass.getSuperclass() != null) {
            processClass(visitor, targetClass.getSuperclass());
        }
        
        // annotationType
        for (Class<? extends Annotation> annotationType : targetAnnotations) {
        	
        	// classAnnotation
            Annotation classAnnotation = targetClass.getAnnotation(annotationType);            
            if (classAnnotation != null) {
                visitor.visitClass(targetClass, classAnnotation);
            }
        }
    }  
    
    /**
     * @param visitor
     * @param targetClass
     */
    private void processFields(AnnotationVisitor visitor, Class<? extends Object> targetClass) { 
    	
        if (targetClass.getSuperclass() != null) {
            processFields(visitor, targetClass.getSuperclass());
        }
        
        // field
        for (Field field : targetClass.getDeclaredFields() ) {
        	
        	// annotationType
            for (Class<? extends Annotation> annotationType : targetAnnotations) {
            	
            	// fieldAnnotation
                Annotation fieldAnnotation = field.getAnnotation(annotationType); 
                if (fieldAnnotation != null) {
                    visitor.visitField(field, fieldAnnotation);
                }
            }
        }
    }     
    
	/**
	 * @param visitor
	 * @param targetClass
	 */
	private void processMethods(AnnotationVisitor visitor, Class<? extends Object> targetClass) {
	
	    if (targetClass.getSuperclass() != null) {
	        processMethods(visitor, targetClass.getSuperclass());
	    }
	    
	    // method
	    for (Method method : targetClass.getDeclaredMethods() ) {
	    	
	    	// annotationType
	        for (Class<? extends Annotation> annotationType : targetAnnotations) {
	        	
	        	// methodAnnotation
	            Annotation methodAnnotation = method.getAnnotation(annotationType); 
	            if (methodAnnotation != null) {
	                visitor.visitMethod(method, methodAnnotation);
	            }
	        }
	    }
	}

}
