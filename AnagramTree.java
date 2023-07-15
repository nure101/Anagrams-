public class AnagramTree {
  //  private TreeNode head;
    int w;

    private class TreeNode {
        byte[] summary;
        WordNode words;
        TreeNode left;
        TreeNode right;

        public TreeNode(byte[] summary, WordNode words) {
            this.summary = summary;
            this.words = null;
            this.left = null;
            this.right = null;
        }
    }

    private class WordNode {
        String word;
        WordNode next;

        public WordNode(String word, WordNode next) {
            this.word = word;
            this.next = next;
        }

    }
    private TreeNode head;
    public AnagramTree() {
       // AnagramTree head = new AnagramTree();
       byte[] use = stringToSummary("null");
        head = new TreeNode(use,new WordNode(null, null));
    }

    public void add(String word) {
        if (word == null || word.isEmpty()) {
            return; // do nothing if word is null or empty
        }
        
        byte[] some = stringToSummary(word);
        // if (head == null) {
        //     head = new TreeNode(some);
        //     head.words = new WordNode(word,null);
        // }
        //System.out.println(head.words.word);
        TreeNode current = head;
        while (current != null) {
           // System.out.println(current.words.word);
           //compare results 
            int CR = compareSummaries(some, current.summary);
            if (CR == 0) {
                    WordNode wordNode = current.words;
                    while (wordNode != null) {
                    if (wordNode.word.equals(word)) {
                        return;
                    }
                    else {
                    wordNode =  wordNode.next;
                    }
                    }
                    // 
                    WordNode old = current.words;
                    WordNode present_word =new WordNode(word,old);
                    current.words = present_word;
                    return;
            } else if (CR < 0) {
                // word added to the left subtree
                if (current.left == null) {
                    // create a new node 
                    current.left = new TreeNode(stringToSummary(word), new WordNode(word, null));
                    current.left.words = new WordNode(word,null);
                    return;
                } else {
                    // searching left subtree
                    current = current.left;
                }
            } else {
                // word added to the right subtree
                if (current.right == null) {
                    // create a new node for the word and add it as a right child
                    current.right = new TreeNode(stringToSummary(word), new WordNode(word, null));
                    current.right.words = new WordNode(word,null);
                    return;
                } else {
                    // searching right subtree
                    current = current.right;
                }
            }
        }
    }
    

    private int compareSummaries(byte[] left, byte[] right) {

        for (int i =0; i < left.length; i++) {
            if (left[i] != right[i]) {
                return left[i] - right[i];
            }
        }
        return 0;
    }

    public void anagrams() {
        traverse(head);
    }
    
    private void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        traverse(node.left);
        WordNode idk = node.words;
        if (idk != null && idk.next != null) {
            while (idk != null) {
                System.out.print(idk.word + " ");
                w++;
                idk = idk.next;
                //node = node.words.next;
                }
            System.out.println();
        }
    
        traverse(node.right);
    }
    
    private byte[] stringToSummary(String word) {
        byte[] summary = new byte[26];
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            summary[index]++;
        }
        return summary;
    }

    private int num() {
        return w;
    }
}
