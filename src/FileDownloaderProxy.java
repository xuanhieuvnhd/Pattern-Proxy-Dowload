import java.io.IOException;

public class FileDownloaderProxy implements Downloader {
    private FileDownloader fileDownloader;
    private String url;

    public FileDownloaderProxy(String url) {
        this.url = url;
        System.out.println("Tep da tai xuong: " + this.url);
    }

    @Override
    public void download() throws IOException {
        if (fileDownloader == null) {
            fileDownloader = new FileDownloader("Chrome", this.url);
        } else {
            System.out.println("Tep da duoc tai ve: " + this.url);
        }
        fileDownloader.download();
    }
}
