package ru.job4j.search;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

@ThreadSafe
public class ParallelSearch {
    private final String root;
    private final String text;
    private final LinkedList<String> exts;
    volatile boolean finish = false;

    @GuardedBy("this")
    private final Queue<String> files = new LinkedList<>();

    @GuardedBy("this")
    private final List<String> paths = new ArrayList<>();


    public ParallelSearch(String root, String text, LinkedList<String> exts) {
        this.root = root;
        this.text = text;
        this.exts = exts;
    }

    public void listPaths() throws IOException {
        Path dir = Paths.get(this.root);
        if (Files.exists(dir)) {
            FileVisitor<Path> visitor = new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    Iterator<String> iterator = exts.iterator();
                    while (iterator.hasNext()) {
                        if (file.getFileName().toString().endsWith(iterator.next())) {
                            StringJoiner stringJoiner = new StringJoiner("\\");
                            stringJoiner.add(file.getParent().toString());
                            stringJoiner.add(file.getFileName().toString());
                            paths.add(stringJoiner.toString());
                        }
                    }
                    return super.visitFile(file, attrs);
                }
            };
            Files.walkFileTree(dir, visitor);
        }
        this.finish = true;
    }

    public void textSearch() throws InterruptedException, IOException {
        if (this.finish) {
            Iterator<String> iterator = paths.iterator();
            while (iterator.hasNext()) {
                String currentString = iterator.next();
                File file = new File(currentString);
                Scanner scanner = new Scanner(file);
                try {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        if (line.contains(this.text)) {
                            this.files.add(currentString);
                        }
                    }
                } finally {
                    scanner.close();
                }
            }
        }
    }
    public void init() throws InterruptedException {

        Thread search = new Thread() {
            @Override
            public void run() {
                try {
                    listPaths();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        search.start();

        Thread read = new Thread() {
            @Override
            public void run() {
                try {
                    textSearch();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        read.start();
    }

    synchronized Queue<String>  result() {
        return this.files;
    }


}