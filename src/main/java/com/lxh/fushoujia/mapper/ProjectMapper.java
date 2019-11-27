package com.lxh.fushoujia.mapper;

import com.lxh.fushoujia.pojo.Document;
import com.lxh.fushoujia.pojo.Project;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ProjectMapper {
    int addProject(Project project);
    List<Project> listProject(Map<String, Object> map);
    int updateProject(Project project);
    int getTotal(Map<String, Object> map);
    Project getProject(@Param("id") Integer id);
    String getCode();

    int addDocument(Document document);
    List<Document> listDocumentByProject(@Param("projectId") Integer id);
    List<Document> listDocumentByContract(@Param("contractId") Integer id);
    int deleteDocument(@Param("id") Integer id);

    List<Project> listAllProject();
    Document getDocument(Integer id);
}
