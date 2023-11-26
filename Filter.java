import java.util.*;

public class Filter{
    ArrayList<Camp> sortingList;
    ArrayList<Camp> inputList;
    
    public Filter() {
    	
    }

    public Filter(ArrayList<Camp> inputCampList){
        this.sortingList = new ArrayList<Camp>();
        this.inputList = inputCampList;
    }

    public ArrayList<Camp> filterByName(ArrayList<Camp> inputList){
        for(Camp camp : this.inputList){
            sortingList.add(camp);
        }
        // Sort the sortingList based on the camp names
        Collections.sort(sortingList, Comparator.comparing(Camp::getName));

        return sortingList;
    }

    public ArrayList<Camp> filterByDate(ArrayList<Camp> inputList){
        for(Camp camp : this.inputList){
            sortingList.add(camp);
        }
        // Sort the sortingList based on the camp open Dates
        Collections.sort(sortingList, Comparator.comparing(Camp::getOpenDate));

        return sortingList;
    }

    public ArrayList<Camp> filterByLocation(ArrayList<Camp> inputList){
        for(Camp camp : this.inputList){
            sortingList.add(camp);
        }
        // Sort the sortingList based on the camp Location
        Collections.sort(sortingList, Comparator.comparing(Camp::getLocation));

        return sortingList;
    }

    public ArrayList<Camp> filterBySchool(ArrayList<Camp> inputList){
        for(Camp camp : this.inputList){
            sortingList.add(camp);
        }
        // Sort the sortingList based on the camp School
        Collections.sort(sortingList, Comparator.comparing(Camp::getSchool));

        return sortingList;
    }
    
    public void filterCamps(ArrayList<Camp> toBeSortedCamp) {
		Filter filter = new Filter(toBeSortedCamp);
		System.out.println("How would you view your camps? Select from the following options");
		System.out.println("(1) By name");
		System.out.println("(2) By Date");
		System.out.println("(3) By Location");
		System.out.println("(4) By School");
		System.out.println("Enter your choice: ");
		Scanner sc = new Scanner(System.in);
        int filterOption;
		while (true){
            try {
            filterOption = sc.nextInt();
            if (filterOption <= 0) {
                System.out.println("Error: Please enter a positive integer.");
            } else {
                break; 
            }
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid integer.");
                sc.nextLine(); // clear buffer
            }
        }
        
		switch(filterOption)
		{
			
		case 2:
			System.out.println("Sorting by date...");
			for(Camp camp: filter.filterByDate(toBeSortedCamp))
	        {
	            System.out.println("Camp Name: " + camp.getName());
	        }			
			break;
		case 3:
			System.out.println("Sorting by location...");
			for(Camp camp: filter.filterByLocation(toBeSortedCamp))
	        {
	            System.out.println("Camp Name: " + camp.getName());
	        }			
			break;
		case 4:
			System.out.println("Sorting by school...");
			for(Camp camp: filter.filterBySchool(toBeSortedCamp))
	        {
	            System.out.println("Camp Name: " + camp.getName());
	        }			
			break;
        default:
            if (filterOption != 1) System.out.println("Invalid option, default sorting (Alphabetical):");
            System.out.println("Sorting by name...");
			for(Camp camp: filter.filterByName(toBeSortedCamp))
	        {
	            System.out.println("Camp Name: " + camp.getName());
	        }
			break;
		}
		
	}
}