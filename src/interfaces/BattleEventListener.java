package interfaces;

import java.util.*;

public interface BattleEventListener
{
    public void monsterEntrance(List<String> monsterNames);
    public void eventEntityDamage(String name, int damage);
    public void eventHeroWin();
    public void eventMonsterWin();
    public void eventEntityFaint(String name);
    public void eventDodgeAttack(String receiver, String attacker);
    public void eventAttack(String attacker, String target);
    public void eventCastSpell(String name, String mname, String itemName);
    public void eventForfeitBattle();
    public void eventUsedItem(String name, String itemName);
    public void eventNextRound(int round);
    public void eventHeroTurn();
    public void eventMonsterTurn();
}