package tic.tac.toe.impl;

public class Player {
    public Player(String name, Symbol symbol) {
        this.name = name;
        this.symbol=symbol;
    }

    public String getName() {
        return name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    private String name;
    private Symbol symbol;


}
