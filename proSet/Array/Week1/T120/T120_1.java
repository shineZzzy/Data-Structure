package LeetCode.EveryDAY.WEEK.Week5_DP.T120;

import java.util.HashMap;
import java.util.Map;

public class T120_1 {
    public static int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[][] score = new int[n][n];
        for(int i=0;i<n;i++) {
            for (int j = 0; j < n - 1; j++) {
                score[i][preferences[i][j]] = j;
            }
        }
        Map<Integer, Integer> lover = new HashMap<>();
        for(int i=0;i<pairs.length;i++){
            int a = pairs[i][0], b = pairs[i][1];
            lover.put(a, b);
            lover.put(b, a);
        }
        System.out.println(lover);
        int ans = 0;
        for(int i=0;i<n;i++){
            int y = lover.get(i);
            for(int j=0;j<n;j++){
                if(j == i || j == y)
                    continue;
                int v = lover.get(j);
                if(score[i][y] > score[i][j]
                        && score[j][v] > score[j][i]){
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int n=4;
        int[][] preferences={{1,2,3},{3,2,0},{3,1,0},{1,2,0}};
        int[][] paris={{0,1},{2,3}};
        int res = unhappyFriends(n, preferences, paris);
        System.out.println(res);

    }

}
