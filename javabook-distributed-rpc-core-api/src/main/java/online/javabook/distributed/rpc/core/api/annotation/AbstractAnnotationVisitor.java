package online.javabook.distributed.rpc.core.api.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-11-21
 *
 */
public abstract class AbstractAnnotationVisitor implements AnnotationVisitor {
	
    /**
     * target
     */
    protected Object target;
    
    /**
     * targetClass
     */
    protected Class<?> targetClass;    

    /**
     * targetAnnotations
     */
    private final List<Class<? extends Annotation>> targetAnnotations = new ArrayList<Class<? extends Annotation>>(); 
        
    /**
     * @param annotation
     */
    protected AbstractAnnotationVisitor(Class<? extends Annotation> annotation) {
    	this.targetAnnotations.add(annotation); 
    }

    /**
     * @param annotation
     */
    protected AbstractAnnotationVisitor(List<Class<? extends Annotation>> annotation) {
        this.targetAnnotations.addAll(annotation);
    }

    @Override
    public void setTarget(Object object) {
    	this.target = object;
    	this.targetClass = object.getClass();
    }

    /**
     * @return
     */
    public Object getTarget() { 
        return this.target;
    } 
    
    /**
     * @return
     */
    public Class<?> getTargetClass() { 
        return this.targetClass;
    } 

    /**
     * @param object
     * @param targetClass
     */
    public void setTarget(Object object, Class<?> targetClass) {
        this.target = object;
        this.targetClass = targetClass;
    }
    
    @Override
    public List<Class<? extends Annotation>> getTargetAnnotations() {
        return targetAnnotations;
    }

    @Override
    public void visitClass(Class<?> clz, Annotation annotation) {
        // complete
    }

    @Override
    public void visitField(Field field, Annotation annotation) {
        // complete
    }

    @Override
    public void visitMethod(Method method, Annotation annotation) {
        // complete
    }

}
