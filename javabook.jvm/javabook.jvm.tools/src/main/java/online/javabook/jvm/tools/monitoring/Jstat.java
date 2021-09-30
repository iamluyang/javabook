package online.javabook.jvm.tools.monitoring;

/**
 * 查看Java进程的GC状态,一般可以配合jps使用，先查询从java的进程id
 *
 * jstat -gc 进程id
 *
 * S0C    S1C    S0U    S1U      EC       EU        OC          OU       MC      MU      CCSC   CCSU      YGC     YGCT   FGC    FGCT     GCT
 * 21504.0 21504.0  0.0    0.0   131584.0  3947.9   138240.0    6106.6   21296.0 20643.8 2432.0 2242.9      1    0.008   1      0.023    0.030
 */
public class Jstat {
}
