package com.mum.ea.project.carRental.Service.ServiceImp;

import com.mum.ea.project.carRental.Dao.IRentalCompany;
import com.mum.ea.project.carRental.Model.Rentalcompany;
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
    public void add(Rentalcompany rentalCompany) {
        rentalDao.save(rentalCompany);
    }

    @Override
    public Rentalcompany getCompany(long compId) {
        return rentalDao.findById(compId).get();
    }

    @Override
    public List<Rentalcompany> getCompByLocation(String location) {
        return rentalDao.findAllByLocation(location);
    }


    @Override
    public List<Rentalcompany> getallCompany() {
        return rentalDao.findAll();
    }

    @Override
    public void update(Rentalcompany rentalCompany) {
        rentalDao.save(rentalCompany);
    }

    @Override
    public void delete(long id) {
        rentalDao.deleteById(id);
    }
}
