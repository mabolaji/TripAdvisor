package com.mum.ea.project.carRental.Service;



import com.mum.ea.project.carRental.Model.CarBookingRecord;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CarBookingService {
    public void add(CarBookingRecord carBookingRecord);
    public CarBookingRecord getRecordByEmail(String email);
    public List<CarBookingRecord> getallRecords();
    public void update(CarBookingRecord carBookingRecord);
    public void delete(long id);
}
