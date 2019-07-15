package com.mum.ea.project.carRental.Service.ServiceImp;

import com.mum.ea.project.carRental.Dao.IRentalCompany;
import com.mum.ea.project.carRental.Model.RentalCompany;
import com.mum.ea.project.carRental.Service.RentalCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class RentalCompanyServiceImp implements RentalCompanyService {
    @Autowired
    private IRentalCompany rentalDao;

    @Override
    public void add(RentalCompany rentalCompany) {
        rentalDao.save(rentalCompany);
    }

    @Override
    public RentalCompany getCompany(long compId) {
        return rentalDao.findById(compId).get();
    }

    @Override
    public List<RentalCompany> getCompByLocation(String location) {
        return rentalDao.findAllByLocation(location);
    }


    @Override
    public List<RentalCompany> getallCompany() {
        return rentalDao.findAll();
    }

    @Override
    public void update(RentalCompany rentalCompany) {
        rentalDao.save(rentalCompany);
    }

    @Override
    public void delete(long id) {
        rentalDao.deleteById(id);
    }
}
