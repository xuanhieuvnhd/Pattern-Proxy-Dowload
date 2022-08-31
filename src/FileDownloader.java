import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class FileDownloader implements Downloader {
    private String userAgent;
    private String url;

    public FileDownloader() {
    }

    public FileDownloader(String userAgent, String url) {
        this.userAgent = userAgent;
        this.url = url;
        System.out.println("Dang tai tep... " + this.url + ", Trinh duyet: " + this.userAgent);
    }

    @Override
    public void download() throws IOException {
        String folder = "D:\\PHANMEM\\JAVA\\Module2\\ThucHanh\\Pattern-Proxy-Dowload\\src\\";
        String fileName = this.url.substring(this.url.lastIndexOf('/')+1);
        File file = new File(folder + fileName);
        if (!file.exists()) {
            // Tạo một đối tượng url
            URL url = new URL(this.url);
            // Kết nối với tệp tin đó
            URLConnection urlConnection = url.openConnection();
            // Nhận luồng đầu ra để tải xuống tệp
            InputStream inputStream = urlConnection.getInputStream();
            OutputStream outputStream = new FileOutputStream(folder + fileName);
            final byte[] b = new byte[2048];
            int length;
            while ((length = inputStream.read(b)) != -1) {
                outputStream.write(b, 0, length);
            }
            outputStream.close();
            inputStream.close();
            System.out.println("Tep da tai xuong: " + folder + fileName);
        } else {
            System.err.println("Tep da ton tai!");
        }
    }
}
