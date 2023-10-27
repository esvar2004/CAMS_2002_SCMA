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

    public Camp(String name, String openDate, String closeDate, String regClose, String school, int totSlots, int commSlots, String desc, String nameOfStaff)
    {
        this.name = name;
        this.openDate = openDate;
        this.closeDate = closeDate;
        this.regClose = regClose;
        this.school = school;
        this.totSlots = totalSlots;
        this.commSlots = commSlots;
        this.desc = desc;
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

    private void setSchool(String school)
    {
        this.school = school;
    }

    private void setTotSlots(int totSlots)
    {
        this.totSlots = totSlots;
    }

    private void setCommSlots(int commSlots)
    {
        this.commSlots = commSlots;
    }

    private void setDesc(String desc)
    {
        this.desc = desc;
    }

    private string getName()
    {
        return this.name;
    }
    
    private String getOpenDate()
    {
        return this.openDate;
    }
    
    private String getCloseDate()
    {
        return this.closeDate;
    }
    
    private String getRegDate()
    {
        return this.regClose;
    }

    private String getSchool()
    {
        return this.school;
    }

    private int getTotSlots()
    {
        return this.totSlots;
    }

    private int getCommSlots()
    {
        return this.commSlots;
    }

    private String getStaffName()
    {
        return this.nameOfStaff;
    }
    
    private String getDesc()
    {
        return this.desc;
    }
}
