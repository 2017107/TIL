````java
import java.io.*;
import java.util.*;

public class Main {
static int[][] arr = new int[9][9];  //9*9 스도쿠 판
static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            for(int i=0; i<9; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                for(int j=0; j<9; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dfs(0,0);  //(0,0) 칸부터 시작해서 재귀적으로 채워나가는 함수
        }

        static void dfs(int row, int col) throws IOException {
            if(col == 9) {  //col == 9 이면 다음 행으로 넘어감
                dfs(row+1,0);
                return;
            }

            if(row == 9) {  //스도쿠 끝까지 도달한 경우, 스도쿠를 다 채운 경우
                for(int[] line : arr) {
                    for(int v : line) {
                        bw.write(v + " ");
                    }
                    bw.newLine();
                }
                bw.flush();
                System.exit(0);  //첫 번째 정답 출력 후 바로 종료
            }

            if(arr[row][col] != 0) {  //빈칸이 아닌 경우
                dfs(row, col+1);  //현재 칸이 이미 채워져 있으면 그냥 다음 칸으로 넘어감
            }else {
                for(int num=1; num<=9; num++) {
                    if(isVaild(row, col, num)) {
                        arr[row][col] = num;   //숫자 넣고
                        dfs(row, col+1);       //다음 칸으로 이동
                        arr[row][col] = 0;     //안 맞으면 다시 0으로 돌려놓기 (백트래킹)
                    }
                }
            }
        }

        static boolean isVaild(int r, int c, int num) {  //숫자 넣어도 되는지 체크
            for(int k=0; k<9; k++) {  //같은 행과 열에 있는지 확인. 가로(행)과 세로(열)에 이미 같은 숫자 가 있으면 안됨
                if(arr[r][k]==num || arr[k][c]==num) return false;
            }
            int sr = (r/3)*3, sc = (c/3)*3;  //3*3 박스 안에 있는지 확인. (r/3)*3, (c/3)*3 : 현재 좌표가 속한 3*3 칸의 시작점
            for(int i=sr; i<sr+3; i++) {
                for(int j=sc; j<sc+3; j++) {
                    if(arr[i][j] == num) return false;  //3*3 박스 안에서 같은 숫자가 있으면 안됨
                }
            }
            return true;
        }
    }

