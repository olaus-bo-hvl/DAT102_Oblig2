package Stabel;

public class ParentesMain {
    public static void main(String[] args) {
        ParantesSjekk tab = new ParantesSjekk();
        String s = "{ [ ( ) ] }";

        tab.push(s);

        System.out.println(tab.SjekkParenteser(tab.peek()));
    }
}
