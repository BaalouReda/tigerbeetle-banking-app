package com.poc.banking.transaction.clients;


import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    ClientDao toDao(ClientDto clientDto){
        ClientDao clientDao = new ClientDao();
        clientDao.setId(clientDto.getId());
        clientDao.setFamillyName(clientDto.getFamillyName());
        clientDao.setFirstName(clientDto.getFirstName());
        clientDao.setEmail(clientDto.getEmail());
        clientDao.setPhone(clientDto.getPhone());
        clientDao.setAddress(clientDto.getAddress());
        clientDao.setCity(clientDto.getCity());
        return clientDao;
    }
    ClientDto toDto(ClientDao clientDao){
        ClientDto clientDto = new ClientDto();
        clientDto.setId(clientDao.getId());
        clientDto.setFamillyName(clientDao.getFamillyName());
        clientDto.setFirstName(clientDao.getFirstName());
        clientDto.setEmail(clientDao.getEmail());
        clientDto.setPhone(clientDao.getPhone());
        clientDto.setAddress(clientDao.getAddress());
        clientDto.setCity(clientDao.getCity());
        return clientDto;
    }
}
