package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Assignment {
    private String id;
    private String description;
    private String courseId;
    private Date dueDate;

    private List<AssignmentSubmission> assignmentSubmissions;

    private static long idCounter = 0;

    public Assignment(String description, String courseId, Date dueDate) {
        this.id = String.valueOf(idCounter++);
        this.description = description;
        this.courseId = courseId;
        this.dueDate = dueDate;
        this.assignmentSubmissions = new ArrayList<>();
    }

    @SuppressWarnings("IncompleteCopyConstructor")
    public Assignment(Assignment other) {
        this.id = other.id;
        this.description = other.description;
        this.courseId = other.courseId;
        this.dueDate = other.dueDate;
        this.assignmentSubmissions = new ArrayList<>(other.assignmentSubmissions);
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public List<AssignmentSubmission> getAssignmentSubmissions() {
        return assignmentSubmissions;
    }

    public void submitAssignment(AssignmentSubmission assignmentSubmission) {
        this.assignmentSubmissions.add(assignmentSubmission);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Assignment [ID = %s, description = %s, Course ID = %s, Due Date = %s, ", id, description, courseId, dueDate.toString()));

        sb.append("submissions = ");

        sb.append("[");
        for (int i = 0; i < assignmentSubmissions.size(); i++) {
            sb.append("[");
            sb.append(assignmentSubmissions.get(i));
            sb.append("]");
            if(i != assignmentSubmissions.size()-1) sb.append(", ");
        }
        sb.append("]]");

        return sb.toString();
    }
}
