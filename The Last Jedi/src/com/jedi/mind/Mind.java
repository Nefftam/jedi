package com.jedi.mind;

public class Mind {

    Energy energy;
    MindMap mindMap;

    public void work(){}

    public Satisfaction familyWork(TimeRange t){return new Satisfaction();}

    public Health healthWork(TimeRange t){return new Health();}

    public Money moneyWork(TimeRange t, Investment investment , Skill skill , Poker poker)
    {return new Money();}

    public void selfWork(Rest rest, Poker poker ,Videos videos , WriteUps writeUps , Skill skill){}

    Mind(Energy energy, MindMap mindMap){}

    static {
        System.out.println("****Mystery is within us****");
        System.out.println("****Different Energy leads to different Vibrations****");
        System.out.println("****Energy can't be created nor can be destroyed , it only changes from one form to another****");
        System.out.println("****Work Done by all Forces equals change in K.Energy****");
        System.out.println("****Survival of the Fittest****");
        System.out.println("****Mind is a frame of Reference****");
        System.out.println("****Life is to live your mind****");
        System.out.println("****Without work this mind is pseudo limbo of fantasy causing unreal stress and happiness****");
        System.out.println("****Death is the ultimate Truth inside a frame of Reference and mystery in another****");
    }

    public static void main(String[] args) {
        new Mind(new Energy(), new MindMap());
    }
}

class Family{}
class Money{public void buys(Object obj){}}
class Health{}


class Skill{
    public Skill improveSkill(TimeRange timeRange, Java java, Scala scala, DataStructure dataStructure,
                              Sports sports, Coder coder){return new Skill();}
}
class Poker{
    public void improvePoker(TimeRange timeRange, Money money){}
}
class Satisfaction{}
class TimeRange{}
class Investment{}
class Rest{}
class Videos{}
class Coder{}
class Java{}
class Scala{}
class DataStructure{}
class WriteUps{}
class Sports{}
enum DynamicTraits{PATIENCE,HARDWORK,FOCUS,HONESTY,INTEREST,ANGER,IMPATIENCE,DISHONESTY,SHARPNESS,SELFRESPECT,CUNNINGNESS,
    LAZINESS,MAGICAL,MYSTERY,CONFIDENCE,CARING,SELFLESS,AMBITIOUS,FANTASY,POSITIVE,NEGATIVE,GOOD,BAD,STRESS,HAPPINESS,BEAUTY,
    CRUELTY,EMPATHY,ETC;}
class WIRING{}
class Energy{}
class MindMap{DynamicTraits dynamicTraits;WIRING wiring;}
