
# 백준 1149번 - RGB거리

## 문제 설명
- N개의 집을 빨강, 초록, 파랑 중 하나로 칠함
- 이웃한 집은 같은 색으로 칠할 수 없음
- 모든 집을 칠하는 최소 비용을 구하시오.

## 풀이 방법
- DP 사용
- dp[i][j] : i번째 집까지 칠했을 때, i번째 집을 j색으로 칠한 최소 비용
- 점화식 :
    - dp[i][0] = arr[i][0] + min(dp[i-1][1], dp[i-1][2])
    - dp[i][1] = arr[i][1] + min(dp[i-1][0], dp[i-1][2])
    - dp[i][2] = arr[i][2] + min(dp[i-1][0], dp[i-1][1])
    
## 시간복잡도
- O(N)

## 코드
````java
import java.io.*;
import java.util.*;

public class Main {
public static void main(String[] args) throws IOException {
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][3];

            for(int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                for(int j=0; j<3; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dp = new int[N][3];
            dp[0][0] = arr[0][0];
            dp[0][1] = arr[0][1];
            dp[0][2] = arr[0][2];

            for(int i=1; i<N; i++) {
                dp[i][0] = arr[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
                dp[i][1] = arr[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
                dp[i][2] = arr[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
            }

            System.out.println(Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2])));
        }
    }

