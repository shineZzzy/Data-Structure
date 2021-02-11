package Test.T0122;

public class input {
    public static void main(String[] args) {
        int[] x={13,1,2,3,4,5,6,7,8,9,10,20,16,18};
        findN(x);
    }
    public static void findN(int[] n) {
        int sumA = 0;
        int sumB = 0;
        int count1 = 0;
        int count2 = 0;
        int count = 0;
        int sum = 0;
        float avg = 0.0f;
        int max = 0;

        for (int i = 0; i < n.length; i++) {
            if (n[i] % 5 == 0) {
                if (n[i] % 2 == 0) {
                    sumA += n[i];
                }
                if (n[i] % 5==1) {
                    sumB += Math.pow((-1), count) * n[i];
                    count++;
                }
                if (n[i] % 5 ==2) {
                    count1++;
                }
                if (n[i] % 5 == 3) {
                    count2++;
                    sum += n[i];
                    avg = sum / count2;
                }

                if (n[i] % 5== 4) {
                    if (n[i] > max) {
                        max = n[i];
                    }
                }
            }
        }
                System.out.println(sumA + " " + sumB + " " + count1 + " " + avg + " " + max);
        }
}
