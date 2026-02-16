package Stabel;

public class ParantesSjekk implements StabelADT<String> {

    Node<String> node = new Node("{ [ ( ) ] }");


    @Override
    public void push(String newEntry) {
        if (isEmpty()) {
            node.data = newEntry;
        } else {
            node.neste.data = node.data;
            node.data = newEntry;
        }
    }

    @Override
    public String pop() {
        String temp;
        if (isEmpty()) {
            return null;
        } else {
            temp = node.data;
            node.data = node.neste.data;
            return temp;
        }
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
        if (node.data == null) {
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        node.neste.data = null;
        node.data = null;
    }

    public char[] stringToChar(String s) {
        return s.toCharArray();
    }

    public boolean erStartParentes(char c) {
        if (c == '(' || c == '[' || c == '{') {
            return true;
        }
        return false;
    }

    public boolean erSluttParentes(char c) {
        if (c == ')' || c == ']' || c == '}') {
            return true;
        }
        return false;
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
            }
            if (erSluttParentes(c)) {
                if (temp.peek() != null && erParentesPar(temp.peek().charAt(0), c)) {
                    //Tar ut startparentesen hvis den matcher med sluttparentesen
                    temp.pop();
                } else {
                    //returnerer false hvis det ikke går opp
                    return false;
                }
            }
        }
        if (temp.isEmpty()) {
            return true;
        }
        return false;
    }
}
