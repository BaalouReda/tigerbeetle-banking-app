package com.poc.banking.transaction.clients;

import jakarta.transaction.Transactional;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.stream.StreamSupport;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackOn = Exception.class)
public class ClientServiceImpl {

    public static final Logger log = LogManager.getLogger(ClientServiceImpl.class);

    public static @Value("app.cin.path") String CIN;

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    public Page<ClientDto> getClients(int page, int size) {
            log.info("Getting all clients with pagination");
            return clientRepository.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "id")))
                    .map(clientMapper::toDto);
        }

        public List<ClientDto> getClients() {
            log.info("Getting all clients");
            return   StreamSupport.stream(clientRepository.findAll(Sort.by(Sort.Direction.ASC, "id")).spliterator(), false)
                    .map(clientMapper::toDto)
                    .collect(Collectors.toList());
        }

        public ClientDto createClient(ClientDto clientDto, MultipartFile file) {
            log.info("Creating a new client");
            ClientDao clientDao = clientMapper.toDao(clientDto);
            try {
                File cinFile = new File(CIN + file.getOriginalFilename());
                FileUtils.writeByteArrayToFile(cinFile, file.getBytes());
                clientDao.setCinImagePath(cinFile.getPath());
            } catch (IOException e) {
                log.error("Error while saving file", e);
            }
            clientDao = clientRepository.save(clientDao);
            return clientMapper.toDto(clientDao);
        }

        public ClientDto getClient(Long id) {
            log.info("Getting client by id = " + id);
            return clientRepository.findById(id)
                    .map(clientMapper::toDto)
                    .orElseThrow(() -> new RuntimeException("Client not found"));
        }

        public void deleteClient(Long id) {
            log.info("Deleting client by id = " + id);
            clientRepository.deleteById(id);
        }
}
