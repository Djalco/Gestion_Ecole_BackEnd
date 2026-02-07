package ecole.gestionecole.serviceImpl;

import java.util.List;

import ecole.gestionecole.DTO.AdminDTO;
import ecole.gestionecole.entites.Admin;
import ecole.gestionecole.mapper.Mapper;
import ecole.gestionecole.repositories.AdminRepository;
import ecole.gestionecole.services.AdminService;

public class AdminServiceImpl implements AdminService {

    private AdminRepository adminRepository;
    @Override
    public List<AdminDTO> getAllAdmins() {
        List<Admin> admins = adminRepository.findAll();
        return admins.stream()
                .map(Mapper.INSTANCE::toAdminDTO)
                .toList();
    }

    @Override
    public AdminDTO getAdminById(Integer id) {
        Admin admin = adminRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin not found with id: " + id));
        return Mapper.INSTANCE.toAdminDTO(admin);
    }

    @Override
    public AdminDTO createAdmin(AdminDTO adminDTO) {
        if(adminRepository.existsByEmail(adminDTO.getEmail())) {
            throw new IllegalArgumentException("Admin with the same email already exists");
        }
        Admin admin = Mapper.INSTANCE.toAdmin(adminDTO);
        Admin savedAdmin = adminRepository.save(admin);
        return Mapper.INSTANCE.toAdminDTO(savedAdmin);
    }

    @Override
    public AdminDTO updateAdmin(Integer id, AdminDTO adminDTO) {
        Admin existingAdmin = adminRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin not found with id: " + id));

        if(!existingAdmin.getEmail().equals(adminDTO.getEmail()) 
            && adminRepository.existsByEmail(adminDTO.getEmail())) {
            throw new IllegalArgumentException("Admin with the same email already exists");
        }

        Admin updatedAdmin = Mapper.INSTANCE.toAdmin(adminDTO);
        updatedAdmin.setId(id);
        Admin savedAdmin = adminRepository.save(updatedAdmin);
        return Mapper.INSTANCE.toAdminDTO(savedAdmin);
    }

    @Override
    public void deleteAdmin(Integer id) {
        adminRepository.deleteById(id);
    }
    
    
}
