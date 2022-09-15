package database;

import model.Assignment;
import model.AssignmentSubmission;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AssignmentAPI{
    private final Database db;

    public AssignmentAPI() {
        this.db = Database.getInstance();
    }

    public void add(Assignment assignment) {
        List<Assignment> courseAssignments =  db.assignments.get(assignment.getCourseId());
        if(courseAssignments == null) {
            db.assignments.put(assignment.getCourseId(), new ArrayList<>(Collections.singletonList(assignment)));
        } else {
            courseAssignments.add(assignment);
        }
    }

    public List<Assignment> getCourseAssignments(String courseID) {
        List<Assignment> assignments = db.assignments.get(courseID);
        if(assignments != null)
            return assignments.stream().map(Assignment::new).collect(Collectors.toList());
        else
            return new ArrayList<>();
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
