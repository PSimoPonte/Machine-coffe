 
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import static javafx.scene.input.KeyCode.I;
import javafx.scene.input.KeyEvent; 
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * <p>
 * Questa classe rappresenta la <strong>finestra secondaria </strong> 
 * dove verranno gestiti i pulsanti "UP", "DOWN", "LEFT", "RIGHT", "COLORE",
 * "START", "RESET". Vi e' presente anche il Choicebox per la selezione della
 * figura.
 * @author Simone.Pontalti
 */
public class FinestraRegia {
    
    //il mio vBOx conterrà i due HBox
    VBox vb;
    HBox hb1,hb2;

    
    static Button btncolore;
    static ChoiceBox choice;
    static TextField text1;
    int spostamento;
    
    static Button up, down, left, right, start, reset;
    
 
    /**
     * Questo e' un costruttore vuoto e viene usato per istanziare un oggetto di
     * tipo <strong> FinestraRegia() </strong> 
     */
    
    public FinestraRegia(){
    
        Stage secondarystage = new Stage();
        
        ToggleGroup group = new ToggleGroup();
        
        btncolore = new Button("Colore");
        btncolore.setId("Colore");
        
        choice = new ChoiceBox(FXCollections.observableArrayList("Cerchio", 
                                                   "Quadrato", "Esagono"));
        choice.setId("Choice");
        
        text1 = new TextField("5");
        
        hb1 = new HBox(15);
        hb1.getChildren().addAll(choice,btncolore,text1);
        
        up = new Button("UP");
        up.setId("UP");
        
        down = new Button("DOWN");
        down.setId("DOWN");
        
        left = new Button("LEFT");
        left.setId("LEFT");
        
        right = new Button("RIGHT");
        right.setId("RIGHT");
      
        start = new Button("START");
        start.setId("START");
        
        reset = new Button("RESET");
        reset.setId("RESET");
       
        hb2 = new HBox(15);
        hb2.getChildren().addAll(up, down, left, right, start, reset);
      
        vb= new VBox(10);
        vb.setPadding(new Insets(20, 20, 20, 20));
        vb.getChildren().addAll(hb1,hb2);
        
 //############################################################################
//## COLLEGAMENTO CON LA CLASSE ESTERNA CHE GESTISCE IL CLICK SUL BOTTONE  ####
//############################################################################
          
        GestoreEvento ge = new GestoreEvento();
        
        up.addEventHandler(ActionEvent.ACTION, ge);
        down.addEventHandler(ActionEvent.ACTION, ge);
        left.addEventHandler(ActionEvent.ACTION, ge);
        right.addEventHandler(ActionEvent.ACTION, ge);
        btncolore.addEventHandler(ActionEvent.ACTION, ge);
        choice.addEventHandler(ActionEvent.ACTION, ge);
        start.addEventHandler(ActionEvent.ACTION, ge);
        reset.addEventHandler(ActionEvent.ACTION, ge);
        
//#############################################################################
//#################  Associo un evento di scrittura al textfield :   ##########
//##################  quando inserisco lettere deve uscire il   ###############
//####################          popup // alert         ########################
//#############################################################################

        text1.setOnKeyReleased(new EventHandler<KeyEvent>() {
           public void handle(KeyEvent ke) {
               System.out.println("Key Pressed: " + ke.getText());
               
             //String st = ke.getText();
               String st2="";
               
                int sp;
                KeyCode st = ke.getCode();
                
                if( ke.getCode() == KeyCode.BACK_SPACE){
                    
                  System.out.println("Hai eliminato un carattere alfanumerico");
                }   
                else{
                     try{
                         st2 = st2+text1.getText();
                         System.out.println("Contenuto TextField: "+ st2);
                         sp = Integer.parseInt(st2);

                      }catch(Exception e){

//####################      FINESTRA DI AVVISO        ######################### 
                         Alert alert = new Alert(Alert.AlertType.INFORMATION);
                         alert.setTitle("ATTENZIONE!");
                         alert.setHeaderText(null);
                         alert.setContentText("Inserisci un numero valido");

                         alert.showAndWait();
                      }
                }
           }
       });
//###########################################################################
  //#######           EVENTO PER IL CLICK DA TASTIERA!!!     #################
  //##########################################################################
  EventHandler<KeyEvent> keyEventHandler = new EventHandler<KeyEvent>(){
    
       public void handle(final KeyEvent e){

           //KeyCode st = e.getCode();
                 
        //  System.out.println(e.getSource()+ " => " + e.getTarget());
            switch(e.getCode()){

                case I: System.out.println("Hai cliccato su I, quindi UP!");
                up.fireEvent(new ActionEvent());
                break;

                case J: System.out.println("Hai cliccato su J, quindi LEFT!");
                left.fireEvent(new ActionEvent());
                break;

                case K: System.out.println("Hai cliccato su K,quindi DOWN!");
                down.fireEvent(new ActionEvent());
                break;

                case L: System.out.println("Hai cliccato su L, quindi RIGHT!");
                right.fireEvent(new ActionEvent());
                break;
                
                case C: System.out.println("Hai cliccato su L, quindi RIGHT!");
                btncolore.fireEvent(new ActionEvent());
                break;
            }
         }
        
       };
 //###########################################################################
 //############################################################################
 //############################################################################  

        Scene scene2 = new Scene(vb, 450, 350);
      
        secondarystage.addEventHandler(KeyEvent.KEY_PRESSED, keyEventHandler);
        
        secondarystage.setTitle("Finestra regia");
        secondarystage.setScene(scene2);
        secondarystage.setWidth(550);
        secondarystage.setHeight(150);
        secondarystage.setX(150);
        secondarystage.setY(300);
        secondarystage.show();
    }
}
