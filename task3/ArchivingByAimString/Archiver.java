package task3.ArchivingByAimString;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.zip.*;

import java.util.Scanner;

public class Archiver {

    private static void addToZip(Path file, ZipOutputStream zos) throws IOException {
        byte[] buffer = new byte[1024];
        try (FileInputStream fis = new FileInputStream(file.toFile())) {
            zos.putNextEntry(new ZipEntry(file.toFile().getName()));
            int length;
            while ((length = fis.read(buffer)) > 0) {
                zos.write(buffer, 0, length);
            }
            zos.closeEntry();
        }
    }

    public static void main(String[] args) {

        new DirectoryChooser();
        DirectoryChooser.choser();
        String directoryPath = DirectoryChooser.chosen;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a target string: ");
        final String targetString = scanner.nextLine();
        scanner.close();

        try (FileOutputStream fos = new FileOutputStream(DirectoryChooser.chosen + ".zip");
                ZipOutputStream zos = new ZipOutputStream(fos)) {

            Files.walkFileTree(Paths.get(directoryPath), new SimpleFileVisitor<Path>() {

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                    if (file.toFile().getName().contains(targetString)) {
                        try {
                            addToZip(file, zos);
                        } catch (IOException e) {
                        }

                    }
                    return FileVisitResult.CONTINUE;
                }
            });

            System.out.println("Archiving is completed. Archive path: " + DirectoryChooser.chosen + ".zip");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
