package online.javabook.jvm.objectinit.objecthead;

/**
 * # 对象头(Header)
 * ## 运行时元数据(Mark Word)
 *  哈希值(HashCode)
 *  GC分代年龄
 *  锁状态标志
 *  线程持有的锁
 *  偏向线程ID
 *  偏向时间戳
 * ## 类型指针
 *  指向类元数据InstanceKlass ,确定该对象所犀的类型
 *
 * 说明:如果是数组,还需记录数组的长度
 */
public class ObjectStructure {
}
