import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CampManager implements CampManagerInterface
{
    private Staff staff;
    public CampManager(Staff staff)
    {
       this.staff = staff;
    }

    public void createCamp()
    {
        Scanner sc = new Scanner(System.in);
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
        System.out.println("Where is the camp being held?");
        String location = sc.nextLine();
        System.out.println("What are the total number of slots available?");
        int totSlots = sc.nextInt();
        System.out.println("What are the total number of committee slots available?");
        int commSlots = sc.nextInt();
        System.out.println("What's the camp description?");
        String desc = sc.nextLine();

        Date openDate = Staff.convertStringToDate(s_openDate);
        Date closeDate = Staff.convertStringToDate(s_closeDate);
        Date regClose = Staff.convertStringToDate(s_regClose);

        Camp camp = new Camp(campName, openDate, closeDate, regClose, facName, location, totSlots, commSlots, desc, staff.getName());
        Camp.campList.add(camp);
        staff.getCreatedCamps().add(camp);
    }

    public void editCamp(Camp camp)
    {
        Scanner sc = new Scanner(System.in);
        if(camp.getStaffName() != staff.getName())
        {
            System.out.println("This camp is not under your jurisdiction.");
            return;
        }
        else
        {
            int choice = 1;
            while(choice >= 1 && choice <= 9)
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
                System.out.println("(9) Camp Visibility");
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
                    Date openDate = Staff.convertStringToDate(s_openDate);
                    camp.setOpenDate(openDate);
                    break;

                    case 3:
                    System.out.println("What should the new closing date of camp be?");
                    String s_closeDate = sc.nextLine();
                    Date closeDate = Staff.convertStringToDate(s_closeDate);
                    camp.setCloseDate(closeDate);
                    break;

                    case 4:
                    System.out.println("What should the new closing date of registration be?");
                    String s_regClose = sc.nextLine();
                    Date regClose = Staff.convertStringToDate(s_regClose);
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

                    case 9:
                    System.out.println("What should the camp's visibility be? (0/1)");
                    int visibility = sc.nextInt();
                    camp.setVisibility(visibility);
                    break;

                    default:
                    System.out.println("Please select a valid option.");
                    choice = sc.nextInt();
                }
            }
        }
    }

    public void deleteCamp(Camp camp)
    {
        Camp.campList.remove(camp); //Removes the camp from the list.
        staff.getCreatedCamps().remove(camp);
    }
}
