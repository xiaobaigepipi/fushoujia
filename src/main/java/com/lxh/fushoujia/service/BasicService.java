package com.lxh.fushoujia.service;

import com.lxh.fushoujia.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BasicService {
    //部门信息的增删改查
    List<Department> listDepartment();
    int addDepartment(Department d);
    void updateDepartment(Department department);
    void updateDepartmentDelete(Department department);
    List<Department> listDepartmentByTrue();
    Department getDepartment(int id);

    //职位信息的增删改查
    List<Position> listPosition();
    int addPosition(Position d);
    void updatePosition(Position position);
    List<Position> listPositionByTrue();
    Position getPosition(int id);

    //收支类别的增删改查
    List<IncomeOutCategory> listIncomeOutCategory();
    int addIncomeOutCategory(IncomeOutCategory d);
    void updateIncomeOutCategory(IncomeOutCategory incomeOutCategory);
    void deleteIncomeOutCategory(@Param("id")int id);

    //供应商的增删改查
    List<SupplierType> listSupplierType();
    int addSupplierType(SupplierType d);
    void updateSupplierType(SupplierType supplierType);
    void deleteSupplierType(@Param("id")int id);

    //项目类型
    List<ProjectType> listProjectType();
    int addProjectType(ProjectType d);
    void updateProjectType(ProjectType projectType);
    void deleteProjectType(@Param("id")int id);

    //项目属性
    List<ProjectProperty> listProjectProperty();
    int addProjectProperty(ProjectProperty d);
    void updateProjectProperty(ProjectProperty projectProperty);
    void deleteProjectProperty(@Param("id")int id);

    //省份信息
    List<Province> listProvince();
    Province getProvince(@Param("id")int id);
    int addProvince(Province d);
    void updateProvince(Province province);
    void deleteProvince(@Param("id")int id);

    //城市信息
    List<City> listCity(@Param("id") int id);
    City getCity(@Param("id") int id);
    int addCity(City d);
    void updateCity(City city);
    void deleteCity(@Param("id")int id);

    //地区信息
    List<Area> listArea(@Param("id")int id);
    int addArea(Area d);
    void updateArea(Area area);
    void deleteArea(@Param("id")int id);
}
