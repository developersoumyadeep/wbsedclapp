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
        Office office = new Office();
        Address address = new Address(dto.getAddressLine1(), dto.getAddressLine2(), dto.getDistrict(), dto.getPinCode());
        office.setAddress(address);
        office.setOfficeCode(dto.getOfficeCode());
        office.setOfficeLocation(dto.getOfficeLocation());
        if (dto.getParentOfficeCode() != null) {
            Office parent = officeService.findByOfficeCode(dto.getParentOfficeCode());
            office.setParentOffice(parent);
        }
        return office;
    }
}
