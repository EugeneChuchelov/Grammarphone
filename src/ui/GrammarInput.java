package ui;

import entity.Grammar;
import entity.Rule;

import java.util.*;

public class GrammarInput {
    private static Scanner scanner = new Scanner(System.in);

    public static Grammar input(){
        System.out.println("Терминальные символы (без пробелов, через \',\')");
        String terminal = scanner.nextLine();

        System.out.println("Нетерминальные символы (без пробелов, через \',\')");
        String notTerminal = scanner.nextLine();

        System.out.println("Правила (в формате A->B|C, без пробелов, через \',\')");
        String rules = scanner.nextLine();

        Grammar grammar = new Grammar();
        grammar.setTerminal(parseSymbols(terminal));
        grammar.setNotTerminal(parseSymbols(notTerminal));
        grammar.setRules(parseRules(rules));

        return grammar;
    }

    private static List<Character> parseSymbols(String symbols){
        String[] split = symbols.split(",");

        List<Character> list = new LinkedList<>();
        for(String s : split){
            list.add(s.charAt(0));
        }

        return list;
    }

    private static Set<Rule> parseRules(String symbols){
        String[] splitRules = symbols.split(",");
        Set<Rule> ruleSet = new HashSet<>();

        for(String ruleString : splitRules){
            Rule rule = null;

            String[] parts = ruleString.split("->");
            String[] rightParts = parts[1].split("[|]");

            LinkedList<Character> from = new LinkedList<>();
            for(char c : parts[0].toCharArray()){
                from.add(c);
            }

            for(String right : rightParts){
                LinkedList<Character> to = new LinkedList<>();
                for(char c : right.toCharArray()){
                    to.add(c);
                }

                rule = new Rule();
                rule.setFrom(from);
                rule.setTo(to);
                ruleSet.add(rule);
            }

        }

        return ruleSet;
    }
}
