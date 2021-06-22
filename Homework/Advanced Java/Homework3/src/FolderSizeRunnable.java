import java.io.File;

public class FolderSizeRunnable implements Runnable {
    @Override
    public void run() {
        Thread calculateThread = new Thread(() -> FolderSizeService.calculateSize(new File(FolderSizeGui.folder.getPath())));
        calculateThread.start();

        while (calculateThread.isAlive()) {
            FolderSizeGui.sizeLabel.setText(FolderSizeService.convertBytes(FolderSizeGui.folder.getSize()));
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        FolderSizeGui.sizeLabel.setText(FolderSizeService.convertBytes(FolderSizeGui.folder.getSize()));
    }
}