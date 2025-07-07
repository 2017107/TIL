# 백준 1912번 - 연속합

## 문제 설명
N개의 정수로 이루어진 수열이 주어졌을 때, 연속된 부분 수열의 합 중 가장 큰 값을 구하는 문제

## 핵심 아이디어
- 이 문제는 카데인 알고리즘을 사용하는 전형적인 DP 문제
- dp[i] = max(arr[i], dp[i-1]+arr[i])
- 현재 수 하나만 쓰는 게 유리한지, 이전까지의 합에 지금 수를 더하는 게 유리한지를 매번 판단

--
## 코드
`````java
import java.io.*;
import java.util.*;

public class Main {
public static void main(String[] args) throws IOException {
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[n];
            int[] dp = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int i=0; i<n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dp[0] = arr[0];
            for(int i=1; i<n; i++) {
                dp[i] = Math.max(arr[i], dp[i-1] + arr[i]);
            }

            int answer = dp[0];
            for(int i=1; i<n; i++) {
                answer = Math.max(answer, dp[i]);
            }
            System.out.println(answer);
        }
    }

