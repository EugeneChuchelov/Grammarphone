package app;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Grammar;
import entity.Type;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static check.type.Check.check;
import static ui.GrammarInput.input;

public class Application {
    public static void main(String[] args) {
        Grammar gr = null;

        if(args.length > 0){
            if(args[0].equals("-l")){
                gr = loadGrammar(args[1]);
            }
            if(args[0].equals("-s")){
                gr = input();
                saveGrammar(args[1], gr);
            }
        } else {
            gr = input();
        }

        Type type = check(gr);

        System.out.print("Грамматика ");
        System.out.print(typeName(type));
        System.out.println(" типа");
    }

    private static void saveGrammar(String filepath, Grammar gr) {
        try(FileWriter w = new FileWriter(filepath)){
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(gr, w);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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

    private static String typeName(Type type){
        switch (type){
            case Zero: return  "нулевого";
            case ContextDependent: return "контекстно-зависимого";
            case ContextFree: return "контекстно-свободного";
            case Regular: return "регулярного";
            default: return "некорректного";
        }
    }
}
