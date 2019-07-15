package com.mum.ea.project.carRental.Service.ServiceImp;

import com.mum.ea.project.carRental.Dao.ICarBookingRecord;
import com.mum.ea.project.carRental.Model.CarBookingRecord;
import com.mum.ea.project.carRental.Service.CarBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class CarBookServiceImp implements CarBookingService {
    @Autowired
    private ICarBookingRecord carBookingDao;

    @Override
    public void add(CarBookingRecord carBookingRecord) {
        carBookingDao.save(carBookingRecord);
    }

    @Override
    public CarBookingRecord getRecordByEmail(String email) {
        return carBookingDao.findByEmail(email);
    }

    @Override
    public List<CarBookingRecord> getallRecords() {
        return carBookingDao.findAll();
    }

    @Override
    public void update(CarBookingRecord carBookingRecord) {
        carBookingDao.save(carBookingRecord);
    }

    @Override
    public void delete(long id) {
        carBookingDao.deleteById(id);
    }

}
