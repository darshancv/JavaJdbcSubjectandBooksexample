package subjectandbooksjdbc.entity;

public class Subject {
private int subjectId;
private String name;
public Subject() {
	super();
	// TODO Auto-generated constructor stub
}

public Subject(int subjectId, String name) {
	super();
	this.subjectId = subjectId;
	this.name = name;
}

public int getSubjectId() {
	return subjectId;
}
public void setSubjectId(int subjectId) {
	this.subjectId = subjectId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
@Override
public String toString() {
	return "Subject [subjectId=" + subjectId + ", name=" + name + "]";
}


}
