package com.lxh.fushoujia.service.serviceImpl;

import com.lxh.fushoujia.mapper.PaymentNodeMapper;
import com.lxh.fushoujia.mapper.ProjectMapper;
import com.lxh.fushoujia.pojo.Document;
import com.lxh.fushoujia.pojo.PaymentNode;
import com.lxh.fushoujia.pojo.Project;
import com.lxh.fushoujia.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    @Autowired
    PaymentNodeMapper paymentNodeMapper;

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

    @Override
    public List<PaymentNode> listPaymentNode(Integer id) {
        return paymentNodeMapper.listPaymentNode(id);
    }

    @Override
    public int updatePaymentNode(PaymentNode paymentNode) {
        return paymentNodeMapper.updatePaymentNode(paymentNode);
    }

    @Override
    public int addPaymentNode(PaymentNode paymentNode) {
        return paymentNodeMapper.addPaymentNode(paymentNode);
    }

    @Override
    public int addDocument(Document document) {
        return projectMapper.addDocument(document);
    }

    @Override
    public List<Document> listDocumentByProject(Integer id) {
        return projectMapper.listDocumentByProject(id);
    }

    @Override
    public int deleteDocument(Integer id) {
        return projectMapper.deleteDocument(id);
    }

    @Override
    public List<Project> listAllProject() {
        return projectMapper.listAllProject();
    }

    @Override
    public List<Document> listDocumentByContract(Integer id) {
        return projectMapper.listDocumentByContract(id);
    }

    @Override
    public Document getDocument(Integer id) {
        return projectMapper.getDocument(id);
    }

    @Override
    public List<PaymentNode> listPaymentNodeByTime(Date date) {
        return paymentNodeMapper.listPaymentNodeByTime(date);
    }
}
