public class ImageProcess {
    private static ImageProcess single;

    private ImageProcess() {}

    public static ImageProcess getInstance() {
        if (single == null) {
            single = new ImageProcess();
        }
        return single;
    }

   
    private ImageFilterStrategy filterStrategy;

    public void selectFilterStrategy(ImageFilterStrategy filterStrategy) {
        this.filterStrategy = filterStrategy;
    }

    public void processImageWithSelectedFilter(String image) {
        System.out.println("Selected filter: " + filterStrategy.getName());
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
        System.out.println("it is Grayscale filter " + image);
    }

    @Override
    public String getName() {
        return "Grayscale";
    }
}

class SepiaFilter implements ImageFilterStrategy {
    @Override
    public void applyFilter(String image) {
        System.out.println("It is Sepia filter: " + image);
    }

    @Override
    public String getName() {
        return "Sepia";
    }
}
public class ImageProcessingApp {
    public static void main(String[] args) {
       
        ImageProcess processor = ImageProcess.getInstance();

        
        processor.setFilterStrategy(new GrayscaleFilter());
        processor.processImage("grayscaleIMG.jpg");

        processor.setFilterStrategy(new SepiaFilter());
        processor.processImage("sepiaIMG.jpg");
    }
}
