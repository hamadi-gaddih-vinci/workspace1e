public class TestSite {
    public static void main(String[] args) {
        try {
            Film mauvaisEndgame = new Film("Avengers Endgame","superhéros",181,279800000);
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
            Site superContent = new Site("www.supercontent.com");
            Film endgame = new Film("Avengers Endgame","action",181,279800000);
            Serie bigbang = new Serie("The Big Bang Theory", "comédie",279);
            Film avengers = new Film("The avengers", "action",143);
            System.out.println(superContent.ajouter(endgame));
            System.out.println(superContent.ajouter(bigbang));
            System.out.println(superContent.ajouter(avengers));
            System.out.println(superContent.toString());
        }

    }

