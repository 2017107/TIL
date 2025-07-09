# 백준 1463번 - 1로 만들기

## 문제 설명
정수 N이 주어졌을 때, 정수 N을 1로 만들기 위한 최소 연산 횟수를 구하는 문제

사용 가능한 연산 :
- N이 3으로 나누어지면, N -> N/3
- N이 2로 나누어지면, N -> N/2
- N -> N - 1

## 핵심 아이디어
- DP
  - dp[i] = i를 1로 만들기 위한 최소 연산 횟수
  - 점화식 :
  ````
  dp[i] = min(dp[i - 1] + 1,
          dp[i / 2] + 1 (if i % 2 == 0),
          dp[i / 3] + 1 (if i % 3 == 0)
  ````
  - dp[1] = 0

## 코드
````java
import java.io.*;

public class Main {
public static void main(String[] args) throws IOException {
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];
        dp[1] = 0;

        for(int i=2; i<=N; i++) {
            dp[i] = dp[i-1] + 1;

            if(i%2 == 0) {
                dp[i] = Math.min(dp[i], dp[i/2]+1);
            }
            if(i%3 == 0) {
                dp[i] = Math.min(dp[i], dp[i/3]+1);
            }
        }

        System.out.println(dp[N]);
    }
}

