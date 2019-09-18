package app;

import check.type.Check;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Grammar;
import entity.Rule;
import entity.Type;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

import static check.type.Check.check;

public class Application {
    public static void main(String[] args) {
        //saveGrammar();
        Grammar gr = loadGrammar("gram.json");
        Type type = check(gr);
        System.out.println(type.toString());
    }

    private static void saveGrammar(){
        Grammar grammar = new Grammar();
        grammar.setTerminal(new char[]{'b', 'c'});
        grammar.setNotTerminal(new char[]{'A'});
        Rule rule1 = new Rule();
        rule1.setFrom(new char[]{'A'});
        rule1.setTo(new char[]{'b', 'A'});

        Rule rule2 = new Rule();
        rule2.setFrom(new char[]{'A'});
        rule2.setTo(new char[]{'c'});
        Set<Rule> rules = new HashSet<>();
        rules.add(rule1);
        rules.add(rule2);

        grammar.setRules(rules);

        GsonBuilder builder = new GsonBuilder();
       // builder.setPrettyPrinting();
        Gson gs = builder.create();
        String str = gs.toJson(grammar);

        try {
            FileWriter fileWriter = new FileWriter("gram.json");
            fileWriter.write(str);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Grammar loadGrammar(String filepath){
        Grammar grammar = null;
        try(BufferedReader br = new BufferedReader(new FileReader(filepath))){
            String json = br.readLine();

            Gson gson = new GsonBuilder().create();
            grammar = gson.fromJson(json, Grammar.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return grammar;
    }
}
