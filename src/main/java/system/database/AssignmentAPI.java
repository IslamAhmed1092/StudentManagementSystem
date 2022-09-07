package system.database;

import system.Assignment;
import system.AssignmentSubmission;
import system.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<Assignment> getAssignments(String courseID) {
        return db.assignments.get(courseID).stream().map(Assignment::new).collect(Collectors.toList());
    }

    public void submitAssignment(AssignmentSubmission assignmentSubmission) {

        List<Assignment> assignments =  db.assignments.get(assignmentSubmission.getCourseId()).stream()
                .filter(assignment -> assignment.getId().equals(assignmentSubmission.getAssignmentId()))
                .collect(Collectors.toList());

        if(assignments.size() == 0) return;

        Assignment assignment = assignments.get(0);
        assignment.submitAssignment(assignmentSubmission);

    }

}
