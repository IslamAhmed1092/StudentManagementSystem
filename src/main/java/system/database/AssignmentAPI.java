package system.database;

import system.Assignment;
import system.Teacher;

import java.util.ArrayList;
import java.util.List;

public class AssignmentAPI {
    private final Database db;

    public AssignmentAPI() {
        this.db = Database.getInstance();
    }

    public void addAssignment(Assignment assignment) {
        List<Assignment> courseAssignments =  db.assignments.get(assignment.getCourseId());
        if(courseAssignments == null) {
            courseAssignments = new ArrayList<>();
        }

        courseAssignments.add(assignment);
    }

}
