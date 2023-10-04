
public class ImageProcessor {
    private static ImageProcessor instance;

    private ImageProcessor() {}

    public static ImageProcessor getInstance() {
        if (instance == null) {
            instance = new ImageProcessor();
        }
        return instance;
    }

   
    private ImageFilterStrategy filterStrategy;

    public void setFilterStrategy(ImageFilterStrategy filterStrategy) {
        this.filterStrategy = filterStrategy;
    }

    public void processImage(String image) {
        System.out.println("Processing image using " + filterStrategy.getName() + " filter...");
        filterStrategy.applyFilter(image);
    }
}


interface ImageFilterStrategy {
    void applyFilter(String image);

    String getName();
}

class GrayscaleFilter implements ImageFilterStrategy {
    @Override
    public void applyFilter(String image) {
        System.out.println("Applying Grayscale Filter to the image: " + image);
    }

    @Override
    public String getName() {
        return "Grayscale";
    }
}

class SepiaFilter implements ImageFilterStrategy {
    @Override
    public void applyFilter(String image) {
        System.out.println("Applying Sepia Filter to the image: " + image);
    }

    @Override
    public String getName() {
        return "Sepia";
    }
}

public class ImageProcessingApp {
    public static void main(String[] args) {
       
        ImageProcessor processor = ImageProcessor.getInstance();

        
        processor.setFilterStrategy(new GrayscaleFilter());
        processor.processImage("image1.jpg");

        processor.setFilterStrategy(new SepiaFilter());
        processor.processImage("image2.jpg");
    }
}