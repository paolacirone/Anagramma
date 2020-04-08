package it.polito.tdp.anagramma.model;

import java.util.ArrayList;
import java.util.List;

public class Ricerca {

	private List<String> soluzione;

	/**
	 * Genera tutti gli anagrammi della parola specificata in ingresso.
	 * 
	 * @param parola parola da anagrammare
	 * @return elenco di tutti gli anagrammi della parola data
	 */
	public List<String> anagrammi(String parola) {
		this.soluzione = new ArrayList<>();

		parola = parola.toUpperCase();

		List<Character> disponibili = new ArrayList<>();
		// aggiungo tutti i caratteri della parola nella stringa
		for (int i = 0; i < parola.length(); i++) {
			disponibili.add(parola.charAt(i));
		}

		// avvia la ricorsione
		cerca("", 0, disponibili);

		return this.soluzione;
	}

	/**
	 * Procedura ricorsiva per il calcolo dell'anagramma.
	 * 
	 * @param parziale    parte iniziale dell'anagramma costruito finora
	 * @param livello     livello della ricorsione, sempre uguale a
	 *                    parziale.length()
	 * @param disponibili insieme delle lettere non ancora utilizzate
	 */
	private void cerca(String parziale, int livello, List<Character> disponibili) {
		if (disponibili.size() == 0) { // livello==parola.length()
			// caso terminale --- quando il livello è ugaule alla lungheza della parola o se
			// non abbiamo più lettere disponibili

			// if(parziale è nel dizionario)
			// if( parziale non è presente nella soluzione )
			this.soluzione.add(parziale); // devo salvarla tra l'elenco delle soluzioni possibili
		}

		// caso normale
		// provare ad aggiungere a 'parziale' tutti i caratteri presenti tra
		// i 'disponibili'
		for (Character ch : disponibili) {
			String tentativo = parziale + ch;

			// if(nel dizionario esistono delle parole che iniziano con 'tentativo'?)

			List<Character> rimanenti = new ArrayList<>(disponibili); // è ugaule all precedente meno il carattere ch
			rimanenti.remove(ch); // non è possibile rimuovere da quella su cui sto iterando

			cerca(tentativo, livello + 1, rimanenti);
		}
	}

}

/*
 * Dato di partenza: parola da anagrammare, di lunghezza N Soluzione parziale:
 * una parte dell'anagramma già costruito (i primi caratteri). Livello: numero
 * di lettere di cui è composta la soluzione parziale. Soluzione finale:
 * soluzione di lunghezza N -> caso terminale Caso terminale: salvare la
 * soluzione trovate Generazione delle nuove soluzioni: provare a aggiungere una
 * lettera, scegliendola tra quelle che non sono ancora state utilizzate (nella
 * soluzione parziale).
 */