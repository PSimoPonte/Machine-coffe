
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Simone.Pontalti
 */
//#############################################################################
  //###########################################################################
//#############################################################################
  //###########       FATTO IN UN ALTRO MODO!!!!!!!!      #####################
//#############################################################################
  //###########################################################################
public class GestoreEvento2 implements EventHandler<KeyEvent> {
    
    @Override
    public void handle(KeyEvent e){
        
        KeyCode st = e.getCode();
        switch(st){
        
            case I: System.out.println("Hai cliccato su I");
            
            break;
            
            case J: System.out.println("Hai cliccato su J");
            
            break;
            
            case K: System.out.println("Hai cliccato su K");
            
            break;
            
            case L: System.out.println("Hai cliccato su L");
            
            break;
            
            
        }
        
    
    }
    
}
