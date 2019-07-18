package com.mum.ea.project.carRental.Service;

import com.mum.ea.project.carRental.Model.RentalCompany;

import java.util.List;

public interface RentalCompanyService {
    public void add(RentalCompany rentalCompany);
    public RentalCompany getCompany(long compId);
    public List<RentalCompany> getCompByLocation(String location);
    public List<RentalCompany> getallCompany();
    public void update(RentalCompany rentalCompany);
    public void delete(long id);


}
