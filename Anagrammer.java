public class Anagrammer {
    public static void main(String[] args) {
    // Make an instance of Words that reads words from a text file.
    Words words = new Words("war_and_peace.txt");

    // Make an empty AnagramTree.
    AnagramTree anagramTree = new AnagramTree();

    // Read all the words from the text file and add them to the tree.
    while (words.hasNext()) {
        String word = words.next();
        anagramTree.add(word);
    }

    // Finally, traverse the tree to print all its anagrams.
   // anagramTree.printAnagrams();
    anagramTree.anagrams();
    //System.out.println(anagramTree.w);
}
}