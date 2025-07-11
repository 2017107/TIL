import java.io.*;

public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int T = Integer.parseInt(br.readLine());
            for(int i=0; i<T; i++) {
                int N = Integer.parseInt(br.readLine());
                bw.write(isNotPrime(N) + "\n");
            }
            bw.flush();
            bw.close();
            br.close();
        }

        static int isNotPrime(int N) {
            boolean[] isNotPrime = new boolean[N+1];
            isNotPrime[0] = isNotPrime[1] = true;

            for(int i=2; i*i<=N; i++) {
                if(!isNotPrime[i]) {
                    for(int j=i*i; j<=N; j+=i) {
                        isNotPrime[j] =true;
                    }
                }
            }

            int cnt = 0;
            for(int i=2; i<=N/2; i++) {
                if(!isNotPrime[i] && !isNotPrime[N-i]){
                    cnt++;
                }
            }
            return cnt;
        }

    }

