package com.lxh.fushoujia.service.serviceImpl;

import com.lxh.fushoujia.mapper.ProjectMapper;
import com.lxh.fushoujia.pojo.Project;
import com.lxh.fushoujia.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/*
 * @PackageName: com.lxh.fushoujia.service.serviceImpl
 * @ClassName: ProjectServiceImpl
 * @Description:
 * @author: 辉gdhasdh
 * @date: 2019/10/30 19:20
 * */
@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    ProjectMapper projectMapper;

    @Override
    public int addProject(Project project) {
        return projectMapper.addProject(project);
    }


    @Override
    public List<Project> listProject(Map<String, Object> map) {
        return projectMapper.listProject(map);
    }

    @Override
    public int updateProject(Project project) {
        return projectMapper.updateProject(project);
    }

    @Override
    public int getTotal(Map<String, Object> map) {
        return projectMapper.getTotal(map);
    }

    @Override
    public Project getProject(Integer id) {
        return projectMapper.getProject(id);
    }

    @Override
    public String getCode() {
        return projectMapper.getCode();
    }
}
