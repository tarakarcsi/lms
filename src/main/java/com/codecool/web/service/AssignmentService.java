package com.codecool.web.service;

import com.codecool.web.database.dao.AssignmentDao;
import com.codecool.web.model.Assignment;

import java.util.List;

public class AssignmentService {

    private AssignmentDao assignmentDao;

    public AssignmentService(AssignmentDao assignmentDao) {
        this.assignmentDao = assignmentDao;
    }

    public void insertAssignment(Assignment assignment) {
        assignmentDao.addAssignment(assignment);
    }

    public Assignment findAssignment(String title) {
        return assignmentDao.getAssignment(title);
    }

    public List<Assignment> findAssignments() {
        return assignmentDao.getAssignments();
    }
}
