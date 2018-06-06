import java.util.ArrayList;

class Monster_list {
    private static ArrayList<Monster> Monster = new ArrayList<>();

    public static void clear() {
    	Monster.clear();
    }

    public static void addMonster(char type, int X, int Y) {
        switch (type){
            case '0':
            	Monster.add(new Orc(X, Y));
                break;
            case '1':
            	Monster.add(new Archer(X, Y));
                break;
            case '2':
                Monster.add(new Spear(X, Y));
                break;
        }
    }
    public static void runMonsters(){
        for(Monster baddie: Monster)
            baddie.action();
    }
    public static void attackMonster(int Ypos,int Xpos){
        for (int i = 0; i < Monster.size(); i++) {
            Monster tempMonster = Monster.get(i);
            if (tempMonster.getX() == Xpos &&  tempMonster.getY() == Ypos) {
                tempMonster.takeDamage(Player.Attack);
                if (tempMonster.HP <= 0) {
                    Dungeon.getRoom()[tempMonster.getY()][tempMonster.getX()] = ' ';
                    Monster.remove(i);
                    Dungeon.killCount++;
                    System.out.println("Monster died");
                }
            }
        }
    }
}
