package ecole.gestionecole.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import ecole.gestionecole.DTO.AdminDTO;
import ecole.gestionecole.entites.Admin;
import ecole.gestionecole.mapper.Mapper;
import ecole.gestionecole.repositories.AdminRepository;
import ecole.gestionecole.services.AdminService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;
    private final Mapper mapper;
    
    @Override
    public List<AdminDTO> getAllAdmins() {
        List<Admin> admins = adminRepository.findAll();
        return admins.stream()
                .map(mapper::toAdminDTO)
                .toList();
    }

    @Override
    public AdminDTO getAdminById(Integer id) {
        Admin admin = adminRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin not found with id: " + id));
        return mapper.toAdminDTO(admin);
    }

    @Override
    public AdminDTO createAdmin(AdminDTO adminDTO) {
        if(adminRepository.existsByEmail(adminDTO.getEmail())) {
            throw new IllegalArgumentException("Admin with the same email already exists");
        }
        Admin admin = mapper.toAdmin(adminDTO);
        Admin savedAdmin = adminRepository.save(admin);
        return mapper.toAdminDTO(savedAdmin);
    }

    @Override
    public AdminDTO updateAdmin(Integer id, AdminDTO adminDTO) {
        Admin existingAdmin = adminRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin not found with id: " + id));

        if(!existingAdmin.getEmail().equals(adminDTO.getEmail()) 
            && adminRepository.existsByEmail(adminDTO.getEmail())) {
            throw new IllegalArgumentException("Admin with the same email already exists");
        }

        Admin updatedAdmin = mapper.toAdmin(adminDTO);
        updatedAdmin.setId(id);
        Admin savedAdmin = adminRepository.save(updatedAdmin);
        return mapper.toAdminDTO(savedAdmin);
    }

    @Override
    public void deleteAdmin(Integer id) {
        adminRepository.deleteById(id);
    }
}