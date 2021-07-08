package com.falconworks.wbsedclapp.admin.mappers;

import com.falconworks.wbsedclapp.admin.dto.requests.OfficeRequestDTO;
import com.falconworks.wbsedclapp.admin.entities.Address;
import com.falconworks.wbsedclapp.admin.entities.Office;
import com.falconworks.wbsedclapp.admin.services.OfficeService;


public class OfficeRequestDTOtoOfficeEntityMapper {

    private OfficeService officeService;

    public OfficeRequestDTOtoOfficeEntityMapper(OfficeService officeService) {
        this.officeService = officeService;
    }

    public Office map(OfficeRequestDTO dto) {
        Office office = null;
        Address address = new Address(dto.getAddressLine1(), dto.getAddressLine2(), dto.getDistrict(), dto.getPinCode());
        Office existingOffice = officeService.findByOfficeCode(dto.getOfficeCode());
        //check if the dto is of an existing office
        //if not, then the request is for saving a new office
        //else, the request is for editing the existing office
        if (existingOffice == null) {
            office = new Office();
            office.setOfficeCode(dto.getOfficeCode());
        } else {
            //this will populate the id field of the returned office
            office = existingOffice;
        }
        office.setAddress(address);
        office.setOfficeLocation(dto.getOfficeLocation());
        if (dto.getParentOfficeCode() != null) {
            Office parent = officeService.findByOfficeCode(dto.getParentOfficeCode());
            office.setParentOffice(parent);
        }
        return office;
    }
}
