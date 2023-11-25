import java.util.*;

public class Filter{
    ArrayList<Camp> sortingList;
    ArrayList<Camp> inputList;

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
}