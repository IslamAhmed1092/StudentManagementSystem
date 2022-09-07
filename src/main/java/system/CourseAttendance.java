package system;

import java.util.Date;

public class CourseAttendance implements Comparable<CourseAttendance>{
    private String id;
    private String courseId;
    private String studentId;
    private Date attendanceDate;
    private String status;

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
