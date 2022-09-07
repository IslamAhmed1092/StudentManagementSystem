package system;

import java.util.Date;

public class Assignment {
    private String id;
    private String description;
    private String courseId;
    private Date dueDate;

    private AssignmentSubmission assignmentSubmission;

    private static long idCounter = 0;

    public Assignment(String description, String courseId, Date dueDate) {
        this.id = String.valueOf(idCounter++);
        this.description = description;
        this.courseId = courseId;
        this.dueDate = dueDate;
        this.assignmentSubmission = null;
    }

    public Assignment(Assignment other) {
        this.id = other.id;
        this.description = other.description;
        this.courseId = other.courseId;
        this.dueDate = other.dueDate;
        this.assignmentSubmission = other.assignmentSubmission;
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

    public AssignmentSubmission getAssignmentSubmission() {
        return assignmentSubmission;
    }

    public void submitAssignment(AssignmentSubmission assignmentSubmission) {
        this.assignmentSubmission = assignmentSubmission;
    }

}
