//package a2002Assignment;

import java.io.FileWriter;
import java.io.IOException;

public class ReportGenerator {
    public void generateCampReport(Camp camp) {
        try (FileWriter writer = new FileWriter(camp.getName() + "_report.txt")) {
            writer.write("Camp Report for: " + camp.getName() + "\n");
            writer.write("Open Date: " + camp.getOpenDate() + "\n");
            writer.write("Close Date: " + camp.getCloseDate() + "\n");
            writer.write("Faculty: " + camp.getSchool() + "\n");
            writer.write("Location " + camp.getLocation() + "\n");
            writer.write("Total Slots: " + camp.getTotSlots() + "\n");
            writer.write("Remaining Slots: " + camp.getAvailableSlots() + "\n");
            writer.write("Committee Slots: " + camp.getCommSlots() + "\n");
            writer.write("Description: " + camp.getDesc() + "\n\n");
            for(int i = 0; i < camp.getList().size(); i++)
            {
                writer.write("Student " + i + ": " + camp.getList().get(i).getName() + ", ");
                writer.write("Role: " + camp.getList().get(i).getRole() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generatePerformanceReport(Student member) {
        try (FileWriter writer = new FileWriter(member.getName() + "_performance_report.txt")) {
            writer.write("Performance Report for: " + member.getName() + "\n");
            writer.write("Committee Member of Camp: " + member.getCampCommMemberOf().getName() + "\n");
            writer.write("Points: " + member.getPoints() + "\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
