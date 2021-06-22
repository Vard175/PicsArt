import java.io.File;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

public class FolderSizeService {

    /**
     * It doesn't work with symbolic links, so the size may
     * differ in complex folders (such as your system drive)
     * (This issue was noticed while working with C disk)
     **/
    public static long calculateSize(File folder) {
        long size = 0;
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    size += calculateSize(file);
                } else {
                    size += file.length();
                    FolderSizeGui.folder.setSize(FolderSizeGui.folder.getSize() + file.length());
                }
            }
        }
        return size;
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
