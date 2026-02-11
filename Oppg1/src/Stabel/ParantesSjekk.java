package Stabel;
import Stabel.StabelADT;

public class ParantesSjekk implements StabelADT<String> {

    String start = null;
    String neste = null;

    @Override
    public void push(String newEntry) {
        if (isEmpty()) {
            start = newEntry;
        } else {
            neste = start;
            start = newEntry;
        }
    }

    @Override
    public String pop() {
        String temp;
        if (isEmpty()) {
            return null;
        } else {
            temp = start;
            start = neste;
            return temp;
        }
    }

    @Override
    public String peek() {
        if (!isEmpty()) {
            return start;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        if (start == null) {
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        start = null;
        neste = null;
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
