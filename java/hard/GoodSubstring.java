package java.hard;

import java.io.*;
import java.util.*;

public class GoodSubstring {

    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        String next() throws IOException {
            StringBuilder sb = new StringBuilder();
            int c;

            while ((c = read()) <= ' ')
                if (c == -1) return null;

            do {
                sb.append((char) c);
                c = read();
            } while (c > ' ');

            return sb.toString();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner();

        String s = fs.next();
        String good = fs.next();
        int k = fs.nextInt();

        int n = s.length();

        boolean[] bad = new boolean[26];

        for (int i = 0; i < 26; i++)
            bad[i] = (good.charAt(i) == '0');

        final long MOD1 = 1000000007L;
        final long MOD2 = 1000000009L;

        final long BASE1 = 911382323L;
        final long BASE2 = 972663749L;

        HashSet<Long> set = new HashSet<>();

        for (int i = 0; i < n; i++) {

            int cnt = 0;

            long h1 = 0;
            long h2 = 0;

            for (int j = i; j < n; j++) {

                int x = s.charAt(j) - 'a';

                if (bad[x])
                    cnt++;

                if (cnt > k)
                    break;

                int val = x + 1;

                h1 = (h1 * BASE1 + val) % MOD1;
                h2 = (h2 * BASE2 + val) % MOD2;

                long combined = (h1 << 32) ^ h2;

                set.add(combined);
            }
        }

        System.out.println(set.size());
    }
}