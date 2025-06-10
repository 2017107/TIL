````java

import java.io.*;
import java.util.Stack;

public class Main {
public static void main(String[] args) throws IOException {
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            while (true) {
                String str = br.readLine();
                if (str.equals(".")) {
                    break;
                }
                bw.write(solve(str) + "\n");
            }
            bw.flush();
            bw.close();
            br.close();
        }

        static String solve(String str) {
            Stack<String> stack = new Stack<String>();

            for(int i=0; i<str.length(); i++) {
                String s = str.substring(i,i+1);

                if(s.equals("(") || s.equals("[")) {
                    stack.push(s);
                } else if(s.equals(")")) {
                    if(stack.isEmpty() || !stack.peek().equals("(")) {
                        return "no";
                    } else {
                        stack.pop();
                    }
                } else if(s.equals("]")) {
                    if(stack.isEmpty() || !stack.peek().equals("[")) {
                        return "no";
                    } else {
                        stack.pop();
                    }
                }
            }

            if(stack.isEmpty()) return "yes";
            else return "no";
        }
    }

