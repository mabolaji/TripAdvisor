package com.mum.ea.project.carRental.Service;

import com.mum.ea.project.carRental.Model.Rentalcompany;

import java.util.List;

public interface RentalCompanyService {
    public void add(Rentalcompany rentalCompany);
    public Rentalcompany getCompany(long compId);
    public List<Rentalcompany> getCompByLocation(String location);
    public List<Rentalcompany> getallCompany();
    public void update(Rentalcompany rentalCompany);
    public void delete(long id);


}
