/**
 * Perform the Knuth-Morris-Pratt string search. The algorithm first pre-processes the word to create a Partial Match
 * Table. The table is creatd in O(n) where n is the length of the word. After the pre-processing, the actual search can
 * be performed in O(k) where k is the size of the sentence.
 */
public class KMPStringSearch {
	/**
	 * Searches for all occurances of the word in the sentence. Runs in O(n+k) where n is the word length and k is the
	 * sentence length.
	 * 
	 * @param word The word that is being searched
	 * @param sentence The collections of word over which the search happens.
	 * @return The list of starting indices of the matched word in the sentence. Empty list in case of no match.
	 */
	public List<Integer> searchString(final String word, final String sentence) {
		final List<Integer> matchedIndices = new ArrayList<>();
 
		final int sentenceLength = sentence.length();
		final int wordLength = word.length();
		int beginMatch = 0; // the starting position in sentence from which the match started
		int idxWord = 0; // the index of the character of the word that is being compared to a character in string
		final List<Integer> partialTable = createPartialMatchTable(word);
		while (beginMatch + idxWord < sentenceLength)
			if (word.charAt(idxWord) == sentence.charAt(beginMatch + idxWord)) {
				// the characters have matched
				if (idxWord == wordLength - 1) {
					// the word is complete. we have a match.
					matchedIndices.add(beginMatch);
					// restart the search
					beginMatch = beginMatch + idxWord - partialTable.get(idxWord);
					if (partialTable.get(idxWord) > -1) idxWord = partialTable.get(idxWord);
					else idxWord = 0;
				} else idxWord++;
			} else {
				// mismatch. restart the search.
				beginMatch = beginMatch + idxWord - partialTable.get(idxWord);
				if (partialTable.get(idxWord) > -1) idxWord = partialTable.get(idxWord);
				else idxWord = 0;
			}
 
		return Collections.unmodifiableList(matchedIndices);
	}
 
	/**
	 * Creates the Partial Match Table for the word. Runs in O(n) where n is the length of the word.
	 * 
	 * @param word The word whose Partial Match Table is required.
	 * @return The table as a list of integers.
	 */
	public List<Integer> createPartialMatchTable(final String word) {
		if (StringUtils.isBlank(word)) return Collections.EMPTY_LIST;
 
		final int length = word.length();
		final List<Integer> partialTable = new ArrayList<>(length + 1);
		partialTable.add(-1);
		partialTable.add(0);
 
		final char firstChar = word.charAt(0);
		for (int idx = 1; idx < word.length(); idx++) {
			final int prevVal = partialTable.get(idx);
			if (prevVal == 0) {
				if (word.charAt(idx) == firstChar) partialTable.add(1);
				else partialTable.add(0);
			} else if (word.charAt(idx) == word.charAt(prevVal)) partialTable.add(prevVal + 1);
			else partialTable.add(0);
		}
 
		return Collections.unmodifiableList(partialTable);
	}
}
