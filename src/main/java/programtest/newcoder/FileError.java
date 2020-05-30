package programtest.newcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileError {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String messageLine = "";
        Map<String, Integer> map = new HashMap<>();
        while ((messageLine = br.readLine()) != null) {
            messageLine = messageLine.substring(messageLine.lastIndexOf("\\") + 1);
            if (messageLine.length() > 16) {
                messageLine = messageLine.substring(messageLine.length() - 16);
            }
            String[] split = messageLine.split(" ");

            if (map.containsKey(split[0] + "#" + split[1])) {
                map.put(split[0] + "#" + split[1], map.get(split[0] + "#" + split[1]) + 1);
            } else {
                map.put(split[0] + "#" + split[1], 1);
            }
        }

        int count = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (++count > map.size() - 8) {
                System.out.println(entry.getKey().split("#")[0] + " " + entry.getKey().split("#")[1] + " " + entry.getValue());
            }
        }
    }

}
