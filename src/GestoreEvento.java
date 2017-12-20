
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

/**
 * <p>
 * Questa classe principalmente <strong> gestisce gli eventi </strong> 
 * ma contiene anche le funzioni che agiscono sulle varie figure 
 * @author Simone.Pontalti
 */
public class GestoreEvento implements EventHandler<ActionEvent> {
    
    int spostamento;
    static String output;
    Timeline timeline,timeline1,timeline2;
    boolean movimentoFig = false;    
    AnimationTimer ant;
    @Override
   public void handle(ActionEvent e){
        
//############################################################################    
//Controllo se la classe che ha scaturito l'evento("e.getTarget().getClass()")
//e' uguale alla classe dell'oggetto "choice" nel file finestra regia
//(FinestraRegia.choice.getClass()) ########     FONDAMENTALE!     ############
//############################################################################ 

      if(e.getTarget().getClass().equals(FinestraRegia.choice.getClass())){
                
                    FinestraRegia.up.setDisable(false);
                    FinestraRegia.down.setDisable(false);
                    FinestraRegia.left.setDisable(false);
                    FinestraRegia.right.setDisable(false);
                    FinestraRegia.btncolore.setDisable(false);

                    selezionaFigura();
      }       
      if(e.getTarget().getClass().equals(Button.class)){
                Button btn = (Button)e.getSource();
                 String st0 = btn.getId();

           //      System.out.println(" STAMPA -->"+st0);
        switch (st0) {
         case "UP":
             spostaSu(output);
         break;

         case "DOWN":
             spostaGiu(output);
         break;

         case "LEFT":
             spostaSinistra(output);
         break;

         case "RIGHT":
             spostaDestra(output);
         break;

         case "Colore":
             cambiaColoreFigura(output);
         break;

         case "START":
             movimentoFig = true;
             spostaFigureInGiu3();
             FinestraRegia.start.setText("STOP");
             FinestraRegia.start.setId("STOP");
             
         break;

         case "STOP":
             System.out.println("wwwwwwww -->"+ FinestraRegia.start.getText());
             //movimentoFig = false; 
             fermaAnimazioneFigure();
             FinestraRegia.start.setText("START");
             FinestraRegia.start.setId("START");
             
         break;

         case "RESET":
           esamegennaio2017.ancora.getChildren().clear();
           esamegennaio2017.creaFigure();
           esamegennaio2017.ancora.getChildren().addAll(esamegennaio2017.
                   circle,esamegennaio2017.rect,esamegennaio2017.hexagon);
           esamegennaio2017.ancora.setLeftAnchor(esamegennaio2017.circle,250.0);
           esamegennaio2017.ancora.setRightAnchor(esamegennaio2017.rect, 100.0);
           esamegennaio2017.ancora.setBottomAnchor(esamegennaio2017.hexagon,
                                                                        130.0);
             FinestraRegia.text1.setText("5");
             
             FinestraRegia finestra2= new FinestraRegia();
             
             FinestraRegia.up.setDisable(true);
             FinestraRegia.down.setDisable(true);
             FinestraRegia.left.setDisable(true);
             FinestraRegia.right.setDisable(true);
             FinestraRegia.btncolore.setDisable(true);

         break;
     
        }
      } 
   }          
     //########################################################################
    //#################    SPOSTA FIGURA in SU     ############################
     //#######################################################################
 /**
 * Questa funzione sposta la figura selezionata IN SU rispetto al layout
 * @param figura parametro formale, quando richiamerò la funzione la stringa 
 *              corrispondente (parametro attuale) sarà la figura specifica
 */
    public void spostaSu(String figura){
    
        double z = prendiValoreSpostamento();
        if(figura.equalsIgnoreCase("Cerchio")){
            esamegennaio2017.xc = esamegennaio2017.circle.getTranslateX();
            esamegennaio2017.yc = esamegennaio2017.circle.getTranslateY();
            esamegennaio2017.circle.setTranslateX(esamegennaio2017.xc);
            esamegennaio2017.circle.setTranslateY(esamegennaio2017.yc-z);
        }
        else if(figura.equalsIgnoreCase("Quadrato")){
              esamegennaio2017.xr = esamegennaio2017.rect.getTranslateX();
              esamegennaio2017.yr = esamegennaio2017.rect.getTranslateY();
              esamegennaio2017.rect.setTranslateX(esamegennaio2017.xr);
              esamegennaio2017.rect.setTranslateY(esamegennaio2017.yr-z);
        }
        else if(figura.equalsIgnoreCase("Esagono")){
              esamegennaio2017.xh = esamegennaio2017.hexagon.getTranslateX();
              esamegennaio2017.yh = esamegennaio2017.hexagon.getTranslateY();
              esamegennaio2017.hexagon.setTranslateX(esamegennaio2017.xh);
              esamegennaio2017.hexagon.setTranslateY(esamegennaio2017.yh-z);
        }
    }
//############################################################################
//#################    SPOSTA FIGURA in GIu     ###############################
//############################################################################
 /**
 * Questa funzione sposta la figura selezionata  IN GIu rispetto al layout
 * @param figura parametro formale, quando richiamerò la funzione la stringa 
 *              corrispondente (parametro attuale) sarà la figura specifica
 */    
   public void spostaGiu(String figura){
        
        double z = prendiValoreSpostamento();
        
        if(figura.equalsIgnoreCase("Cerchio")){
            esamegennaio2017.xc = esamegennaio2017.circle.getTranslateX();
            esamegennaio2017.yc = esamegennaio2017.circle.getTranslateY();
            esamegennaio2017.circle.setTranslateX(esamegennaio2017.xc);
            esamegennaio2017.circle.setTranslateY(esamegennaio2017.yc+z);
        }
        else if(figura.equalsIgnoreCase("Quadrato")){
              esamegennaio2017.xr = esamegennaio2017.rect.getTranslateX();
              esamegennaio2017.yr = esamegennaio2017.rect.getTranslateY();
              esamegennaio2017.rect.setTranslateX(esamegennaio2017.xr);
              esamegennaio2017.rect.setTranslateY(esamegennaio2017.yr+z);
        }
        else if(figura.equalsIgnoreCase("Esagono")){
              esamegennaio2017.xh = esamegennaio2017.hexagon.getTranslateX();
              esamegennaio2017.yh = esamegennaio2017.hexagon.getTranslateY();
              esamegennaio2017.hexagon.setTranslateX(esamegennaio2017.xh);
              esamegennaio2017.hexagon.setTranslateY(esamegennaio2017.yh+z);
        }
    }
//############################################################################
//#################    SPOSTA FIGURA A DESTRA     ############################
//############################################################################
 /**
 * Questa funzione sposta la figura selezionata A DESTRA rispetto al layout
 * @param figura parametro formale, quando richiamerò la funzione la stringa 
 *              corrispondente (parametro attuale) sarà la figura specifica
 */
   public void spostaDestra(String figura){
         
        double z = prendiValoreSpostamento();
        
         if(figura.equalsIgnoreCase("Cerchio")){
            esamegennaio2017.xc = esamegennaio2017.circle.getTranslateX();
            esamegennaio2017.yc = esamegennaio2017.circle.getTranslateY();
            esamegennaio2017.circle.setTranslateX(esamegennaio2017.xc+z);
            esamegennaio2017.circle.setTranslateY(esamegennaio2017.yc);

        }
        else if(figura.equalsIgnoreCase("Quadrato")){
              esamegennaio2017.xr = esamegennaio2017.rect.getTranslateX();
              esamegennaio2017.yr = esamegennaio2017.rect.getTranslateY();
              esamegennaio2017.rect.setTranslateX(esamegennaio2017.xr+z);
              esamegennaio2017.rect.setTranslateY(esamegennaio2017.yr);
        }
        
        else if(figura.equalsIgnoreCase("Esagono")){
              esamegennaio2017.xh = esamegennaio2017.hexagon.getTranslateX();
              esamegennaio2017.yh = esamegennaio2017.hexagon.getTranslateY();
              esamegennaio2017.hexagon.setTranslateX(esamegennaio2017.xh+z);
              esamegennaio2017.hexagon.setTranslateY(esamegennaio2017.yh);
        }
     }
//############################################################################
//#################    SPOSTA FIGURA A SINISTRA    ###########################
//############################################################################
 /**
 * Questa funzione sposta la figura selezionata A SINISTRA rispetto al layout
 * @param figura parametro formale, quando richiamerò la funzione la stringa 
 *              corrispondente (parametro attuale) sarà la figura specifica
 */ 
   public void spostaSinistra(String figura){
         
        double z = prendiValoreSpostamento();
        
            if(figura.equalsIgnoreCase("Cerchio")){
            esamegennaio2017.xc = esamegennaio2017.circle.getTranslateX();
            esamegennaio2017.yc = esamegennaio2017.circle.getTranslateY();
            esamegennaio2017.circle.setTranslateX(esamegennaio2017.xc-z);
            esamegennaio2017.circle.setTranslateY(esamegennaio2017.yc);

        }
        else if(figura.equalsIgnoreCase("Quadrato")){
              esamegennaio2017.xr = esamegennaio2017.rect.getTranslateX();
              esamegennaio2017.yr = esamegennaio2017.rect.getTranslateY();
              esamegennaio2017.rect.setTranslateX(esamegennaio2017.xr-z);
              esamegennaio2017.rect.setTranslateY(esamegennaio2017.yr);
        }
        
        else if(figura.equalsIgnoreCase("Esagono")){
              esamegennaio2017.xh = esamegennaio2017.hexagon.getTranslateX();
              esamegennaio2017.yh = esamegennaio2017.hexagon.getTranslateY();
              esamegennaio2017.hexagon.setTranslateX(esamegennaio2017.xh-z);
              esamegennaio2017.hexagon.setTranslateY(esamegennaio2017.yh);
        }
   }
/**
 * Questa funzione sposta la figura selezionata in GIu rispetto al layout
 */
 public void spostaFigureInGiu3(){
        
        double x = esamegennaio2017.rect.getX();
        double y  = esamegennaio2017.rect.getY();
        
 //############################################################################
//#########   for--> usato per spostare il rettangolo in basso     ############
//############################################################################
        
    timeline = new Timeline();
    timeline.setCycleCount(Animation.INDEFINITE);
    timeline.getKeyFrames().add(new KeyFrame(Duration.millis(1000), 
                                        event -> maverick("rettangolo")));
    timeline.play();

 //############################################################################
//###########################################################################       

    timeline1 = new Timeline();
    timeline1.setCycleCount(Animation.INDEFINITE);
    timeline1.getKeyFrames().add(new KeyFrame(Duration.millis(1000), 
                                                event -> maverick("cerchio")));
    timeline1.play();
//############################################################################
//###########################################################################         

    timeline2 = new Timeline();
    timeline2.setCycleCount(Animation.INDEFINITE);
    timeline2.getKeyFrames().add(new KeyFrame(Duration.millis(1000),
                                            event -> maverick("esagono")));
    timeline2.play();

} 
 
 
 
 
 
 
 
 
 //############################################################################
//#####   FUNZIONE PER FERMARE LE ANIMAZIONI DELLE FIGURE    ##################
//#############################################################################
/**
 * Questa funzione feerma l'animazione  su cui e' invocata
 */    
     public void fermaAnimazioneFigure(){
             timeline.stop();
             timeline1.stop();
             timeline2.stop();
     }
//########################################################################
     
//############################################################################
//###   FUNZIONE CHE PRENDE IL VALORE IMMESSO DALL'UTENTE NEL TEXTFIELD   #####
//###    SERVE PER DIRE DI QUANTI PIXEL DEVONO SPOSTARSI LE FIGURE     ########
//##############   PRENDE IL VALORE DALLA TEXTFIELD    ########################
//############################################################################
 /**
 * Questa funzione prende il valore che e' inserito nel textfield e lo assegna 
 * ad una variabile
 */   
     public double  prendiValoreSpostamento(){
         
        String p;
        Double sp=0.0;
        
        try{
            p = FinestraRegia.text1.getText();
            sp = Double.parseDouble(p);
             return sp;
            
        }catch(Exception e){

//####################      FINESTRA DI AVVISO        ######################### 
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("ATTENZIONE!");
            alert.setHeaderText(null);
            alert.setContentText("Inserisci un numero valido");

            alert.showAndWait();
             return sp;
       }
    }
//############################################################################   












     
//###########################################################################
 //#########    FUNZIONE PER CAMBIARE IL COLORE DELLA FIGURA   ################
 //###########################################################################
 /**
 * Questa funzione cambia il colore della figura in maniera casuale grazie
 * alla funzione randInt
 * @param figura parametro formale, quando richiamerò la funzione la stringa 
 *              corrispondente (parametro attuale) sarà la figura specifica
 */
     public void cambiaColoreFigura(String figura){
         
        //dichiarazione di un array di 5 colori
        Color[] colors= new Color[5];
        //Inizializzazione array
        colors[0] = Color.RED;
        colors[1] = Color.BLUE;
        colors[2] = Color.YELLOW;
        colors[3] = Color.ORANGE;
        colors[4] = Color.GREEN;
        int num= randInt(0, 4);
        System.out.println("Il colore scelto e': "+colors[num]);
        
        if(figura.equalsIgnoreCase("Cerchio")){
        esamegennaio2017.circle.setFill(colors[num]);
        }
        else if(figura.equalsIgnoreCase("quadrato")){
            esamegennaio2017.rect.setFill(colors[num]);
        }
        else{
             esamegennaio2017.hexagon.setFill(colors[num]);
        }
    }
 //###########################################################################
//#######    FUNZIONE PER GENERARE UN VALORE CASUALE TRA 0 E 5     ############
//###########################################################################
 /**
 * Questa funzione ritorna un valore casuale, che viene preso dallo specifico 
 * intervallo su cui e' chiamata
 * @param min parametro formale, che indica il valore minimo
 * @param max parametro formale, che indica il valore massimo
 */    
    public static int randInt(int min,int max) { 
        return (min+ (int)(Math.random()* ((max-min)+1)));
    }
//###########################################################################
    
//###########################################################################
//#######    FUNZIONE PER SELEZIONARE LA FIGURA NEL CHOICEBOX     ############
//###########################################################################
/**
 * Questa funzione (senza parametri) serve per assegnare alla variabile 
 * "output" il valore che assume il ChoiceBox al momento del click da parte 
 * dell'utente; questo valore verrà poi stampato.
 */
public void selezionaFigura(){
 output =FinestraRegia.choice.getSelectionModel().getSelectedItem().toString();
 System.out.println(output);
                  
 }
//###########################################################################
//###########################################################################
 /**
 * Questa funzione è responsabile del movimento in giù delle 3 figure e sarà 
 * richiamata come secondo parametro all'interno del Keyframe e sostituisce
 * il KeyValue
 * @param componente parametro formale, quando richiamerò la funzione la stringa 
 *              corrispondente (parametro attuale) sarà la figura specifica
 */   
   private void  maverick(String componente) {
           
       if(componente.equalsIgnoreCase("rettangolo")){
            timeline.play();
            System.out.println("rettangolo");
            esamegennaio2017.rect.setTranslateY(esamegennaio2017.rect.
                                                            getTranslateY()+ 5);
            timeline.play();
            }
       if(componente.equalsIgnoreCase("cerchio")){
            timeline1.play();
            System.out.println("cerchio");
            esamegennaio2017.circle.setTranslateY(esamegennaio2017.circle.
                                                            getTranslateY()+ 5);
            timeline1.play();
            }
       if(componente.equalsIgnoreCase("esagono")){
            timeline2.play();
            System.out.println("esagono");
            esamegennaio2017.hexagon.setTranslateY(esamegennaio2017.hexagon.
                                                            getTranslateY()+ 5);
            timeline2.play();
            }
   }
    
}


