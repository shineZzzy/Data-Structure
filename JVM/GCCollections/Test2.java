package GCCollections;

public class Test2 {
    private static final int _1MB = 1024 * 1024;
    public static void testAllocation() {
        byte[] allocation;
        allocation = new byte[4 * _1MB];
    }
    public static void main(String[] args) throws Exception{
        testAllocation();
    }
}
