package it.polito.tdp.alien;

import java.util.*;

public class WordEnhanced {
	
	private String alienWord;
	private List <String> translationList;
	
	private String translation;
	
	public WordEnhanced(String alienWord) {
		super();
		this.alienWord = alienWord;
		this.translationList = new ArrayList<String>();
	}
	
	/**
	 * Aggiungo
	 * @param translation alla lista contenente le traduzioni
	 */
	public void addTranslation (String translation) {
		translationList.add(translation);
	}

	public String getAlienWord() {
		return alienWord;
	}
	
	public String getTranslationList() {
		String traduzioni = "";
		for(String w : translationList) {
			traduzioni += w + "\n";
		}
		return traduzioni;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alienWord == null) ? 0 : alienWord.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WordEnhanced other = (WordEnhanced) obj;
		if (alienWord == null) {
			if (other.alienWord != null)
				return false;
		} else if (!alienWord.equals(other.alienWord))
			return false;
		return true;
	}
	
	
	
	
}
