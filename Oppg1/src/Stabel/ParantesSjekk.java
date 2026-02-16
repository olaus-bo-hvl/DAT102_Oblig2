package Stabel;

public class ParantesSjekk implements StabelADT<String> {

    Node<String> node;


    @Override
    public void push(String newEntry) {
        Node<String> temp = node;
        node = new Node<>(newEntry);
        node.neste = temp;
    }

    @Override
    public String pop() {
        Node<String> temp;
        if (isEmpty()) {
            return null;
        } else if (node.neste == null) {
            temp = node;
            node = null;
        } else {
            temp = node;
            node = node.neste;
        }
        return temp.data;
    }

    @Override
    public String peek() {
        if (!isEmpty()) {
            return node.data;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return node == null;
    }

    @Override
    public void clear() {
        if (isEmpty()) {
            return;
        }
        node = null;
    }

    public char[] stringToChar(String s) {
        return s.toCharArray();
    }

    public boolean erStartParentes(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    public boolean erSluttParentes(char c) {
        return c == ')' || c == ']' || c == '}';
    }

    public boolean erParentesPar(char start, char slutt) {
        if (start == '(' && slutt == ')') {
            return true;
        } else if (start == '[' && slutt == ']') {
            return true;
        } else if (start == '{' && slutt == '}') {
            return true;
        }
        return false;
    }

    public boolean SjekkParenteser(String s) {

        ParantesSjekk temp = new ParantesSjekk();

        char[] t = stringToChar(s);
        for (char c : t) {
            if (erStartParentes(c)) {
                temp.push(String.valueOf(c));
            } else if (erSluttParentes(c)) {
                if (!temp.isEmpty()){
                    if (temp.peek() != null && erParentesPar(temp.peek().charAt(0), c)) {
                        //Tar ut startparentesen hvis den matcher med sluttparentesen
                        temp.pop();
                    } else {
                        //returnerer false hvis det ikke går opp
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return temp.isEmpty();
    }
}
