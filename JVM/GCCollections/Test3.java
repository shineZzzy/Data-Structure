package GCCollections;

public class Test3 {
    private static final int _1MB = 1024 * 1024;
    @SuppressWarnings("unused")
    public static void testAllocation() {
        byte[] allocation1,allocation2,allocation3;
        allocation1 = new byte[_1MB/4];
// 什么时候进入老年代取决于XX:MaxTenuringThreshold的设置
        allocation2 = new byte[4 * _1MB];
        //发生minor gc
        //gc后，a1、a2进入老年代，a3进入eden
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;//a3之前指向对象不可达
        allocation3 = new byte[4 * _1MB];//不可达a3+java自己对象，存不下，再次gc。
    }
    public static void main(String[] args) throws Exception{
        testAllocation();
    }
}
