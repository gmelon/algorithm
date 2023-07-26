package nadongbin.binary_search.implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class FastIO {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            for (int i = 0; i < 1; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                while (tokenizer.hasMoreTokens()) {
                    list.add(Integer.parseInt(tokenizer.nextToken()));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8))) {
            for (Integer integer : list) {
                writer.write(String.valueOf(integer));
                writer.newLine();
            }
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
