# 백준 10844번 - 쉬운 계단 수

## 문제 설명
길이가 N인 계단 수의 개수를 구하는 문제이다.
계단 수는 인접한 자리 숫자의 차이가 1인 수이다.
단, 0으로 시작하는 수는 허용하지 않는다.

## 핵심 아이디어
- dp[i][j]를 길이 i이고 마지막 숫자가 j인 계단 수의 개수로 정의한다.
- 점화식은 다음과 같다.
\[
dp[i][j] = dp[i-1][j-1] + dp[i][j+1]
\]
 단, j-1과 j+1은 0부터 9까지의 숫자 범위일 때만 더한다.
- 초기값 : 
  - 길이 1인 계단 수는 1 ~ 9까지 각 숫자 하나씩만 있으므로, dp[1][1~9] = 1이고 dp[1][0] = 0이다.
- --

## 코드
````java
import java.io.*;

public class Main {
public static void main(String[] args) throws IOException {
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[N+1][10];
        dp[0][0] = 0;

        for(int j=1; j<=9; j++) {
            dp[1][j] = 1;
        }

        for(int i=2; i<=N; i++) {
            for(int j=0; j<=9; j++) {
                if(j>0) dp[i][j] += dp[i-1][j-1];
                if(j<9) dp[i][j] += dp[i-1][j+1];
                dp[i][j] = dp[i][j] % 1000000000;  //오버플로우 방지 및 문제 조건 만족
            }
        }

        //결과 계산 : 길이 N인 모든 계단 수 합산
        long result = 0;
        for(int j=0; j<=9; j++) {
            result = (result + dp[N][j]) % 1000000000;
        }

        System.out.println(result);
    }
}

