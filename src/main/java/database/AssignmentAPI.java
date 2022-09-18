package database;

import exception.NotFoundException;
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

    public void add(Assignment assignment) throws NotFoundException {
        if(!db.courses.containsKey(assignment.getCourseId())) throw new NotFoundException("Assignment Course Not Found");

        List<Assignment> courseAssignments =  db.assignments.get(assignment.getCourseId());
        if(courseAssignments == null) {
            db.assignments.put(assignment.getCourseId(), new ArrayList<>(Collections.singletonList(assignment)));
        } else {
            courseAssignments.add(assignment);
        }
    }

    public List<Assignment> getCourseAssignments(String courseID) throws NotFoundException {
        List<Assignment> assignments = db.assignments.get(courseID);
        if(assignments != null)
            return assignments.stream().map(Assignment::new).collect(Collectors.toList());
        else
            throw new NotFoundException("Course Not Found");
    }

    public void submitAssignment(AssignmentSubmission assignmentSubmission) throws NotFoundException {

        if(!db.courses.containsKey(assignmentSubmission.getCourseId())) throw new NotFoundException("Assignment Submission Course Not Found");

        List<Assignment> assignments =  db.assignments.get(assignmentSubmission.getCourseId()).stream()
                .filter(assignment -> assignment.getId().equals(assignmentSubmission.getAssignmentId()))
                .collect(Collectors.toList());

        if(assignments.size() == 0) throw new NotFoundException("Assignment Not Found");

        Assignment assignment = assignments.get(0);
        assignment.submitAssignment(assignmentSubmission);

    }

}
