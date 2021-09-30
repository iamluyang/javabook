package online.javabook.jvm.tuning.memory.heap.adjust;

/**
 * https://docs.oracle.com/javase/8/docs/technotes/tools/unix/java.html
 * --------------------------------------------------------------------
 * Large Pages
 * Also known as huge pages, large pages are memory pages that are significantly larger than the standard memory
 * page size (which varies depending on the processor and operating system). Large pages optimize processor Translation-Lookaside Buffers.
 * 大页面是显著大于标准内存页面大小（因处理器和操作系统而异）的内存页面。大页面优化处理器翻译后备缓冲区。
 *
 * A Translation-Lookaside Buffer (TLB) is a page translation cache that holds the most-recently used virtual-to-physical address translations.
 * TLB is a scarce system resource. A TLB miss can be costly as the processor must then read from the hierarchical page table, which may require multiple memory accesses. By using a larger memory page size, a single TLB entry can represent a larger memory range. There will be less pressure on TLB, and memory-intensive applications may have better performance.
 * 转换后备缓冲区 (TLB) 是一个页面转换缓存，用于保存最近使用的虚拟到物理地址转换。TLB是一种稀缺的系统资源。
 * TLB 未命中可能代价高昂，因为处理器必须随后从分层页表中读取，这可能需要多次内存访问。通过使用更大的内存页面大小，单个 TLB 条目可以代表更大的内存范围。
 * TLB 压力会更小，内存密集型应用可能会有更好的性能。
 *
 * However, large pages page memory can negatively affect system performance. For example, when a large mount of memory is pinned by an application,
 * it may create a shortage of regular memory and cause excessive paging in other applications and slow down the entire system. Also,
 * a system that has been up for a long time could produce excessive fragmentation, which could make it impossible to reserve enough large page memory.
 * When this happens, either the OS or JVM reverts to using regular pages.
 * 但是，大页面页面内存会对系统性能产生负面影响。例如，当应用程序固定大量内存时，可能会导致常规内存短缺，并导致其他应用程序中的过度分页并降低整个系统的速度。
 * 此外，长时间运行的系统可能会产生过多的碎片，从而无法保留足够大的页面内存。发生这种情况时，操作系统或 JVM 将恢复使用常规页面。
 */
public class UseLargePage {
}
