import java.io.IOException;

public class Client {
    public static void main(String[] args) {
        String url = "https://i.imgur.com/OoQDNK5.jpg";
        System.out.println("Init proxy");
        FileDownloaderProxy fileDownloaderProxy = new FileDownloaderProxy(url);

        try {
            System.out.println("---");
            System.out.println("Goi dich vu dau tien: ");
            fileDownloaderProxy.download();

            System.out.println("---");
            System.out.println("Goi dich vu thu hai: ");
            fileDownloaderProxy.download();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
