package com.lxh.fushoujia.service;

import com.lxh.fushoujia.pojo.Document;
import com.lxh.fushoujia.pojo.PaymentNode;
import com.lxh.fushoujia.pojo.Project;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ProjectService {
    int addProject(Project project);
    List<Project> listProject(Map<String, Object> map);
    int updateProject(Project project);
    int getTotal(Map<String, Object> map);
    Project getProject(Integer id);
    String getCode();

    List<PaymentNode> listPaymentNode(Integer id);
    int updatePaymentNode(PaymentNode paymentNode);
    int addPaymentNode(PaymentNode paymentNode);
    List<PaymentNode> listPaymentNodeByTime(Date date);

    int addDocument(Document document);
    List<Document> listDocumentByProject(Integer id);
    int deleteDocument(Integer id);

    List<Project> listAllProject();
    List<Document> listDocumentByContract( Integer id);
    Document getDocument(Integer id);
}
