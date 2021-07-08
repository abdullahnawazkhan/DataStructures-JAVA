import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class Trie {

    private class Node {

        Node parent;
        Node[] children = new Node[26];
        ArrayList<String> synonyms = new ArrayList<String>();
        boolean flag;
        String meaning;

        Node() {

            for (int i = 0; i < 26; i++) {

                children[i] = null;

            }
            flag = false;
            meaning = "";
            synonyms.clear();
            parent = null;

        }

    }

    private Node root;

    public Trie() {

        root = new Node();

    }

    public boolean find(String word) {

        word = word.toLowerCase();

        Node traverseNode = root;

        for (int i = 0; i < word.length(); i++) {

            if (traverseNode == null) {

                break;

            }

            traverseNode = traverseNode.children[((int) word.charAt(i)) - 97];

        }

        if ((traverseNode == null) || (traverseNode.flag == false)) {

            return false;

        }
        else{

            return true;

        }

    }

    private boolean findWithPrefix(String prefix) {

        Node prefixNode = root;

        for (int i = 0; i < prefix.length(); i++) {

            prefixNode = prefixNode.children[((int)prefix.charAt(i)) - 97];

        }

        if (prefixNode != null) {
            
            for (int i = 0; i < 26; i++) {

                if (prefixNode.children[i] != null) {

                    return true;

                }

            }

        }   
        
        return false;

    }

    private boolean checkIfEmpty() {

        for (int i = 0; i < 26; i++) {

            if (root.children[i] != null) {

                return false;

            }

        }

        return true;

    }

    public void insert(String word) {

        word = word.toLowerCase();

        if (find(word) == true) {

            System.out.println("The Word is already added in TRIE");

        }
        else {

            Node insertionNode = root;

            for (int i = 0; i < word.length(); i++) {

                int index = ((int) word.charAt(i)) - 97;

                if (insertionNode.children[index] == null) {

                    insertionNode.children[index] = new Node();
                    insertionNode.children[index].parent = insertionNode;

                }

                insertionNode = insertionNode.children[index];

            }

            insertionNode.flag = true;

        }

    }

    public void addMeaning(String word, String meaning) {

        if (checkIfEmpty() == true) {

            System.out.println("The TRIE is empty");

        }
        else {

            word = word.toLowerCase();

            if (find(word) == false) {

                System.out.println("Word does not exist in TRIE");

            }
            else {

                Node traverseNode = root;

                for (int i = 0; i < word.length(); i++) {

                    traverseNode = traverseNode.children[((int) word.charAt(i)) - 97];

                }

                traverseNode.meaning = meaning;

            }
            
        }
    
    }

    public String getMeaning(String word) {

        if (checkIfEmpty() == true) {

            return "The TRIE is Empty";

        }
        else {        

            word = word.toLowerCase();

            if (find(word) == false) {

                return "Word does not exist in TRIE";

            }
            else {

                Node traverseNode = root;

                for (int i = 0; i < word.length(); i++) {

                    traverseNode = traverseNode.children[((int) word.charAt(i)) - 97];

                }

                return traverseNode.meaning;

            }

        }

    }

    public void addSynonym(String word, String synonym) {

        if (checkIfEmpty() == true) {

            System.out.println("The TRIE is empty");

        }
        else {

            word = word.toLowerCase();

            if (find(word) == false) {

                System.out.println("Word does not exist in TRIE");

            }
            else {

                Node traverseNode = root;

                for (int i = 0; i < word.length(); i++) {

                    traverseNode = traverseNode.children[((int) word.charAt(i)) - 97];

                }

                traverseNode.synonyms.add(synonym);

            }

        }

    }

    public void addSynonyms(String word, ArrayList<String> synonyms) {

        if (checkIfEmpty() == true) {

            System.out.println("The TRIE is empty");

        }
        else {

            word = word.toLowerCase();

            if (find(word) == false) {

                System.out.println("Word does not exist in TRIE");

            }
            else {

                Node traverseNode = root;

                for (int i = 0; i < word.length(); i++) {

                    traverseNode = traverseNode.children[((int) word.charAt(i)) - 97];

                }

                traverseNode.synonyms = synonyms;

            }

        }

    }

    public ArrayList<String> getSynonyms(String word) {

        if (checkIfEmpty() == true) {

            ArrayList<String> returnList = new ArrayList<String>();
            returnList.add("TRIE is empty");

            return returnList;

        }
        else {

            word = word.toLowerCase();

            if (find(word) == false) {

                ArrayList<String> returnList = new ArrayList<String>();
                returnList.add("Word does not exist in TRIE");

                return returnList;

            }
            else {

                Node traverseNode = root;

                for (int i = 0; i < word.length(); i++) {

                    traverseNode = traverseNode.children[((int) word.charAt(i)) - 97];

                }

                return traverseNode.synonyms;

            }

        }

    }

    public void deleteWord(String word) {

        if (checkIfEmpty() == true) {

            System.out.println("TRIE is empty");

        }
        else {

            word = word.toLowerCase();

            if (find(word) == false) {

                System.out.println("Word does not exist in TRIE");

            }
            else {

                Node lastNode = root;

                for (int i = 0; i < word.length(); i++) {

                    lastNode = lastNode.children[((int) word.charAt(i)) - 97];

                }

                lastNode.flag = false;
                lastNode.meaning = "";
                lastNode.synonyms.clear();

                for (int i = word.length() - 1; i >= 0; i--) {

                    boolean children = false;

                    for (int j = 0; j < 26; j++) {

                        if (lastNode.children[j] != null) {

                            children = true;
                            break;

                        }

                    }

                    if (children == false && lastNode.flag == false) {

                        lastNode.parent.children[((int) word.charAt(i)) - 97] = null;
                        lastNode = lastNode.parent;

                    }
                    else {

                        break;

                    }

                }

            }

        }

    }

    private void outputAscending(Node node, String str) {

        if (node.flag == true) {

            System.out.println(str);

        }
        for (int i = 0; i < 26; i++) {

            if (node.children[i] != null) {

                str = str + ((char)(i + 97));

                outputAscending(node.children[i], str);

                str = str.substring(0, str.length() - 1);

            }

        }

    }

    public void outputAscending() {

        if (checkIfEmpty() == true) {

            System.out.println("TRIE is empty");

        }
        else { 
        
            outputAscending(root, "");

        }

    }

    private void outputDescending(Node node, String str) {

        if (node.flag == true) {

            System.out.println(str);

        }
        for (int i = 25; i >=0; i--) {

            if (node.children[i] != null) {

                str = str + ((char)(i + 97));

                outputAscending(node.children[i], str);

                str = str.substring(0, str.length() - 1);

            }

        }

    }

    public void outputDescending() {

        if (checkIfEmpty() == true) {

            System.out.println("TRIE is empty");

        }
        else {
        
            outputDescending(root, "");

        }

    }

    public void outputOfPrefix(String prefix) {

        if (checkIfEmpty() == true) {

            System.out.println("TRIE is empty");

        }
        else {

            if (findWithPrefix(prefix) == false) {

                System.out.println("No Word exists with prefix");

            }
            else {
            
                Node prefixNode = root;

                for (int i = 0; i < prefix.length(); i++) {

                    prefixNode = prefixNode.children[((int)prefix.charAt(i)) - 97];

                }

                outputAscending(prefixNode, prefix);
                
            }

        }

    }

    private void outputOfLength(int length, Node node, String str, int index) {

        if (node.flag == true && index == length) {

            System.out.println(str);

        }
        for (int i = 0; i < 26; i++) {

            if (node.children[i] != null) {

                str = str + ((char)(i + 97));

                index++;

                outputOfLength(length, node.children[i], str, index);

                str = str.substring(0, str.length() - 1);

                index--;

            }

        }

    }

    public void outputOfLength(int length) {

        outputOfLength(length, root, "", 0);

    }

    public void createDictionary(String file) {

        for (int i = 0; i < 26; i++) {

            root.children[i] = null;

        }
    
        try {

            Scanner sc = new Scanner(new File(file));

            String word = "";
            String newLine = "";

            while (sc.hasNextLine()) {

                newLine = sc.nextLine();

                if (newLine.charAt(0) != '-') { //word

                    word = newLine;

                    insert(word);

                }
                else if (newLine.charAt(0) == '-' && newLine.charAt(1) != '-') {  //meaning

                    addMeaning(word, newLine.substring(1, newLine.length()));

                }
                else {   //synonym

                    addSynonym(word, newLine.substring(2, newLine.length()));

                }

            }

            sc.close();

        }
        catch (Exception e) {

            e.printStackTrace();

        }
    
    }

}