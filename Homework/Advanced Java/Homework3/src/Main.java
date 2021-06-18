import java.io.File;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(convertBytes(calculateFolderSize(new File("D:\\"))));

    }

    /**
     * It doesn't work with symbolic links, so the size may
     * differ in complex folders (such as your system drive)
     * (This issue was noticed while working with C disk)
     **/
    public static long calculateFolderSize(File folder) {
        long length = 0;
        File[] folderFiles = folder.listFiles();
        if (folderFiles != null) {
            for (File file : folderFiles) {
                if (file.isFile())
                    length += file.length();
                else
                    length += calculateFolderSize(file);
            }
        }
        return length;
    }

    public static String convertBytes(long bytes) {
        if (-1024 < bytes && bytes < 1024) {
            return bytes + " B";
        }
        CharacterIterator ci = new StringCharacterIterator("kMGTPE");
        while (bytes <= -1024 * 1024 || bytes >= 1024 * 1024) {
            bytes /= 1024;
            ci.next();
        }
        return String.format("%.1f %cB", bytes / 1024.0, ci.current());
    }
}
