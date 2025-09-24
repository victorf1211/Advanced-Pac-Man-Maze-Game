public class Skill{
    String skill;
    int cd;

    public Skill(String skill, int cd)
    {
        this.skill = skill;
        this.cd = cd;
    }
    public String getSkill()
    {
        return skill;
    }
    public int getcd()
    {
        return cd;
    }
    public void minuscd()
    {
        cd--;
    }
    public void setcd(int num)
    {
        this.cd = num;
    }
}