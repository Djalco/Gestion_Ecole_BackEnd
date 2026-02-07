package ecole.gestionecole.services;

import java.util.List;

import ecole.gestionecole.DTO.AdminDTO;

public interface  AdminService {
    //-----------
    // CRUD operations for Admin
    //-----------
    List<AdminDTO> getAllAdmins();
    AdminDTO getAdminById(Integer id);  
    AdminDTO createAdmin(AdminDTO adminDTO);
    AdminDTO updateAdmin(Integer id, AdminDTO adminDTO);
    void deleteAdmin(Integer id);
}
