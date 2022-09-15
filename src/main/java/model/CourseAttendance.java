package model;

import java.util.Date;

public class CourseAttendance implements Comparable<CourseAttendance>{
    private String id;
    private String courseId;
    private String studentId;
    private Date attendanceDate;
    private String status;
    private static long idCounter = 0;

    public CourseAttendance(String courseId, String studentId, Date attendanceDate, String status) {
        this.id = String.valueOf(idCounter++);
        this.courseId = courseId;
        this.studentId = studentId;
        this.attendanceDate = attendanceDate;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Date getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof CourseAttendance)) {
            return false;
        }

        CourseAttendance other = (CourseAttendance)o;

        return this.id.equals(other.id);
    }

    @Override
    public int compareTo(CourseAttendance other) {
        if(this.attendanceDate.after(other.attendanceDate))
            return 1;
        else if(this.attendanceDate.before(other.attendanceDate)) {
            return -1;
        } else {
            return id.compareTo(other.id);
        }
    }
}
