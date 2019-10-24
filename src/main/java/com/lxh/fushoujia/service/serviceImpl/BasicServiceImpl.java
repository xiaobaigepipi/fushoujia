package com.lxh.fushoujia.service.serviceImpl;

import com.lxh.fushoujia.mapper.BasicMapper;
import com.lxh.fushoujia.pojo.*;
import com.lxh.fushoujia.service.BasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: fushoujia
 * @description:
 * @author: Mr.Wang
 * @create: 2019-10-15 16:14
 **/
@Service
public class BasicServiceImpl implements BasicService {

    @Autowired
    BasicMapper basic;

    @Override
    public List<Department> listDepartment() {
        return basic.listDepartment();
    }

    @Override
    public int addDepartment(Department d) {
        return basic.addDepartment(d);
    }

    @Override
    public void updateDepartment(Department department) {
        basic.updateDepartment(department);
    }

    @Override
    public List<Department> listDepartmentByTrue() {
        return basic.listDepartmentByTrue();
    }

    @Override
    public void updateDepartmentDelete(Department department) {
        basic.updateDepartmentDelete(department);
    }

    @Override
    public List<Position> listPosition() {
        return basic.listPosition();
    }

    @Override
    public int addPosition(Position d) {
        return basic.addPosition(d);
    }

    @Override
    public void updatePosition(Position position) {
        basic.updatePosition(position);
    }

    @Override
    public List<Position> listPositionByTrue() {
        return basic.listPositionByTrue();
    }

    @Override
    public List<IncomeOutCategory> listIncomeOutCategory() {
        return basic.listIncomeOutCategory();
    }

    @Override
    public int addIncomeOutCategory(IncomeOutCategory d) {
        return basic.addIncomeOutCategory(d);
    }

    @Override
    public void updateIncomeOutCategory(IncomeOutCategory incomeOutCategory) {
        basic.updateIncomeOutCategory(incomeOutCategory);
    }

    @Override
    public void deleteIncomeOutCategory(int id) {
        basic.deleteIncomeOutCategory(id);
    }

    @Override
    public List<SupplierType> listSupplierType() {
        return basic.listSupplierType();
    }

    @Override
    public int addSupplierType(SupplierType d) {
        return basic.addSupplierType(d);
    }

    @Override
    public void updateSupplierType(SupplierType supplierType) {
        basic.updateSupplierType(supplierType);
    }

    @Override
    public void deleteSupplierType(int id) {
        basic.deleteSupplierType(id);
    }

    @Override
    public List<ProjectType> listProjectType() {
        return basic.listProjectType();
    }

    @Override
    public int addProjectType(ProjectType d) {
        return basic.addProjectType(d);
    }

    @Override
    public void updateProjectType(ProjectType projectType) {
        basic.updateProjectType(projectType);
    }

    @Override
    public void deleteProjectType(int id) {
        basic.deleteProjectType(id);
    }

    @Override
    public List<ProjectProperty> listProjectProperty() {
        return basic.listProjectProperty();
    }

    @Override
    public int addProjectProperty(ProjectProperty d) {
        return basic.addProjectProperty(d);
    }

    @Override
    public void updateProjectProperty(ProjectProperty projectProperty) {
        basic.updateProjectProperty(projectProperty);
    }

    @Override
    public void deleteProjectProperty(int id) {
        basic.deleteProjectProperty(id);
    }

    @Override
    public List<Province> listProvince() {
        return basic.listProvince();
    }

    @Override
    public int addProvince(Province d) {
        return basic.addProvince(d);
    }

    @Override
    public void updateProvince(Province province) {
        basic.updateProvince(province);
    }

    @Override
    public void deleteProvince(int id) {
        basic.deleteProvince(id);
    }

    @Override
    public List<City> listCity(int id) {
        List<City> list =  basic.listCity(id);
        return list;
    }

    @Override
    public int addCity(City d) {
        return basic.addCity(d);
    }

    @Override
    public void updateCity(City city) {
        basic.updateCity(city);
    }

    @Override
    public void deleteCity(int id) {
        basic.deleteCity(id);
    }

    @Override
    public List<Area> listArea(int id) {
        List<Area> list =  basic.listArea(id);
        City c = basic.getCity(id);

        for (Area a : list) {
            a.setCity(c);
        }

        return list;
    }

    @Override
    public int addArea(Area d) {
        return basic.addArea(d);
    }

    @Override
    public void updateArea(Area area) {
        basic.updateArea(area);
    }

    @Override
    public void deleteArea(int id) {
        basic.deleteArea(id);
    }

    @Override
    public Province getProvince(int id) {
        return basic.getProvince(id);
    }

    @Override
    public City getCity(int id) {
        return basic.getCity(id);
    }

    @Override
    public Department getDepartment(int id) {
        return basic.getDepartment(id);
    }

    @Override
    public Position getPosition(int id) {
        return basic.getPosition(id);
    }


}
