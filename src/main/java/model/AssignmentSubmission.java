package model;

import java.util.Date;

public class AssignmentSubmission {
    private String id;
    private String assignmentId;
    private String studentId;
    private String courseId;
    private Date submissionDate;
    private String assignmentContentSubmitted;
    private float assignmentMarks;

    private static long idCounter = 0;

    public AssignmentSubmission(String assignmentId, String studentId, String courseId, String assignmentContentSubmitted) {
        this.id = String.valueOf(idCounter++);
        this.assignmentId = assignmentId;
        this.studentId = studentId;
        this.courseId = courseId;
        this.submissionDate = new Date();
        this.assignmentContentSubmitted = assignmentContentSubmitted;
        this.assignmentMarks = 0.0f;
    }
    public AssignmentSubmission(String assignmentId, String studentId, String courseId, Date submissionDate, String assignmentContentSubmitted, float assignmentMarks) {
        this.id = String.valueOf(idCounter++);
        this.assignmentId = assignmentId;
        this.studentId = studentId;
        this.courseId = courseId;
        this.submissionDate = submissionDate;
        this.assignmentContentSubmitted = assignmentContentSubmitted;
        this.assignmentMarks = assignmentMarks;
    }

    public AssignmentSubmission(AssignmentSubmission other) {
        this.id = other.id;
        this.assignmentId = other.assignmentId;
        this.studentId = other.studentId;
        this.courseId = other.courseId;
        this.submissionDate = other.submissionDate;
        this.assignmentContentSubmitted = other.assignmentContentSubmitted;
        this.assignmentMarks = other.assignmentMarks;
    }

    public String getId() {
        return id;
    }

    public String getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(String assignmentId) {
        this.assignmentId = assignmentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getAssignmentContentSubmitted() {
        return assignmentContentSubmitted;
    }

    public void setAssignmentContentSubmitted(String assignmentContentSubmitted) {
        this.assignmentContentSubmitted = assignmentContentSubmitted;
    }

    public float getAssignmentMarks() {
        return assignmentMarks;
    }

    public void setAssignmentMarks(float assignmentMarks) {
        this.assignmentMarks = assignmentMarks;
    }

    @Override
    public String toString() {
        return String.format("Assignment Submission [ID = %s, Assignment ID = %s, Student ID = %s, Course ID = %s, Content = %s", id, assignmentId, studentId, courseId, assignmentContentSubmitted);
    }
}
