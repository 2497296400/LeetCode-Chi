package 卷一核心技术.并发文件;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author pc
 */
public class BlockingQueueTest {
    private static final int FILE_QUEUE_SIZE = 10;
    private static final int SEARCH_THREADS = 100;
    private static final Path DUMMY = Path.of("");
    private static BlockingQueue<Path> queue = new ArrayBlockingQueue<>(FILE_QUEUE_SIZE);

    public static void main(String[] args) {
        try (var in = new Scanner(System.in)) {
            System.out.print("Enter base directory(e.g./opt/jdk-9-src):");
            String directory = in.nextLine();
            System.out.print("Enter keyWord (e.g.volatile):");
            String keyWOrd = in.nextLine();
            Runnable enumerator = () -> {
                try {
                    enumerate(Path.of(directory));
                    queue.put(DUMMY);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            };
            new Thread(enumerator).start();
            for (int i = 1; i <= SEARCH_THREADS; i++) {
                Runnable searcher = () -> {
                    try {
                        var done = false;
                        while (!done) {
                            Path file = queue.take();
                            if (file == DUMMY) {
                                queue.put(file);
                                done = true;
                            } else {
                                search(file, keyWOrd);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                };
                new Thread(searcher).start();
            }
        }
    }

    private static void enumerate(Path directory) throws Exception {
        try (Stream<Path> childern = Files.list(directory)) {
            for (Path path : childern.toList()) {
                if (Files.isDirectory(path)) {
                    enumerate(path);
                } else {
                    queue.put(path);
                }
            }

        }
    }

    private static void search(Path file, String keyWord) throws Exception {
        try (var in = new Scanner(file)) {
            int lineNumber = 0;
            while (in.hasNextLine()) {
                lineNumber++;
                String line = in.nextLine();
                if (line.contains(keyWord)) {
                    System.out.printf("%s:%d:%s%n",file,lineNumber,line);
                }
            }
        }
    }
}
