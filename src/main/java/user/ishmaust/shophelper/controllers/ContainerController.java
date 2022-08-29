package user.ishmaust.shophelper.controllers;

import java.util.List;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import user.ishmaust.shophelper.repositories.entity.Container;
import user.ishmaust.shophelper.repositories.entity.Product;
import user.ishmaust.shophelper.servicies.ContainerServiceImpl;
import user.ishmaust.shophelper.servicies.interfacies.ContainerService;

@RestController
@CrossOrigin(origins = "http://localhost:8080/")
@RequestMapping("/container")
public class ContainerController {
  private final ContainerService containerService;

  @Autowired
  public ContainerController(ContainerServiceImpl containerService) {
    this.containerService = containerService;
  }

  //POST calls
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Container> addContainer(@Valid @RequestBody Container bodyContainer) {
    return new ResponseEntity<>(containerService.addEntity(bodyContainer), HttpStatus.CREATED);
  }

  //PATCH calls
  @PatchMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Container> updateContainer(@PathVariable("id") Long id,
      @RequestBody Container container) {
    return new ResponseEntity<>(containerService.updateContainer(id, container), HttpStatus.OK);
  }

  //DELETE calls
  @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Container> deleteContainerById(@PathVariable("id") Long id) {
    return new ResponseEntity<>(containerService.deleteContainer(id), HttpStatus.OK);
  }


  //GET calls
  @GetMapping(value = "/{id}/all", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Set<Product>> getAllFromContainerById(@PathVariable("id") Long id) {
    return new ResponseEntity<>(containerService.getAllProductsFromContainerById(id), HttpStatus.OK);
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Container>> getAllContainers() {
    return new ResponseEntity<>(containerService.getAllContainers(), HttpStatus.OK);
  }
}
