package GCCollections;

/**
 * 对象优先分配在Eden区
 * -XX:+PrintGCDetails -XX:+UseSerialGC -Xms20M -Xmx20M -Xmn10M
 *
 * 堆：20m
 * 新生代：10m，Eden=8m，S0=1m，S1=1m
 * 老年代：10m
 */
public class Test {
    private static final int _1MB = 1024 * 1024;

    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];//Eden
        allocation2 = new byte[2 * _1MB];//Eden
        allocation3 = new byte[2 * _1MB];//Eden
        // 出现Minor GC
        allocation4 = new byte[4 * _1MB];
    }

    public static void main(String[] args) throws Exception {
        testAllocation();
    }
}
