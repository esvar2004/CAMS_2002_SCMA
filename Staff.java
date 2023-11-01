import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Staff 
{
    private String name;
    private String email;
    private String faculty;
    Scanner sc = new Scanner(System.in);

    public Staff(String name, String email, String faculty)
    {
        this.name = name;
        this.email = email;
        this.faculty = faculty;
    }

    public void createCamp(ArrayList<Camp> campList)
    {
        System.out.println("What's the name of the camp?");
        String campName = sc.nextLine();
        System.out.println("What's the opening date of the camp?");
        String s_openDate = sc.nextLine();
        System.out.println("What's the closing date of the camp?");
        String s_closeDate = sc.nextLine();
        System.out.println("When does registration for this camp close?");
        String s_regClose = sc.nextLine();
        System.out.println("What faculty is it associated with?");
        String facName = sc.nextLine();
        System.out.println("What are the total number of slots available?");
        int totSlots = sc.nextInt();
        System.out.println("What are the total number of committee slots available?");
        int commSlots = sc.nextInt();
        System.out.println("What's the camp description?");
        String desc = sc.nextLine();

        Date openDate = convertStringToDate(s_openDate);
        Date closeDate = convertStringToDate(s_closeDate);
        Date regClose = convertStringToDate(s_regClose);

        Camp camp = new Camp(campName, openDate, closeDate, regClose, facName, totSlots, commSlots, desc, this.name);
        campList.add(camp);
    }
    public Date convertStringToDate(String s){
        LocalDate ldate = LocalDate.parse(s, DateTimeFormatter.BASIC_ISO_DATE);
        Date date = Date.from(ldate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        return date;
    }

    public void editCamp(Camp camp)
    {
        if(camp.getStaffName() != this.name)
        {
            System.out.println("This camp is not under your jurisdiction.");
            return;
        }
        else
        {
            int choice = 1;
            while(choice >= 1 && choice <= 8)
            {
                System.out.println("What characteristic of the camp would you like to edit?");
                System.out.println("(1) Camp Name");
                System.out.println("(2) Opening Date of Camp");
                System.out.println("(3) Closing Date of Camp");
                System.out.println("(4) Closing Date for Registration");
                System.out.println("(5) Faculty");
                System.out.println("(6) Number of Slots");
                System.out.println("(7) Number of Committee Slots");
                System.out.println("(8) Camp Description");
                choice = sc.nextInt();

                switch(choice)
                {
                    case 1:
                    System.out.println("What should the new name of the camp be?");
                    String campName = sc.nextLine();
                    camp.setName(campName);
                    break;

                    case 2:
                    System.out.println("What should the new opening date of camp be?");
                    String s_openDate = sc.nextLine();
                    Date openDate = convertStringToDate(s_openDate);
                    camp.setOpenDate(openDate);
                    break;

                    case 3:
                    System.out.println("What should the new closing date of camp be?");
                    String s_closeDate = sc.nextLine();
                    Date closeDate = convertStringToDate(s_closeDate);
                    camp.setCloseDate(closeDate);
                    break;

                    case 4:
                    System.out.println("What should the new closing date of registration be?");
                    String s_regClose = sc.nextLine();
                    Date regClose = convertStringToDate(s_regClose);
                    camp.setRegDate(regClose);
                    break;

                    case 5:
                    System.out.println("What should the faculty of the camp be?");
                    String school = sc.nextLine();
                    camp.setSchool(school);
                    break;

                    case 6:
                    System.out.println("How many total slots should there be?");
                    int totSlots = sc.nextInt();
                    camp.setTotSlots(totSlots);
                    break;

                    case 7:
                    System.out.println("How many total committee slots should there be?");
                    int commSlots = sc.nextInt();
                    camp.setCommSlots(commSlots);
                    break;

                    case 8:
                    System.out.println("What should the new camp description be?");
                    String desc = sc.nextLine();
                    camp.setDesc(desc);
                    break;

                    default:
                    System.out.println("Please select a valid option.");
                    choice = sc.nextInt();
                }
            }
        }
        
    }

    public void viewAllCamps(ArrayList<Camp> campList)
    {
        for(int i = 0; i < campList.size(); i++)
        {
            System.out.println(campList.get(i));
        }
    }

    public void viewYourCamps(ArrayList<Camp> campList)
    {
        for(int i = 0; i < campList.size(); i++)
        {
            if(campList.get(i).getStaffName().equals(name))
                System.out.println(campList.get(i));
        }
    }

    public void toggleVis(Camp camp, boolean vis)
    {
        camp.setVisibility(vis);
    }

    public void campList(Camp camp)
    {
        for(int i = 0; i < camp.getList().size(); i++)
        {
            System.out.println(camp.getList().get(i));
        }
    }
}
