package programtest.newcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ZishouShu {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while ((str = reader.readLine()) != null) {
            int n = Integer.parseInt(str);
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (String.valueOf(i * i).endsWith(String.valueOf(i))) {
                    count++;
                }
            }
            System.out.println(count);
        }

    }
}
