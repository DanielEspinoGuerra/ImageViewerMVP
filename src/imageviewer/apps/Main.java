
package imageviewer.apps;

import imageviewer.view.ImageDisplay;
import imageviewer.control.ImagePresenter;
import imageviewer.model.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Main extends JFrame {

    private ImageDisplay imageDisplay;
    private final ImagePresenter imagePresenter;
    private List<Image> images;
    
    public static void main(String[] args) {
        new Main().execute();
    }
   
    
    public Main() {
        this.setTitle("Image Viewer");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(900,600);
        this.setLocationRelativeTo(null);
        
        this.images = new FileImageLoader(new File("fotos")).load();
        
        this.getContentPane().add(crateImagePanel());
        this.imageDisplay.display(images.get(0)); 
        this.imagePresenter = new ImagePresenter(images, imageDisplay);
    }
    
    private void execute() {  
        this.setVisible(true);
    }

    private JPanel crateImagePanel() {
        ImagePanel imagePanel = new ImagePanel();
        this.imageDisplay = imagePanel;
        return imagePanel;
    }
    
}
