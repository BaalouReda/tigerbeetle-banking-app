package com.poc.banking.transaction.clients;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController("/api/v1/client")
public class ClientController {


  private final ClientServiceImpl clientService;
  public static final Logger log = LogManager.getLogger(ClientController.class);

  @Autowired
  public ClientController(ClientServiceImpl clientService) {
        this.clientService = clientService;
  }

    @GetMapping("/all")
    public ResponseEntity<?> getClients() {
        log.info("Getting all clients");
        return new ResponseEntity<>(clientService.getClients(), HttpStatusCode.valueOf(200)) ;
    }
    @GetMapping("/all/pagination")
    public ResponseEntity<?> getClients(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size ) {
        log.info("Getting all clients with pagination");
        return new ResponseEntity<>(clientService.getClients(page, size), HttpStatusCode.valueOf(200)) ;
    }
    @GetMapping
    public ResponseEntity<?> createClient( @RequestPart("client") ClientDto clientDto ,  @RequestPart("fil") MultipartFile file) {
        log.info("Creating a new client");
        return new ResponseEntity<>(clientService.createClient(clientDto,file), HttpStatusCode.valueOf(201)) ;
    }
    @PostMapping("/{id}")
    public  ResponseEntity<?> getClient(@PathVariable(name = "id") long id) {
        log.info("Getting client by id = " + id);
        return new ResponseEntity<>(clientService.getClient(id), HttpStatusCode.valueOf(200)) ;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable(name = "id") long id) {
        log.info("Deleting client by id = " + id);
        clientService.deleteClient(id);
        return new ResponseEntity<>(HttpStatusCode.valueOf(204)) ;
    }

}
