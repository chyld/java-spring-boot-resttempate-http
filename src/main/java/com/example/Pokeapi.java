package com.example;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class Pokeapi {
    private String name;
    private int id;
    private Map generation;
    private Map moveDamageClass;
    private List<Pokemon> pokemon;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map getGeneration() {
        return generation;
    }

    public void setGeneration(Map generation) {
        this.generation = generation;
    }

    @JsonProperty("move_damage_class")
    public Map getMoveDamageClass() {
        return moveDamageClass;
    }

    public void setMoveDamageClass(Map moveDamageClass) {
        this.moveDamageClass = moveDamageClass;
    }

    public List<Pokemon> getPokemon() {
        return pokemon;
    }

    public void setPokemon(List<Pokemon> pokemon) {
        this.pokemon = pokemon;
    }

    private static class Pokemon{
        public int slot;
        public Map pokemon;
    }
}
