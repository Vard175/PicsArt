package threadsAndRunnables;

import gui.FolderSizeGui;
import services.FolderSizeService;

import java.io.File;

public class FolderSizeRunnable implements Runnable {
    @Override
    public void run() {
        Thread calculateThread = new Thread(() -> FolderSizeService.calculateSize(new File(FolderSizeGui.folder.getPath())));
        calculateThread.start();

        while (calculateThread.isAlive()) {
            FolderSizeGui.sizeOutputLabel.setText(FolderSizeService.convertBytes(FolderSizeGui.folder.getSize()));
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        FolderSizeGui.sizeOutputLabel.setText(FolderSizeService.convertBytes(FolderSizeGui.folder.getSize()));
    }
}