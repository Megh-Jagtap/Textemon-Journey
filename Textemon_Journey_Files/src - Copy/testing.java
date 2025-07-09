public class testing {
    public static void main(String[] args) {
//        Battle battle = new Battle(Water_type.Textemon_W.SQUIRTLE, Fire_type.Textemon_F.CHARMENDAR);
//        Battle battle = new Battle(Electric_type.Textemon_E.PIKACHU, Water_type.Textemon_W.SQUIRTLE);
//        Battle battle = new Battle(Grass_type.Textemon_G.BULBOSAUR, Electric_type.Textemon_E.PIKACHU);
//        Battle battle1 = new Battle(Grass_type.Textemon_G.BULBOSAUR, Electric_type.Textemon_E.PIKACHU);
        Battle battle = new Battle(Fire_type.Textemon_F.CHARMENDAR, Grass_type.Textemon_G.BULBOSAUR);

        boolean test = battle.startBattle();
//        battle1.startBattle();
//        System.out.println(test);
    }
}