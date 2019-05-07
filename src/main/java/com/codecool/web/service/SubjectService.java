package com.codecool.web.service;

import com.codecool.web.database.dao.SubjectDao;

public class SubjectService {

    private SubjectDao subjectDao;

    public SubjectService(SubjectDao subjectDao) {
        this.subjectDao = subjectDao;
    }


}
