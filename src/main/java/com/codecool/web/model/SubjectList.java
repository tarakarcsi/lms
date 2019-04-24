package com.codecool.web.model;

import java.util.ArrayList;
import java.util.List;

public class SubjectList {
    private static SubjectList ourInstance = new SubjectList();

    private List<Subject> subjectList;

    public static SubjectList getInstance() {
        return ourInstance;
    }

    private SubjectList() {
        this.subjectList = new ArrayList<>();
    }

    public void addSubject(Subject subject) {
        subjectList.add(subject);
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public Subject findByTitle(String title) {

        for(Subject subject : this.getSubjectList()) {
            if(subject.getTitle().equals(title)) {
                return subject;
            }
        }
        return null;
    }
}
