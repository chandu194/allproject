package org.example;

@RestController
@RequestMapping("/nes")
public class NEController {

     NeService neService;

    public NEController(NeService neService) {
        this.neService = neService;
    }

    @GetMapping
    public ResponseEntity<List<NE>> getAllEmployee(){
        return new ResponseEntity<>(neService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NE> getAllEmployeeId(@PathVariable Long id){
        NE ne = neService.findById(id)
    }







}
