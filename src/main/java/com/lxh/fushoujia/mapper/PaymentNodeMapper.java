package com.lxh.fushoujia.mapper;

import com.lxh.fushoujia.pojo.PaymentNode;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaymentNodeMapper {
    List<PaymentNode> listPaymentNode(@Param("projectId") Integer id);
    int updatePaymentNode(PaymentNode paymentNode);
    int addPaymentNode(PaymentNode paymentNode);
}
