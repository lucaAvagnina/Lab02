package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {
	
	//private List <Word> alienDictionary = new LinkedList <Word> ();
	private List <WordEnhanced> alienDictionary = new LinkedList <WordEnhanced> ();
	
	
	public void addWord(String alienWord, String translation) {
		//Word wordTemp = new Word(alienWord, translation);
		WordEnhanced wordTemp = new WordEnhanced(alienWord);
		
		if(alienDictionary.contains(wordTemp)) {
			//wordTemp.setTranslation(translation);
			alienDictionary.get(alienDictionary.indexOf(wordTemp)).addTranslation(translation);
		}
		
		else {
			alienDictionary.add(wordTemp);
			wordTemp.addTranslation(translation);
		}
		
	}

	/**
	 * Fa la traduzione
	 * @param alienWord  
	 * @return translation se c'e' la alienWord cercata nel dizionario, null altrimenti
	 */
	public String translateWord(String alienWord) {
//		int numRisultati = 0;
//		if(alienWord.contains(".")) {
//			
//		}
		for(/*Word*/WordEnhanced w : alienDictionary) {
			if(w.getAlienWord().compareTo(alienWord) == 0) {
				//return w.getTranslation();
				return w.getTranslationList();
			}
		}
		
		return null;
	}
	
	public void clearDictionary() {
		alienDictionary.clear();
	}
	
}
