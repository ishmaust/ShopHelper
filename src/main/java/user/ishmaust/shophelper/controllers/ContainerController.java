package user.ishmaust.shophelper.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import user.ishmaust.shophelper.repositories.entity.Container;
import user.ishmaust.shophelper.servicies.ContainerOperationService;

@RestController
@CrossOrigin(origins = "http://localhost:8080/")
@RequestMapping("/container")
public class ContainerController {
  private final ContainerOperationService containerService;

  @Autowired
  public ContainerController(ContainerOperationService containerService) {
    this.containerService = containerService;
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Container> addContainer(@RequestBody Container bodyContainer) {
    return new ResponseEntity<>(containerService.addEntity(bodyContainer), HttpStatus.CREATED);
  }
}
