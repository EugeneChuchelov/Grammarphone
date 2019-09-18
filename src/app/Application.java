package app;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Grammar;
import entity.Type;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static check.type.Check.check;
import static ui.GrammarInput.input;

public class Application {
    public static void main(String[] args) {
//        saveGrammar();
        Grammar gr = input();
        Type type = check(gr);
        System.out.println(type.toString());
    }

//    private static void saveGrammar() {
//        Grammar grammar = new Grammar();
//        grammar.setTerminal(new char[]{'a', 'b', '+', '-'});
//        grammar.setNotTerminal(new char[]{'S', 'A'});
//
//        Rule rule1 = new Rule();
//        rule1.setFrom(new char[]{'S'});
//        rule1.setTo(new char[]{'A', '+', 'A', '-', 'A'});
//
//        Rule rule2 = new Rule();
//        rule2.setFrom(new char[]{'A'});
//        rule2.setTo(new char[]{'a'});
//
//        Rule rule3 = new Rule();
//        rule3.setFrom(new char[]{'A'});
//        rule3.setTo(new char[]{'b'});
//
//        Set<Rule> rules = new HashSet<>();
//        rules.add(rule1);
//        rules.add(rule2);
//        rules.add(rule3);
//
//        grammar.setRules(rules);
//
//        GsonBuilder builder = new GsonBuilder();
//        // builder.setPrettyPrinting();
//        Gson gs = builder.create();
//        String str = gs.toJson(grammar);
//
//        try {
//            FileWriter fileWriter = new FileWriter("gram.json");
//            fileWriter.write(str);
//            fileWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    private static Grammar loadGrammar(String filepath) {
        Grammar grammar = null;
        try (FileReader r = new FileReader(filepath)) {
            Gson gson = new GsonBuilder().create();
            grammar = gson.fromJson(r, Grammar.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return grammar;
    }
}
