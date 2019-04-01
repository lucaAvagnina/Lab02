

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.alien.AlienDictionary;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtWord;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;
    
    private AlienDictionary alienDictionary = new AlienDictionary();
    
    @FXML
    void doReset(ActionEvent event) {
    	alienDictionary.clearDictionary();
    	txtResult.clear();
    }

    @FXML
    void doTranslate(ActionEvent event) {
    	
    	String alienWord;
    	String translation;
    	
    	String[] dato = txtWord.getText().split(" ");
    	alienWord = dato[0].toLowerCase();
    	
    	
    	
    	if(dato.length == 2) {
    		translation = dato[1].toLowerCase();
    		if(alienWord.matches("[a-zA-Z]+") && translation.matches("[a-zA-Z]+")) {
    			alienDictionary.addWord(alienWord, translation);
    			txtWord.clear();
       		}
    	}
    	else if(dato.length == 1) {
    		
    		if(alienWord.contains("?")) {
    			alienWord.replaceFirst("?", ".");
    			int conta = 0;
    			for(char c : alienWord.toCharArray()) {
    				if(c == '.') {
    					conta++;
    					if(conta > 1) {
    						txtResult.appendText("Troppe lettere sconosciute");
    						return;
    					}
    				}		
    			}		
    		}
    		
    		if(alienWord.matches("[a-zA-Z]+")) {
    			translation = alienDictionary.translateWord(alienWord);
    			txtResult.clear();
    			txtWord.clear();
    			if(translation != null)
    				txtResult.appendText(translation);
    			else
    				txtResult.appendText("Parola sconosciuta");
    		}
    	}
    }

    @FXML
    void initialize() {
        assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";

    }
}
