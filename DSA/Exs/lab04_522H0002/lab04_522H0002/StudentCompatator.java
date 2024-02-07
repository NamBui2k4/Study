import java.util.Comparator;
class StudentComparator implements Comparator<Student>{
    @Override
    public int compare(Student f1, Student f2) {
        double gap =  f1.averageGrade() - f2.averageGrade();
        if (gap > 0.0 ) return  1;
        if (gap < 0.0) return -1;
        return 0;
    }
}