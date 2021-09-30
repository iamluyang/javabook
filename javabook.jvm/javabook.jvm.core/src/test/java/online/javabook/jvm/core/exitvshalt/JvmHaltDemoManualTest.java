package online.javabook.jvm.core.exitvshalt;

import online.javabook.jvm.core.exitvshalt.JvmExitAndHaltDemo;
import org.junit.Test;

public class JvmHaltDemoManualTest {

    JvmExitAndHaltDemo jvmExitAndHaltDemo = new JvmExitAndHaltDemo();

    @Test
    public void givenProcessComplete_whenHaltCalled_thenDoNotTriggerShutdownHook() {
        //jvmExitAndHaltDemo.processAndHalt();
    }

}
