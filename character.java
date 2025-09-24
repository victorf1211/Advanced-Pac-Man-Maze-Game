public class character{
    String name;
    int health;
    private int speed;
    private int point;
    private Skill skill;

    public character(String name, int health, int speed, int point, Skill skill)
    {
        this.name = name;
        this.health = health;
        this.speed = speed;
        this.point = point;
        this.skill = skill;
    }
    public void changeskill(Skill skill)
    {
        this.skill = skill;
    }
    public void changespeed(int num)
    {
        this.speed = num;
    }
    public void changepoint(int num)
    {
        this.point = num;
    }
    public int getspeed()
    {
        return speed;
    }
    public int getpoint()
    {
        return point;
    }
    public Skill getSkill()
    {
        return skill;
    }

}