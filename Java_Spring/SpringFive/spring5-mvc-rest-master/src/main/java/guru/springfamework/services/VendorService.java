package guru.springfamework.services;

import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.api.v1.model.VendorDTO;
import guru.springfamework.domain.Vendor;

import java.util.List;

public interface VendorService {

    List<VendorDTO> getAllVendors();

    VendorDTO getVendorById(Long Id);
//
//    VendorDTO createNewVendor(VendorDTO vendorDTO);
//
//    VendorDTO saveAndReturnVendor(Long id, VendorDTO vendorDTO);
//
//    VendorDTO patchVendor(Long id, VendorDTO vendorDTO);
//
//    void deleteVendorById(Long id);
}
