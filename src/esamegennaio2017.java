
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * <p>
 * Questa classe rappresenta la <strong>finestra principale </strong> 
 * dove appariranno tutte le figure richieste: cerchio, rettangolo, esagono
 * @author Simone.Pontalti
 */
public class esamegennaio2017 extends Application {
    
//######    DICHIARAZIONI      ###############################################
    static Circle circle;
    static Rectangle rect;
    static Polygon hexagon;
    static int larghezza = 900;
    static int altezza= 750;
    
    static double xc,yc,xr,yr,xh,yh=0;
    
    //################Layout
    static AnchorPane ancora;
    
    @Override
    public void start(Stage primaryStage) {
     
        FinestraRegia finestra2= new FinestraRegia();
        
        FinestraRegia.up.setDisable(true);
        FinestraRegia.down.setDisable(true);
        FinestraRegia.left.setDisable(true);
        FinestraRegia.right.setDisable(true);
        FinestraRegia.btncolore.setDisable(true);
         
        creaFigure();
        ancora = new AnchorPane();
        ancora.getChildren().addAll(circle,rect,hexagon);
        ancora.setLeftAnchor(circle,250.0);
        ancora.setRightAnchor(rect, 100.0);
        ancora.setBottomAnchor(hexagon, 220.0);
    
        Scene scene = new Scene(ancora, larghezza, altezza);
        
        primaryStage.setTitle("Finestra principale");
        primaryStage.setScene(scene);
        primaryStage.setX(800);
        primaryStage.show();
        
        
                           
 //############################################################################
 //################      Per chiudere la finestra di gioco!    ################

              primaryStage.setOnCloseRequest((new EventHandler<WindowEvent>(){

              @Override
              public void handle(WindowEvent arg0) {
                  Platform.exit();
              }
              }));
       
//#############################################################################
//#############################################################################

        
        
    }
    
    //###################################################################
    //#######         FUNZIONE PER CREARE LE FIGURE       ###############
    //###################################################################
 /**
 * Questa funzione serve per istanziare le 3 figure target:circle,rect, hexagon
 */
    public static void creaFigure(){
        
       
        circle= new Circle(150,150,80);
        circle.setId("circle");
        
        rect = new Rectangle(250,250,150,150);
        rect.setId("rect");
        
        hexagon= new Polygon();
        hexagon.setId("hexagon");
        hexagon.getPoints().addAll(new Double[]{        
            100.0, 50.0, 
            200.0, 50.0, 
            250.0, 100.0,          
            200.0, 150.0, 
            100.0, 150.0,                   
            50.0, 100.0, 
     });
         
    }
    //###################################################################
    //###################################################################
    //###################################################################


    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
