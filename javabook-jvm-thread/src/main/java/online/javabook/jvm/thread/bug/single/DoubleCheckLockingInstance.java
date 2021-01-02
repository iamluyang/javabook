package online.javabook.jvm.thread.bug.single;

public class DoubleCheckLockingInstance {
	   
    private static DoubleCheckLockingInstance single = null;

    public DoubleCheckLockingInstance() {

    }
   
    public static DoubleCheckLockingInstance getInstance(){
    	
        if (single == null) {
            synchronized (DoubleCheckLockingInstance.class) {
                if (single == null) {
                    single = new DoubleCheckLockingInstance();
                }
            }
        }
        
        return single;
    }

}