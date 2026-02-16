import Stabel.ParantesSjekk;

public class TestParentesSjekk {
    static void main(String[] args) {

        ParantesSjekk tab = new ParantesSjekk();
        System.out.println("Er listen tom?: " + tab.isEmpty());
        tab.push("{ [ ( ) ] }");
        System.out.println("Er listen tom?: " + tab.isEmpty());
        System.out.println(tab.peek());
        tab.pop();
        System.out.println(tab.peek());
        tab.push("{ [ ( ) ] }");
        tab.push("{ [ ( ) }");
        System.out.println(tab.peek());
        tab.clear();
        System.out.println(tab.peek());

    }


}
