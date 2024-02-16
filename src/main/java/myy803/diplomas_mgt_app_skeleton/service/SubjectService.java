package myy803.diplomas_mgt_app_skeleton.service;

import java.util.List;

import org.springframework.stereotype.Service;

import myy803.diplomas_mgt_app_skeleton.Application;
import myy803.diplomas_mgt_app_skeleton.Subject;
import myy803.diplomas_mgt_app_skeleton.Thesis;

@Service
public interface SubjectService {
    public void saveSubject(Subject subject);
    public void deleteSubject(Subject subject);
    public Subject findById(int id);
    public List<Subject> findAll();
    public List<Subject> findAvailableSubjects();   
    public List<Application> findAllBySubject(Subject subject);
    public Thesis findBySubject(Subject subject);
}
