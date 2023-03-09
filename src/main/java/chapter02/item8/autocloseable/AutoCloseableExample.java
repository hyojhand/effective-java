package chapter02.item8.autocloseable;

import java.io.*;

public class AutoCloseableExample implements Closeable {

    private BufferedReader reader;

    public AutoCloseableExample(String path) {
        try {
            this.reader = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(path);
        }
    }

    @Override
    public void close() {
        try {
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
