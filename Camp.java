public class Camp
{
    private String name;
    private String openDate;
    private String closeDate;
    private String regClose;
    private String school;
    private int totSlots;
    private int commSlots;
    private String desc;
    private String nameOfStaff;
    private ArrayList<Student> campList;

    public Camp(String name, String school, int totSlots, int commSlots, String nameOfStaff)
    {
        this.name = name;
        this.school = school;
        this.totSlots = totalSlots;
        this.commSlots = commSlots;
        this.nameOfStaff = nameOfStaff;
        campList = new ArrayList<Student>();
    }

    private void setOpenDate(String openDate)
    {
        this.openDate = openDate;
    }

    private void setCloseDate(String closeDate)
    {
        this.closeDate = closeDate;
    }

    private void setRegDate(String regClose)
    {
        this.regClose = regClose;
    }

    private void setDesc(String desc)
    {
        this.desc = desc;
    }
}
