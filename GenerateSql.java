import java.io.FileWriter;
import java.io.IOException;

public class GenerateSql {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("src/main/resources/data.sql");
            for (int i = 1; i <= 100; i++) {
                writer.write("INSERT INTO books (title, author) VALUES ('Book Title " + i + ", 'Author " + i + ");\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

