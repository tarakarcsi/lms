package com.codecool.web.service;

import com.codecool.web.database.dao.SubjectDao;
import com.codecool.web.model.Subject;

import java.util.List;

public class SubjectService {

    private SubjectDao subjectDao;

    public SubjectService(SubjectDao subjectDao) {
        this.subjectDao = subjectDao;
    }


    public void insertSubject(Subject subject) {
        subjectDao.addSubject(subject);
    }

    public Subject findSubject(String title) {
        return subjectDao.getSubject(title);
    }

    public List<Subject> findSubjects() {
        return subjectDao.getSubjects();
    }
}
