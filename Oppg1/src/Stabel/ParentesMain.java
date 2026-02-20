package Stabel;

public class ParentesMain {
    public static void main(String[] args) {
        ParantesSjekk tab = new ParantesSjekk();
        ParantesSjekk tab2 = new ParantesSjekk();
        ParantesSjekk tab3 = new ParantesSjekk();
        ParantesSjekk tab4 = new ParantesSjekk();

        String s = "{ [ ( ) ] }";
        String t = "{ [ ( ) }";
        String u = "[ ( ) ] }";
        String v = "{ [ ( ] ) }";
        
        tab.push(s);
        tab2.push(t);
        tab3.push(u);
        tab4.push(v);

        System.out.println(tab.SjekkParenteser(tab.peek()));
        System.out.println(tab.SjekkParenteser(tab2.peek()));
        System.out.println(tab.SjekkParenteser(tab3.peek()));
        System.out.println(tab.SjekkParenteser(tab4.peek()));
    }
}
