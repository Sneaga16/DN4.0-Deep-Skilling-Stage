
interface Image {
    void display();
}


class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromRemoteServer();
    }

    private void loadFromRemoteServer() {
        System.out.println("Loading image from remote server: " + fileName);
        
        try {
            Thread.sleep(1000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + fileName);
    }
}


class ProxyImage implements Image {
    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName); 
        } else {
            System.out.println("Using cached image: " + fileName);
        }
        realImage.display();
    }
}


public class ProxyPatternExample {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("landscape.png");

        
        image1.display();

        System.out.println();

        image1.display();

        System.out.println();

        
        Image image2 = new ProxyImage("sunset.jpg");
        image2.display();
    }
}
