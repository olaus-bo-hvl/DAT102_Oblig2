package Stabel;

public class ParentesMain {
    public static void main(String[] args) {
        ParantesSjekk tab = new ParantesSjekk();
        String s = """
            class HelloWorld {
            public static void main(String[] args) {
            System.out.println("Hello World!");
            }
            }
            """;

        tab.push(s);

        System.out.println(tab.SjekkParenteser(tab.peek()));
    }
}
