import java.io.*;
import java.util.*;

public class TIL {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) {
                break;
            }
            bw.write(isNotPrime(n) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static int isNotPrime(int n) {
        boolean[] isNotPrime = new boolean[(2*n)+1];
        isNotPrime[0] = isNotPrime[1] = true;
        int cnt = 0;

        for(int i=2; i*i<=(2*n); i++) {
            if(!isNotPrime[i]) {
                for(int j=i*i; j<=(2*n); j+=i) {
                    isNotPrime[j] = true;
                }
            }
        }

        for(int i=2; i<isNotPrime.length; i++) {
            if(!isNotPrime[i] && i>n && i<=(2*n)) cnt++;
        }
        return cnt;
    }
}
