# 백준 1932번 - 정수 삼각형

## 문제설명
삼각형 형태로 배열된 숫자들 중 위에서 아래로 내려오며 선택 가능한 경로의 합 중 최댓값을 구하는 문제

## 핵심 아이디어
- DP를 사용하여 역방향(bottom-up)으로 최댓값을 누적
- `arr[i][j] = arr[i][j] + max(arr[i+1][j], arr[i+1][j+1])`

## 코드
````java
import java.io.*;
import java.util.*;

public class Main {
public static void main(String[] args) throws IOException {
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];
            for(int i=0; i<n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                for(int j=0; j<=i; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=n-2; i>=0; i--) {
                for(int j=0; j<=i; j++) {
                    arr[i][j] += Math.max(arr[i+1][j], arr[i+1][j+1]);
                }
            }

            System.out.println(arr[0][0]);
        }
    }

