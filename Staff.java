import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Staff extends User
{
    Scanner sc = new Scanner(System.in);

    private ArrayList<Camp> createdCamps;
    private ArrayList<Suggestion> approvedSuggestions;

    public Staff(String name, String email, String faculty)
    {
        super(name, email, faculty);
        createdCamps = new ArrayList<Camp>();
        approvedSuggestions = new ArrayList<Suggestion>();
    }

    /*public void createCamp()
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
        System.out.println("Where is the camp being held?");
        String location = sc.nextLine();
        System.out.println("What are the total number of slots available?");
        int totSlots = sc.nextInt();
        System.out.println("What are the total number of committee slots available?");
        int commSlots = sc.nextInt();
        System.out.println("What's the camp description?");
        String desc = sc.nextLine();

        Date openDate = convertStringToDate(s_openDate);
        Date closeDate = convertStringToDate(s_closeDate);
        Date regClose = convertStringToDate(s_regClose);

        Camp camp = new Camp(campName, openDate, closeDate, regClose, facName, location, totSlots, commSlots, desc, this.getName());
        Camp.campList.add(camp);
    }*/

    public ArrayList<Camp> getCreatedCamps()
    {
        return createdCamps;
    }

    public ArrayList<Suggestion> getApprovedSuggestions()
    {
        return approvedSuggestions;
    }

    /*public void editCamp(Camp camp)
    {
        if(camp.getStaffName() != this.getName())
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
        
    }*/

    //Staff can view all of the camps they were responsible for creating.
    /*public void viewYourCamps(ArrayList<Camp> campList) 
    {
        for(int i = 0; i < campList.size(); i++)
        {
            if(campList.get(i).getStaffName().equals(this.getName()))
                System.out.println(campList.get(i));
        }
    }*/

    //Staff can toggle the visibility of any of their camps.
    /*public void toggleVis(Camp camp, boolean vis)
    {
        camp.setVisibility(vis);
    }*/

    //Staff can generate a list of all of the camps that currently exist within the system.
    /*public void campList(Camp camp)
    {
        for(int i = 0; i < camp.getList().size(); i++)
        {
            System.out.println(camp.getList().get(i));
        }
    }*/

    //Staff can view enquiries from the user.
    /*public void viewEnquiries(Student s, ArrayList<Camp> campList)
    {
        for(int i = 0; i < campList.size(); i++)
        {
            if(campList.get(i).getStaffName() == getName()) //Checks if camp is created by that staff member.
            {
                for(int j = 0; j < s.showEnquiries().size(); j++)
                {
                    if(s.showEnquiries().get(j).getCampName() == campList.get(i).getName()) //Checks if that enquiry is for a camp made by the staff member.
                    {
                        System.out.println(s.showEnquiries().get(j).getQuestion());
                    }
                }
            }
            else
                continue;
        }
    }*/

    /*public String genResponse(Enquiry e) //replyToEnquiry functionality is the same in both Staff and CommitteeMember
    {
        System.out.println("What response would you like to provide to the given enquiry?");
        String response = sc.nextLine();
        e.setResponse(response);
        return response;
    }*/

    // public List<String> viewSuggestion(CampCommitteeMember c)
    // {
    //     return c.getSuggestions();
    // }
}
